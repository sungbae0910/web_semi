/**
 *  reserve_insert.js
 *  : 예약할 때 사용하는 js
 */

var msg_k = ""; // 결제하기 버튼을 눌렀을 때의 결과
var href_k = ""; // 팝업창으로 띄울 페이지의 url경로

//-------------------------------------------------------------------
//결제 API에 쓰이는 함수 및 변수들
//-------------------------------------------------------------------
let pay_iamport = function() {
	var IMP = window.IMP;
	IMP.init('imp07869343');
	
	let userID = rsForm_k.email.value;
	let rName = rsForm_k.roomName.value; // 방이름
	let price = rsForm_k.price.value; // 가격
	let uName = rsForm_k.reserve_name_k.value; // 예약자 이름
	let uPhone = rsForm_k.reserve_Phone_k.value; // 예약자 번호
	
	IMP.request_pay({
	    pg : 'nice', // version 1.1.0부터 지원. danal or inicis or nice
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : rName,
	    amount : price,
	    buyer_email : userID,
	    buyer_name : uName,
	    buyer_tel : uPhone
	}, function(rsp) {
	    if ( rsp.success ) {
	    	insertAjax_k();
	    } else {
	    	msg_k = rsp.error_msg;
	    	reserveR_k("reserve/reserve_ok.jsp");
	    }
	});
}

let pay_kakao = function(email) {
	let userID = rsForm_k.email.value; // 유저 아이디
	let roomName = rsForm_k.roomName.value; // 방이름
	let price = rsForm_k.price.value; // 가격
	$.ajax({
		url : "kakaoPay.kk",
		method : "post",
		data : {
				"email" : userID,
				"roomName" : roomName,
				"price" : price
				},
		dataType : "text",
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			// window.name = "부모창 이름"; 
            window.name = "parentForm";
            //document.domain = "localhost"; //document.domain 값이 팝업과 부모창 동일해야 합니다.
            // window.open("open할 window", "자식창 이름", "팝업창 옵션");
            window.open(data, "childForm", "width=570, height=700, resizable = no, scrollbars = no");  
			//window.open(data);
		},
		error : function(e) {
			//alert(e.responseText);
		}
	});
}
//-------------------------------------------------------------------
// reserve.jsp에 사용되는 변수 및 함수, 기능들
//-------------------------------------------------------------------

// reserve.jsp에서 예약자 이름과 휴대폰 번호, 전체 동의가 되어 있어야 결제 가능
let payment_ck_k = function() {
	let flag = false;
	if($('#reserve_name_k').val() == '') { 
		msg_k = "이름을 확인해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else if($('#reserve_Phone_k').val() == '' || phone_ck_k()) {
		msg_k = "번호를 확인해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else if(!$('#checkAll_k').prop('checked')) {
		msg_k = "약관 동의를 해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else {
		flag = true;
	}
	
	return flag;
}

// reserve.jsp에서 휴대폰 번호 유효성 체크 함수
let phone_ck_k = function() {
	let result = false; // 유효성 체크 결과 저장
	
	// 기존 번호에서 -를 삭제
    var trans_num = $('#reserve_Phone_k').val().replace(/-/gi,'');
  	
    // 유효성 체크
   	var regExp_ctn = /^(01[016789]{1})([0-9]{3,4})([0-9]{4})$/;
   	if(regExp_ctn.test(trans_num)) { // 유효성 체크 성공
   		result = true;
	}
    
    return !result;
}

// 전화번호 폼에 '-'입력 불가능
let removeChar = function() {
	if($('#reserve_Phone_k') != null) {
		$('#reserve_Phone_k').keyup(function(e) {
		    if(e.keyCode == 189) {
		    	let str = $(this).val().replace('-','');
		    	console.log(str);
		    	$(this).val(str);
		    }
		});
	}
}

// colorbox로 결과창 팝업으로 띄우기
let reserveR_k = function(link) {
	$.colorbox({
		overlayClose : false,
		escKey : false,
		href : link
    });
}


//-------------------------------------------------------------------
// 숙소 조회 or 예약 조회 페이지 이동에 사용될 함수들
//-------------------------------------------------------------------

