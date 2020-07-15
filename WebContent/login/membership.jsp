<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<div class='title_c' align='center' style='margin:60px 0 20px 0;'>
				<strong class='logo center' >
					<a href="../index.jsp"><img src="../image/logo_nlbo2.png"></a>
				</strong>
				<h4 class='h4_c' style='margin-top:30px;'>회원가입</h4>
			</div>
			<form id='frm_c' name='frm_c' method='post'>
				<div class='mform_c'>
					<label class='label_c'>이메일 아이디</label><br/>
					<input type='text'  id='email_c' name='email_c' value='<%=request.getParameter("email_c") %>' readonly/>
					<br/>
					<label class='label_c'>생년월일</label><br/>
					<input type='date' id="birth_c" name='birth_c' />
					<div id='birthM_c' class='birthM_c'></div>
					<br/>
					<label class='label_c'>비밀번호</label><br/>
					<input type='password' id='pwd_c' name='pwd_c' placeholder=" 비밀번호를 입력해주세요." />	
					<div id='pwdM_c' class='pwdM_c'></div>
					<br/>
					<label class='label_c'>비밀번호 확인</label><br/>
					<input type='password' id='pwd_ck_c' name='pwd_ck_c' placeholder=" 비밀번호를 입력해주세요." />
					<div id='pwdM_ck_c' class='pwdM_ck_c'></div>
					<br/>
					<label class='label_c'>핸드폰번호</label><br/>
					<input type='text' id='phone_c' name='phone_c' placeholder=" - 빼고 입력해주세요. " maxlength="11" />
					<div id='phoneM_c' class='phoneM_c'></div>
					<label class='label_c'>닉네임</label><br/>
					<input type='text' id='nName_c' name='nName_c' maxlength="10">
					<div id='nNameM_c' class='nNameM_c'></div>
					<br/>
				</div>
			</form>
			<input type='button' id='viewPw_c' class='viewPw_c' value='보기'/>
			<input type='button' id='viewPw_ck_c' class='viewPw_ck_c' value='보기'/>
			<div class='mNotice_c' align='center'>
				로그인 / 회원가입시<br/>
				<a href='http://192.168.0.27:8888/semiProject/index.jsp?middle=./plus_menu/notice.jsp?sp=pv_select.jsp' target='_blank'>이용약관,</a> 
				<a href='http://192.168.0.27:8888/semiProject/index.jsp?middle=./plus_menu/notice.jsp?personal_m.jsp' target='_blank'>개인정보처리방침</a>에 동의하게 됩니다.
			</div>
			<div align='center'>
				<button type="button" id='btnMember_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>동의하고 회원가입</button>
			</div>
		</div>
	</div>
</div>
<script>member(); btnFunc()</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>