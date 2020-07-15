<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성</title>
<script src="./js/jquery3.4.1.js"></script>
<script src="./js/user_s.js"></script>
</head>
<body>
<h3>리뷰 작성</h3>
<form method="post" name="frm_rv_s" id="frm_rv_s">
<div class="form-group">
	<label for="exampleInputPassword1">제목</label>
	<input type="text" class="form-control" id="title_s" placeholder="제목" name="title">
</div>
<div class="form-group">
	<label for="exampleInputPassword1">아이디</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="아이디" name="eMail" value="${param.eMail}" readonly>
</div>
<div class="starRev">
	<span class="starR on" id="star1_s">★</span>
	<span class="starR" id="star2_s">★</span>
	<span class="starR" id="star3_s">★</span>
	<span class="starR" id="star4_s">★</span>
	<span class="starR" id="star5_s">★</span>
	<input type="hidden" name="star" id="star_s" value=1 />
</div>
<div class="form-group">
	<label for="exampleTextarea">리뷰 내용</label>
	<textarea class="form-control" id="content_s" rows="5" name="content"></textarea>
</div>
<input type="hidden" name="eMail" value="${param.eMail}"/>
<input type="hidden" name="rCode" value="${param.rCode}"/>
<button type="button" id="btnRee_s" class="btn btn-primary btn-lg">리뷰작성</button>
</form>
<script>
user()
</script>
</body>
</html>