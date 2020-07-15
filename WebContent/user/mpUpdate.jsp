<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보수정</title>
<script src="./js/jquery3.4.1.js"></script>
<script src="./js/user_s.js"></script>
</head>
<body>
<h3>내정보수정</h3>
<form method="post" name="frm_update_s" id="frm_update_s">
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">닉네임</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" name="nName" value="${vo.nName}">
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">핸드폰번호</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" name="phone" value="${vo.phone}">
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">이메일</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" name="eMail" value="${vo.eMail}" readonly >
	</div>
	<button type="button" id="btnUpdate_s" class="btn btn-primary btnmp">수정완료</button>
</form>
<script>
user()
</script>
</body>
</html>