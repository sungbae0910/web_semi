<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
<!-- <script src="./js/jquery3.4.1.js"></script> -->
<!-- <script src="./js/user_s.js"></script> -->
</head>
<body>

<h3>마이 페이지</h3>
<img src="./image/user_mypage_s.png" class="img-thumbnail" style="width:200px; height:200px; margin-top: 10px">

<form method="post" name="frm_up_s" id="frm_up_s">
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">닉네임</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.nName}" readonly>
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">핸드폰번호</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.phone}" readonly>
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">이메일</label>
		<input class="form-control form-control-lg" type="text" name="eMail" id="inputLarge" value="${vo.eMail}" readonly>
	</div>
	<button type="button" class="btn btn-primary btnmp" id="btnMu_s">내정보수정</button>
	<button type="button" class="btn btn-primary btnmp" id="btnMp_sec_s">회원탈퇴</button>
	<input type="hidden" name="eMail" value="${vo.eMail}"/>
</form>
<script>
user()
</script>
</body>
</html>