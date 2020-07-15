<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 로그인  추가 정보 기입</title>
<% request.setCharacterEncoding("UTF-8"); %>
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
				<h4 class='h4_c' style='margin-top:30px;'>정보 추가</h4>
			</div>
			<form id='frm_c' name='frm_c' method='post'>
				<div class='mform_c'>
					<input type='hidden'  id='email_c' name='email_c' value='<%=request.getParameter("email_c") %>' />
					<input type='hidden'  id='nName_c' name='nName_c' value='<%=request.getParameter("nName_c") %>' />
					<input type='hidden'  id='pwd_c' name='pwd_c' value='naver' />
					<label class='label_c'>생년월일</label><br/>
					<input type='date' id="birth_c" name='birth_c' />
					<div id='birthM_c' class='birthN_c'></div>
					<br/>
					<label class='label_c'>핸드폰번호</label><br/>
					<input type='text' id='phone_c' name='phone_c' placeholder=" - 빼고 입력해주세요. " maxlength="11" />
					<div id='phoneM_c' class='phoneN_c'></div>
				</div>
			</form>
				<div align='center'>
					<button type="button" id='btnOk_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>확인</button>
				</div>
		</div>
	</div>
</div>
<script>member(); btnFunc()</script>
<script>
</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>