// total_w.jsp의 예약 버튼 클릭시 페이지 이동
let roomView_k = function(rCode, roomCode, email) {
	if(email == "") {
		location.href = "./login/login.jsp";
	} else {
		console.log("rCode : ", rCode);
		console.log("roomCode : ", roomCode);
		console.log("checkIn : ", $('#checkIn_w').val());
		console.log("checkOut : ", $('#checkOut_w').val());
		frm_room_k.rCode.value = rCode;
		frm_room_k.roomCode.value = roomCode;
		$('#checkIn_w').val($('#checkIn_w').val());
		$('#checkOut_w').val($('#checkOut_w').val());
		frm_room_k.method = 'get';
		$('#frm_room_k').attr('action', 'rsRoom.rs').submit();
	}
}

// reserveList.jsp의 예약 취소 버튼 클릭시 페이지 이동
let rsView_k = function(rNo, rCode) {
	console.log("rNo : ", rNo);
	console.log("rCode : ", rCode);
	frm_k.rNo.value = rNo;
	frm_k.rCode.value = rCode;
	frm_k.method = 'get';
	$('#frm_k').attr('action', 'rsView.rs').submit();
	/*location.href="./index.jsp?middle=./user/u_subtitle.jsp&inc2=../reserve/reserve_modify.jsp";*/
	
}


//-------------------------------------------------------------------
// ajax를 위한 함수
//-------------------------------------------------------------------

