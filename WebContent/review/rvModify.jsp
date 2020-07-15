<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰수정</title>
<script src="./js/jquery3.4.1.js"></script>
<script src="./js/user_s.js"></script>
</head>
<body>
<h3>리뷰수정</h3>
<form method="post" name="frm_rm_s" id="frm_rm_s">
<div class="form-group">
	<label for="exampleInputPassword1">제목</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="제목" name="title" value="${vo.title}">
</div>
<div class="form-group">
	<label for="exampleInputPassword1">아이디</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="아이디" name="eMail" value="${vo.eMail}" readonly>
</div>
<div class="starRev">
	<span class="starR on" id="star1_s">★</span>
	<span class="starR" id="star2_s">★</span>
	<span class="starR" id="star3_s">★</span>
	<span class="starR" id="star4_s">★</span>
	<span class="starR" id="star5_s">★</span>
	<input type="hidden" name="star" id="star_s" value="${vo.stars}" />
	<input type="hidden" name="star" id="star_s" value="${vo.stars}" />
</div>
<div class="form-group">
	<label for="exampleTextarea">리뷰 내용</label>
	<textarea class="form-control" id="exampleTextarea" rows="5" name="content" >${vo.rContent}</textarea>
</div>
<input type="hidden" name="eMail" value="${vo.eMail}"/>
<input type="hidden" name="rNo" value="${vo.rNo}"/>
<input type="hidden" name="rCo" value="${rCode}"/>
<button type="button" id="btnModify_s" class="btn btn-primary btn-lg">리뷰수정</button>
</form>
<script>
$(document).ready(function(){
		let value = $('#star_s').val();
		console.log(value);
		for(i=0; i<=value; i++){
			$('#star'+i+'_s').addClass('on');
		}
});
user()
</script>
</body>
</html>