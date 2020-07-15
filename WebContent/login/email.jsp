<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>
<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<h4 class='h4_c' align='center'>이메일 본인 확인</h4>
			<div class='notice_c'>
				1회인증으로 더욱 안전한 예약이 진행됩니다.
				<br/>
				본인확인은 전자상거래상 필수조치로 안전하게 관리됩니다.
			</div>
			<form id='frm_c' name='frm_c' method='post'>
				<label class='label_c'>이메일 주소</label>
				<br/>
				<input type='text' id='email_c' name='email_c' class='email_c' placeholder="이메일 주소" maxlength="25">
				<button type="button" id='btnSend_c' class="btn btn-secondary disabled" style='width:130px;' disabled>인증번호 전송</button>
				<div id='emailM_c' class='emailM_c'></div>
				<div id='numView' style='display:none;'>
					<label class='label_c'>인증번호</label><br/>
					<input type='text' id='num_c' name='num_c' class='email_c' placeholder="인증번호" maxlength="15">
					<button type="button" id='btnNum_c' class="btn btn-secondary disabled" style='width:130px;'>확인</button>
					<div id='timer_c' class='timer'></div>
				</div>
			</form>
			<div align='center'>
				<button type="button" id='btnNextM_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)' disabled>다음</button>
				<div class='error' style='display:none;bottom:380px;'></div>
			</div>
		</div>
	</div>
</div>
<script>emailCk(); btnFunc()</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>