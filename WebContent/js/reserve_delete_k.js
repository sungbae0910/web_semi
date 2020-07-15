/**
 * reserve_modify.jsp
 */
let msg_k = "";
let id = "";

// 예약 취소할 때, 사용할 ajax
let deleteAjax_k = function(email) {
	id = email;
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
			msg_k = data;
		},
		error : function(e) {
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			//reserveR_k("reserve/reserve_ok.jsp");
			let link = "reserve/reserveDel_ok.jsp?email" + email;
			$.colorbox({
				overlayClose : false,
				escKey : false,
				href : link
		    });
			
		}
	});
}

let btnFunc_Del_k = function() {
	//reserveDel_ok.jsp의 확인 버튼
	if($('#btnOk_k') != null) {
		$('#okMsg_k').text(msg_k);
		$('#btnOk_k').click(function() {
			if(msg_k == "정상 취소되었습니다.") { // 정상 취소시 페이지 이동
				location.href = "./reserveList.mp?eMail=" + id;
			} else {
				$.colorbox.close();
			}
		});
	}
}