// 예약할 때, 사용할 ajax
let insertAjax_k = function() {
	let param = $('#rsForm_k').serializeArray();
	console.log(param);
	$.ajax({
		url : "rsInsert.rs",
		method : "post",
		data : param,
		dataType : "text", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴)
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			msg_k = data;
		},
		error : function(e) {
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}

/*// 예약 취소할 때, 사용할 ajax
let deleteAjax_k = function(email) {
	let rNo = $('#rNo').val();
	//let rCode = $('#rCode').val();
	$.ajax({
		url : "rsDelete.rs",
		method : "post",
		data : {
			"rNo" : rNo,
			"email" : email
		},
		dataType : "text", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴)
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("예약 취소 성공!");
			msg_k = data;
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}*/

/*// 예약 상세 조회할 때 사용할 Ajax
let rsViewAjax = function() {
	// 예약 번호 가져오기
	let rNo = $('#rNo').val();
	console.log(rNo);
	$.ajax({
		url : "rsView.rs",
		method : "get",
		data : {"rNo" : rNo },
		dataType : "json", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("예약 조회 성공!");
			console.log("data : ", data);
			msg_k = data;
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}

// 객실 상세 조회할 때 사용할 Ajax
let roomViewAjax = function() {
	// 숙소 번호, 객체 번호 가져오기
	let rCode = $('#rCode').val();
	let roomCode = $('#roomCode').val();
	console.log(rCode);
	console.log(roomCode);
	$.ajax({
		url : "rsRoom.rs",
		method : "get",
		data : { 
					"rCode" : rCode,
					"roomCode" : roomCode
			   },
		dataType : "json", // 서버에서 받을 데이터 형식
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("객실 조회 성공!");
			$('#r')
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}*/


//-------------------------------------------------------------------
// reserve.jsp에 사용되는 체크박스 클릭 이벤트
//-------------------------------------------------------------------
let ck_status_k = function() {
	if($('#checkAll_k') != null) {
		// 전체 동의를 체크했을 경우
		$('#checkAll_k').click(function() {
			let chk = $(this).prop('checked'); // 전체 선택 체크박스의 속성값을 가져옴
			if(chk) { // 만약 전체 선택 체크박스가 체크된상태일경우
				$('input[type=checkbox]').prop('checked',true); // 해당화면에 전체 checkbox들을 체크해준다 
			} else { // 전체선택 체크박스가 해제된 경우
				$('input[type=checkbox]').prop('checked',false); // 해당화면에 모든 checkbox들의 체크를해제시킨다. 
			} 
		});

		// 아래 세 약관이 모두 체크되었을 경우 전체 동의도 체크됨
		$('input:checkbox[name=checkOk]').click(function() {
			let cnt = $('input:checkbox[name=checkOk]:checked').length;
			if(cnt == 3) {
				$('#checkAll_k').prop('checked',true);
			} else {
				$('#checkAll_k').prop('checked',false);
			}
		});
	}
}


//-------------------------------------------------------------------
// reserve.jsp / reserve_ck.jsp / reserve_ok.jsp / reserve_modify.jsp의 버튼 클릭 이벤트
//-------------------------------------------------------------------
let btnFunc_k = function() {
	// reserve.jsp의 결제하기 버튼
	if($('#btnPay_k') != null) {
		$('#btnPay_k').click(function() {
			let flag = payment_ck_k();
			if(flag) { // 이름, 번호, 전체 동의 상태에서만 결제 가능
				let param = $('#rsForm_k').serialize();
				let link = "reserve/reserve_ck.jsp?" + param;
			
				reserveR_k(link);
			}
		});
	}
	
	// reserve_ck.jsp의 결제 취소 버튼
	if($('#btnCkClose_k') != null) {
		$('#btnCkClose_k').click(function() {
			$.colorbox.close();
		});
	}
//-----------------------------------------------------------------------나중에 메인 or 숙소 상세페이지로 이동할 것
	// reserve_ck.jsp의 동의 후 결제 버튼
	if($('#btnPayOk_k') != null) {
		$('#btnPayOk_k').click(function() {
			let cnt = $('#paySelect_k').val();
			if(cnt == 1) {
				pay_iamport();				
			} else if(cnt == 2) {
				pay_kakao();
			}
			//insertAjax_k();
		});
	}


	// reserve_ok.jsp의 확인 버튼
	if($('#btnOk_k') != null) {
		$('#okMsg_k').text(msg_k);
		$('#btnOk_k').click(function() {
			if(msg_k == "정상 예약되었습니다.") { // 정상 예약시 페이지 이동
				let strIn = $('#checkIn').val()
				strIn = strIn.substring(0, 8);
				let strOut = $('#checkOut').val();
				strOut = strOut.substring(0, 8);
				rsForm_k.checkIn.value = strIn;
				rsForm_k.checkOut.value = strOut;
				document.rsForm_k.action = "roomView.ff";
				document.rsForm_k.submit();
			} else {
				$.colorbox.close();
			}
		});
	}
//--------------------------------------------------------------------------------------------------
	
	// total_w.jsp에서 예약 현황 확인하는 버튼
	if($('#btnSearch_k') != null) {
		$('#btnSearch_k').click(function() {
			let rCode = frm_room_k.rCode.value;
			let checkIn = $('#checkIn_w').val();
			let checkOut = $('#checkOut_w').val();
				$.getJSON('rsSearch.se', { 'rCode' : rCode, 'checkIn' : checkIn, 'checkOut' : checkOut }, function(json) {
					let size = $('button[name=btnR_w]').length;
					$('button[name=btnR_w').attr('disabled', false);
					for(i=0; i<json.length; i++) {
						let d = json[i];
	 					for(j=0;j<size;++j) {
	 						let btn = $('button[name=btnR_w]:eq(' + j + ')');
							let num = btn.val();
							if(d.roomCode == num) {
								btn.attr('disabled', true);
								break;
							}
						} 
					}
				});
		});
	}
	// reserve_modify.jsp의 예약 취소 버튼
/*	if($('#btnDelete_k') != null) {
		$('#btnDelete_k').click(function() {
			deleteAjax_k();
			msg_k = "정상 취소되었습니다.";
			reserveR_k("reserve/reserve_ok.jsp");
		});
	}*/
}

let payClick_k = function(email) {
	//pay_iamport(email);
	insertAjax_k();
}

/*let Okclick_k = function(email) {
	if($('#btnOk_k') != null) {
		$('#okMsg_k').text(msg_k);
		$('#btnOk_k').click(function() {
			if(msg_k = "정상 예약되었습니다.") { // 정상 예약시 페이지 이동
				document.rsForm_k.action = "roomView.ff";
				document.rsForm_k.submit();
			} else {
				$.colorbox.close();
			}
		});
	}
}*/