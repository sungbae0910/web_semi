<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>네이버 로그인 callback</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src='../js/jquery-3.4.1.js'></script>
</head>
<body>
<form id='frm_c' name='frm_c' method='post'>
	<input type='hidden' id='email_c' name='email_c' />
	<input type='hidden' id='nName_c' name='nName_c' />
</form>
<script>
	var naverLogin = new naver.LoginWithNaverId({
						clientId: "{zhK7B0bjhXk0U10lDW0c}", /* YOUR_CLIENT_ID */
						callbackUrl: "{http://192.168.0.27:8888/semiProject/login/naver_callback.jsp}", /* YOUR_REDIRECT_URL */
						isPopup: false,
						callbackHandle: true
					/* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정합니다. */
	});

	/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
	naverLogin.init();

	/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
	window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
				if (status) {
					/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
					var email = naverLogin.user.getEmail();
				    var nName = naverLogin.user.getName();
					$('#email_c').val(email);
					$('#nName_c').val(nName);
					if( email == undefined || email == null) { //사용자 정보 재동의를 위하여 다시 로그인 동의페이지로 이동함
						alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
						naverLogin.reprompt();
						return;
					}
					$.post("naver.lg", {'email':email, 'nName':nName}, 
							function(data, status){
						   	 	if(data != email){ //DB에 아이디가 없을 경우 => 회원가입
						   	 		$('#frm_c').attr('action','naver_add_info.jsp').submit(); //회원 정보 추가 기입 페이지
								}else{ //DB에 아이디가 존재할 경우 => 로그인
									window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/semiProject/index.jsp");
								return;
								}
					});
				} else {
					alert("callback 처리에 실패하였습니다.");
				}
			});
		});
</script>
</body>
</html>