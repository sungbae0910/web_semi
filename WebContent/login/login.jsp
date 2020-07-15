<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인  | 어때</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4' align='center'>
			<div class='title_c'>
				<a href="../index.jsp"><img src="../image/logo_nlbo2.png"></a>
			</div>
			<!-- <button type='button' class='btn_kakao_c'>
				<span class='kakao_c'>
					<i class='icon_kakao_c'></i>
					카카오톡으로 로그인
				</span>
			</button>
			<button type='button' class='btn_face_c'>
				<span class='face_c'>
					<i class='icon_face_c'></i>
					facebook으로 로그인
				</span>
			</button> -->
			<div id="naverIdLogin">
    			<a id="naver-login-btn" href="#" role="button">
        			<img src="https://static.nid.naver.com/oauth/big_g.PNG" width="330px" height="45"/> 
   				 </a>
			</div>
            <p class="space_or">
            	<span>또는</span>
            </p>
            <form id='frm_c' name='frm_c' method='post' class="was-validated">
		        <input type='text' id='L_email_c' name='L_email_c' class='email_c' placeholder="이메일 주소" style='width:330px;'>
				<div id='L_emailM_c' class='L_emailM_c'></div>
				<input type='password' id='L_pwd_c' name='L_pwd_c' class='pwd_c' placeholder="비밀번호" style='width:330px;'/>
				<div id='L_pwdM_c' class='L_pwdM_c'></div>
			</form>
            <button id='btnLogin_c' type="submit" class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>로그인</button>
            <div class='pw_email_c'>
            	<a href="./pw_email.jsp" >비밀번호 재설정</a>
            </div>
            <div class='member_c'>
            	<a href="./agree.jsp">회원가입</a>
            </div>
            <div class='error' style='display:none;'>일치하는 회원이 없습니다.</div>
		</div>
	</div>
</div>


<script>
//네이버로 로그인 버튼
var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "zhK7B0bjhXk0U10lDW0c",
			callbackUrl: "http://192.168.0.27:8888/semiProject/login/naver_callback.jsp",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);

naverLogin.init();//설정정보를 초기화하고 연동을 준비 

emailCk(); //이메일 체크
btnFunc(); //버튼 이벤트

	

/* 쿠키로 url받아 올 때 사용
$(function() {
	var url = $cookie('url');
	alert(url);
	if (url != null && url != "") {
		$('#redirectUrl').val(url);
	}
}); */
</script>
<script src='../js/bootstrap.bundle.min.js'></script>
<body>

</body>
</html>