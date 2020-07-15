/**
 * login.js
 */
function btnFunc(){
	/* 카카오
	  if($('#btn_kakao_c') != null){
		$('#btn_kakao_c').click(function(){
			Kakao.init('0c5164b04f51ba54280789c21fca1fc2');
			// 로그인 창을 띄웁니다.
			Kakao.Auth.createLoginButton({ 
				container: '#kakao-login-btn', 
				success: function(authObj) { alert(JSON.stringify(authObj)); 
				}, fail: function(err) { alert(JSON.stringify(err)); } 
			});

		});
	}*/
	
	//엔터키 로그인
	$('#L_email_c').keypress(function(event){
	     if ( event.keyCode == 13 ) {
	         $('#btnLogin_c').click();
	     }
	});
	$('#L_pwd_c').keypress(function(event){
	     if ( event.keyCode == 13 ) {
	         $('#btnLogin_c').click();
	     }
	});
	
	//로그인
	if('#btnLogin_c' != null){
		$('#btnLogin_c').on('click', function(){
			var email = $('#L_email_c').val();
			var pwd = $('#L_pwd_c').val();
			if($('#L_email_c').val() == "" && $('#L_pwd_c').val() == ""){//이메일,비밀번호가 null
				$('#L_email_c').css('border', '1px solid #ff0055');
				$('#L_emailM_c').text('E-Mail을 입력해주세요.');
				$('#L_pwd_c').css('border', '1px solid #ff0055');
				$('#L_pwdM_c').text('비밀번호를 입력해주세요.');
				$('#L_email_c').focus();
			}else if($('#L_email_c').val() == ""){ //이메일 null
				$('#L_email_c').css('border', '1px solid #ff0055');
				$('#L_emailM_c').text('E-Mail을 입력해주세요.');
				$('#L_email_c').focus();
			}else if($('#L_pwd_c').val() == ""){ //비밀번호 null
				$('#L_pwd_c').css('border', '1px solid #ff0055');
				$('#L_pwdM_c').text('비밀번호를 입력해주세요.');
				$('#L_pwd_c').focus();
			}
			$.post("login.lg", {'email':email, 'pwd':pwd}, 
					function(data, status){
							if(data == 'false'){ //로그인 실패
									$('.error').fadeIn(400).delay(1000).fadeOut(400);									
							}else{ //로그인 성공
								location.href="../index.jsp";
							}
			});
		});
	}
	
	//네이버로 로그인
	if($('#btnOk_c') != null){
		$('#btnOk_c').click(function(){
			var birth = $('#birth_c');
			var phone = $('#phone_c');
			if(birth.val() == "" && phone.val() == ""){//생년월일 핸드폰번호가 null
				birth.css('border', '1px solid #ff0055');
				$('#birthM_c').text('생년월일을 선택해주세요.');
				phone.css('border', '1px solid #ff0055');
				$('#phoneM_c').text('핸드폰번호를 입력해주세요.');
				birth.focus();
			}else if(birth.val() == ""){ //생년월일이 null
				birth.css('border', '1px solid #ff0055');
				$('#birthM_c').text('생년월일을 선택해주세요.');
				birth.focus();
			}else if(phone.val() == ""){ //핸드폰번호가  null
				phone.css('border', '1px solid #ff0055');
				$('#phoneM_c').text('핸드폰번호를 입력해주세요.');
				phone.focus();
			}else if($('#birthM_c').text()=="" && $('#phoneM_c').text()==""){ //정보가 모두 정상적으로 입력되었을 때
				$('#frm_c').attr('action','member.lg').submit();
			}
		});
	}
	
	if('#btnNextE_c' != null){
		$('#btnNextE_c').click(function(){
			location.href="./email.jsp";
		});
	}
	
	 // 이메일 인증 
	if('#btnSend_c' != null){
		$('#btnSend_c').click(function(){
			time(); //타이머 실행
			$('#btnSend_c').text('재전송');
			$('#btnSend_c').attr('disabled', true);
			$('.error').text('인증번호가 전송되었습니다.');
			$('.error').fadeIn(400).delay(1500).fadeOut(400);
			$('#numView').css('display','block');
			var email = $('#email_c').val();
			$.post("emailS.lg", {'email':email}, 
					function(data, status){
						$('#btnNum_c').click(function(){
							var num = $('#num_c').val();
							if(data == num){
								$('.error').text('인증되었습니다.');
								$('.error').fadeIn(400).delay(1500).fadeOut(400);
								$('#btnNextM_c').removeAttr('disabled');
							}else{
								$('.error').text('인증번호가 맞지 않습니다.');
								$('.error').fadeIn(400).delay(1500).fadeOut(400);
							}
						});						
			});
		});
	}
	
	//다음
	if('#btnNextM_c' != null){
		$('#btnNextM_c').click(function(){
			$('#frm_c').attr('action','membership.jsp').submit();
		});
	}
	//회원가입
	if('#btnMember_c' != null){
		$('#btnMember_c').click(function(){
			var email = $('#email_c').val();
			var birth = $('#birth_c').val();
			var pwd = $('#pwd_c').val();
			var phone = $('#phone_c').val();
			var nName = $('#nName_c').val();
			var pwd_ck = $('#pwd_ck_c').val();
							
			if(!birth && !pwd && !pwd_ck && !phone && !nName){
				$('#birth_c').css('border', '1px solid #ff0055');
				$('#birthM_c').text('생년월일을 선택해주세요.');
				$('#pwd_c').css('border', '1px solid #ff0055');
				$('#pwdM_c').text('비밀번호를 입력해주세요.');
				$('#pwd_ck_c').css('border', '1px solid #ff0055');
				$('#pwdM_ck_c').text('비밀번호를 한번 더 입력해주세요.');
				$('#phone_c').css('border', '1px solid #ff0055');
				$('#phoneM_c').text('핸드폰번호를 입력해주세요.');
				$('#nName_c').css('border', '1px solid #ff0055');
				$('#nNameM_c').text('닉네임을 입력해주세요.');
			}else if(!birth){
				$('#birth_c').css('border', '1px solid #ff0055');
				$('#birthM_c').text('생년월일을 선택해주세요.');
				$('#birth_c').focus();
			}else if(!pwd){
				$('#pwd_c').css('border', '1px solid #ff0055');
				$('#pwdM_c').text('비밀번호를 입력해주세요.');
				$('#pwd_c').focus();
			}else if(!pwd_ck){
				$('#pwd_ck_c').css('border', '1px solid #ff0055');
				$('#pwdM_ck_c').text('비밀번호를 입력해주세요.');
				$('#pwd_ck_c').focus();
			}else if(!phone){
				$('#phone_c').css('border', '1px solid #ff0055');
				$('#phoneM_c').text('핸드폰번호를 입력해주세요.');
				$('#phone_c').focus();
			}else if(!nName){
				$('#nName_c').css('border', '1px solid #ff0055');
				$('#nNameM_c').text('닉네임을 입력해주세요.');
				$('#nName').focus();
			}else if($('#birthM_c').text()=="" && $('#pwdM_c').text()=="" && $('#pwdM_ck_c').text()=="" && $('#phoneM_c').text()=="" && $('#nNameM_c').text()==""){ 
				//값이 모두 정상적으로 입력되었을 때
				$('#frm_c').attr('action','member.lg').submit();
			}
		});
	}
	
	//비밀번호 재설정 이메일전송
	if($('#btnPwEmail_c' != null)){	
		$('#btnPwEmail_c').click(function(){
			var email = $('#pwEmail_c').val();
			var content = $()
			$.post("pwResetMail.lg", {'email':email}, 
				function(data, status){
					if(data){
						changeTime(); //페이지이동 안내 메세지
					}else{
						swal("메일전송을 실패하였습니다.", "", "error");
					}
			});
		});
	};
	
	//비밀번호 재설정
	if($('#btnPwReset_c') != null){
		$('#btnPwReset_c').click(function(){
			if($('#pwd_c').val()=="" && $('#pwd_ck_c').val()==""){
				$('#pwd_c').focus();
				$('#pwd_c').css('border', '1px solid #ff0055');
				$('#pwdM_c').text('비밀번호를 입력해주세요.');
				$('#pwd_ck_c').css('border', '1px solid #ff0055');
				$('#pwdM_ck_c').text('비밀번호를 한번 더 입력해주세요.');
			} else if ($('#pwd_c').val() == ""){
				$('#pwd_c').focus();
				$('#pwd_c').css('border', '1px solid #ff0055');
				$('#pwdM_c').text('비밀번호를 입력해주세요.');
			} else if ($('#pwd_ck_c').val() == ""){
				$('#pwd_ck_c').focus();
				$('#pwd_ck_c').css('border', '1px solid #ff0055');
				$('#pwdM_ck_c').text('비밀번호를 한번 더 입력해주세요.');
			} else if ($('#pwdM_c').text() == "" && $('#pwdM_ck_c').text() == ""){
				swal("비밀번호를 변경하시겠습니까?", "","warning",{
					buttons: {catch: {text: "네"}, cancel: "아니요"},
				}).then((value) => {
					  if (value == "catch") { //"네" 버튼
					    	var email = $('#email_c').val();
							var pwd = $('#pwd_c').val();
							$.post("pwReset.lg", {'email': email, 'pwd': pwd},
								function(data, status){
										if (data == 'true'){ //DB저장 성공
											closeTime(); //타이머 함수실행
										}
									});
					  }else{ //"아니요"버튼						  
						  swal("비밀번호 변경 취소", "", "error");
					  }
					});
			}
		});
	}
};

