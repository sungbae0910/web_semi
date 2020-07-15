<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pw_email</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>
<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<h4 class='h4_c' align='center'>비밀번호 재설정</h4>
			<div class='pwNotice_c' align='center'>
				회원가입 시 등록한 이메일 주소를 입력해주세요.
			</div>
			<div align='center'>
				<input type='text' id='pwEmail_c' class='email_c' placeholder="이메일 주소" style='width:330px;'>
				<div id='pwEmailM_c' class='pwEmailM_c'></div>
				<button type="button" id='btnPwEmail_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)' disabled>이메일 전송</button>
			</div>
			
		</div>
	</div>
</div>
<script>emailCk(); btnFunc()</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>