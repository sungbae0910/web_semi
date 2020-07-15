<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4' align='center'>
			<h4 class='h4_c'>비밀번호 재설정</h4>
			<form id='frm_c' name='frm_c' method='post'>
				<input type='hidden' id='email_c' name='email_c' value='<%=request.getParameter("e") %>' />
				<input type='password' id='pwd_c' name='pwd_c' class='pwd_c' placeholder="비밀번호" style='width:330px;margin-bottom: 35px'/>
				<div id='pwdM_c' class='pwdResetM_c'></div>
				<br/>
				<input type='password' id='pwd_ck_c' name='pwd_ck_c' class='pwd_c' placeholder="비밀번호 확인" style='width:330px;'/>
				<div id='pwdM_ck_c' class='pwdResetM_ck_c'></div>
				<button type="button" id='btnPwReset_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>비밀번호 재설정</button>
			</form>
			<input type='button' id='viewPw_c' class='viewPwR_c' value='보기'/>
			<input type='button' id='viewPw_ck_c' class='viewPwR_ck_c' value='보기'/>
		</div>
	</div>
</div>
<script>member(); btnFunc()</script>
<script src='../js/bootstrap.bundle.min.js'></script>

</body>
</html>