/* 약관동의 */
function agree(){
	$('[name=agreeAll]').click(function(){
		$('[name=agreeOne]').prop('checked', $(this).prop('checked') );
		if($(this).prop('checked')){
			$('#btnNextE_c').removeAttr('disabled');
		}else{
			$('#btnNextE_c').attr('disabled', true);
		}
	});
	$('[name=agreeOne]').each(function(){
		$(this).click(function(){
			var box = $(this);
			var allBox = $('[name=agreeAll]');
			var boxName = $(box).attr('name');
			
			if(box.prop('checked') ){
				checkBoxLength = $('[name='+ boxName +']').length;
				checkedLength = $('[name='+ boxName +']:checked').length;
			
				if(checkBoxLength == checkedLength) {
					allBox.prop('checked', true);
					$('#btnNextE_c').removeAttr('disabled');
				}else {
					allBox.prop('checked', false);
					$('#btnNextE_c').attr('disabled', true);
				}
			}else{
				allBox.prop('checked', false);
				$('#btnNextE_c').attr('disabled', true);
			}
		});
	});
};

function emailCk(){
	//로그인 이메일
	$('#L_email_c').on('keyup', function(e){
		var email = $(this).val();
		var msg = $('#L_emailM_c');
		var emailRule = $(this).val().search(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
			if(email == ""){
				$(this).css('border', '1px solid #ff0055');
				$(msg).text('E-Mail을 입력해주세요.');
			}else if(emailRule < 0){
				$(this).css('border', '1px solid #ff0055');
				$(msg).text('유효하지않은 E-Mail주소입니다.');
			}else{
				$(msg).text("");
				$('#L_email_c').css('border', '1px solid #000');
			}
	});
	
	//로그인 비밀번호
	$('#L_pwd_c').on('keyup', function(){
		var msg = $('#L_pwdM_c');
		if($(this).val() == ""){
			$(msg).text("비밀번호를 입력해 주세요.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else{
			$(msg).text("");
			$('#L_pwd_c').css('border', '1px solid #000');
		}
	});
	//이메일 중복체크
	$('#email_c').on('keyup', function(){
		var email = $(this).val();
		var msg = $('#emailM_c');
		var emailRule = $(this).val().search(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
		$.post("emailCk.lg", {'email':email},
				function(data, status){
					if(data == email){
						$('#email_c').css('border', '1px solid #ff0055');
						$(msg).text('이미 등록되어있는 이메일입니다.');
						$(msg).css('color', '#ff0055');
					}else if(emailRule < 0 || email.length < 1){
						$('#email_c').css('border', '1px solid #ff0055');
						$(msg).text('유효하지않은 E-Mail주소입니다.');
						$(msg).css('color', '#ff0055');
					}else{
						$(msg).text("");
						$('#nName_c').css('border', '1px solid #000');
						$('#btnSend_c').removeAttr('disabled');
					}
				});
	});
	
	//DB에 있는 이메일인지 체크
	$('#pwEmail_c').on('keyup', function(){
		var email = $(this).val();
		var msg = $('#pwEmailM_c');
		$.post("emailCk.lg", {'email':email},
				function(data, status){
					if(data != email){
						$('#pwEmail_c').css('border', '1px solid #ff0055');
						$(msg).text('등록되어있지 않은 이메일입니다.');
						$(msg).css('color', '#ff0055');
					}else{
						$(msg).text("");
						$('#pwEmail_c').css('border', '1px solid #000');
						$('#btnPwEmail_c').removeAttr('disabled');
					}
				});
	});
};

/* 인증번호 인증 타이머 */
function time(){
	var num = 60 * 3; // 몇분을 설정할지의 대한 변수 선언
    var myVal = setInterval(timeFunc, 1000);
    
    function timeFunc() {
    	var min = num / 60; 
    	min = Math.floor(min); //소수점이 생기면 버리기
    	var sec = num - (60 * min);
    	$('#timer_c').text(min + ' : ' + sec);
    	
    	if(num == 0){
    		clearInterval(myVal); // num이 0이 되었을 때 clearInterval로 타이머 종료
    		myVal = "";
    		$('#timer_c').text("");
    		$('#num_c').val("");
    		$('#numView').css('display','none');
    		$('#btnSend_c').attr('disabled', false);
    	}
    	num--;
    }
}
//비밀번호 재설정 이메일 보낸 뒤 뜨는 타이머메세지
function changeTime(){
	var sec = 10; // 10초로 설정
    var myVal = setInterval(timeFunc, 1000);
    
    function timeFunc() {
    	//$('.mseTime_c').css('display','block');
    	//$('#mseTime_c').text('해당페이지는 ' + sec + '초 뒤에 메인페이지로 이동됩니다.');
    	swal("비밀번호 재설정 메일 전송", "해당 페이지가 " + sec + "초 후 메인페이지로 이동합니다.", "success",{
			  buttons: "바로이동"
		}).then((text) => { sec = 0; }); //"바로이동"버튼 눌렀을 때.
    	if(sec == 0){
    		clearInterval(myVal);
    		location.href = "../index.jsp";
    	}
    	sec--;
    }
}

//재설정 후 화면 꺼지는 타이머
function closeTime(){
	var sec = 10; // 10초로 설정
    var myVal = setInterval(timeFunc, 1000);
    
    function timeFunc() {
    	swal("비밀번호가 변경 성공", "해당 페이지가 " + sec + "초 후 자동으로 종료됩니다.", "success",{
			  buttons: "바로종료"
		}).then((text) => { sec = 0; }); //"바로종료"버튼 눌렀을 때.
    	if(sec == 0){
    		clearInterval(myVal);
    		window.close();
    	}
    	sec--;
    }
}

/* 회원가입 */
function member(){
	//성인체크
	$('#birth_c').change(function(){
		//생년
		var birth = $(this).val();
		var birthY = parseInt(birth.substring(0,4));
		//올해
		var date = new Date();
		var year = parseInt(date.getFullYear());
		
		var ageCk = year - birthY;
		if(!birth || birth == null){
			$(this).css('border', '1px solid #ff0055');
			$('#birthM_c').text('생년월일을 선택해주세요.');
		}else if(ageCk < 14){
			$(this).css('border', '1px solid #ff0055');
			$('#birthM_c').text('만 14세이상만 가입가능합니다.');
		}else{
			$('#birthM_c').text("");
			$(this).css('border', '1px solid #000');
		}
	});
	
	//비밀번호
	$('#pwd_c').on('keyup', function(){
		var msg = $('#pwdM_c');
		var num = $(this).val().search(/[0-9]/g);
		var eng = $(this).val().search(/[a-zA-Z]/ig);
		var spe = $(this).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);		
		if($(this).val().length < 6 || $(this).val().length > 15){
			$(msg).text('6자리 ~ 15자리 이내로 입력해주세요.');
			$(msg).css('color', '#ff0055');	
			$(this).css('border', '1px solid #ff0055');
		}else if($(this).val().search(/\s/) != -1){
			$(msg).text('띄어쓰기 없이 입력해 주세요.');
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else if(num < 0 || eng < 0 || spe < 0 ){
			$(msg).text('영문, 숫자, 특수문자를 혼합하여 입력해주세요.');
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else {
			$(msg).text("");
			$(this).css('border', '1px solid #000');
		}
	});
	
	//비밀번호 보기 | 숨기기
	if($('#viewPw_c') != null){
		$('#viewPw_c').click(function(){
			if($(this).val() == '보기'){
				$(this).val('숨기기');
				$('#pwd_c').attr('type', 'text');				
			}else{
				$(this).val('보기');
				$('#pwd_c').attr('type', 'password');
			}
		});
	}
	
	//비밀번호 확인
	$('#pwd_ck_c').on('keyup', function(){
		var msg = $('#pwdM_ck_c');
		
		if($(this).val() == ""){
			$(msg).text("비밀번호를 한번 더 입력해 주세요.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else if($('#pwd_c').val() != $(this).val()){
			$(msg).text("비밀번호가 일치하지 않습니다.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else{
			$(msg).text("");
			$(this).css('border', '1px solid #000');
		};
	});
	
	//비밀번호확인 보기 | 숨기기
	if($('#viewPw_ck_c') != null){
		$('#viewPw_ck_c').click(function(){
			if($(this).val() == '보기'){
				$(this).val('숨기기');
				$('#pwd_ck_c').attr('type', 'text');				
			}else{
				$(this).val('보기');
				$('#pwd_ck_c').attr('type', 'password');
			}
		});
	}
	
	//핸드폰번호
	$('#phone_c').on('keyup', function(){
		$(this).val($(this).val().replace(/[^0-9]/g, "")); //숫자만 입력.
		var msg = $('#phoneM_c');
		if($(this).val() == ""){
			$(msg).text("핸드폰번호를 입력해주세요.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else{
			$(msg).text("");
			$(this).css('border', '1px solid #000');
		}
	});
	
	//닉네임 중복체크
	$('#nName_c').on('keyup', function(){
		var nName = $('#nName_c').val();
		var msg = $('#nNameM_c');
		$.post("nNameCk.lg", {'nName':nName},
				function(data, status){
					if(!nName){
						$('#nName_c').css('border', '1px solid #ff0055');
						$(msg).text('닉네임을 입력해주세요.');
					}else if(data == nName){
						$('#nName_c').css('border', '1px solid #ff0055');
						$(msg).text('이미 등록되어있는 닉네임입니다.');
					}else{
						$('#nName_c').css('border', '1px solid #000');
						$(msg).text("");
					}
		});
	});
}




























