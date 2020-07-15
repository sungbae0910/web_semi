<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agree</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<h4 class='h4_c' align='center'>약관 동의</h4>
			<div class='agree_ck_c'>
				<label style='text-decoration:none;'>
					<input type="checkbox" name='agreeAll'/> 전체 동의
				</label>
				<br/>
				<label>
					<input type="checkbox" name='agreeOne' />
					<a href='http://192.168.0.27:8888/semiProject/index.jsp?middle=./plus_menu/notice.jsp?sp=pv_select.jsp' target='_blank'> 이용약관 동의</a><span> (필수)</span>
				</label>
				<br/>
				<label>
					<input type="checkbox" name='agreeOne' />
					<a href='http://192.168.0.27:8888/semiProject/index.jsp?middle=./plus_menu/notice.jsp?personal_m.jsp' target='_blank'> 개인정보 수집 및 이용 동의</a><span> (필수)</span>
				</label>
				<br/>
					<label style='text-decoration:none;'>
					<input type="checkbox" name='agreeOne'/> 만 14세 이상 확인<span> (필수)</span>
				</label>
			</div>
			 <button type="button" id='btnNextE_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)' disabled>다음</button>
		</div>
	</div>
</div>
<script>agree(); btnFunc()</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>