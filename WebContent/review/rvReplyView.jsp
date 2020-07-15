<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변</title>
<script src="./js/jquery3.4.1.js"></script>
<script src="./js/user_s.js"></script>
</head>
<body>
<h3>리뷰 답변</h3>
<form method="post" name="frm_rvReply_s" id="frm_rvReply_s">
<div class="form-group">
	<label for="exampleInputPassword1">제목</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="제목" name="title">
</div>
<div class="form-group">
	<label for="exampleTextarea">리뷰 내용</label>
	<textarea class="form-control" id="exampleTextarea" rows="5" name="content"></textarea>
</div>
<input type="hidden" name="eMail" value="${sessionScope.email}"/>
<input type="hidden" name="rCode" value="${rCode}"/>
<input type="hidden" name="rGroup" value="${rGroup}"/>
<input type="hidden" name="rStep" value="${rStep}"/>
<input type="hidden" name="rIndent" value="${rIndent}"/>
<button type="button" id="btnRv_Reply_s" class="btn btn-primary btn-lg">답변하기</button>
</form>
<script>
user()
</script>
</body>
</html>