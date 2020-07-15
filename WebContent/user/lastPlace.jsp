<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난 방문지</title>
<!-- <script src="./js/jquery3.4.1.js"></script> -->
<!-- <script src="./js/user_s.js"></script> -->
</head>
<body>
<h3>지난방문지</h3>
	<div class="d-flex flex-column" >
		<form method="post" name="frm_rvv_s" id="frm_rvv_s">
		<c:forEach var="list" items="${list}" varStatus="status">
			<!-- 내부 빨간박스 -->
			<div class="p-4 rlist">
				<div class="row">
					<div class="col-3">
						<img src="./upload/${list.sysFile}.jpg" class="img-thumbnail" style="width:200px; height:200px; ">
					</div>
					<div class="col-6">
						<div class="row">
							<a class="h3" >${list.rName}</a><br/>
						</div>
						<div class="row">
							<a class="h4" >${list.rPlace} | ${list.logDate}일</a><br/>
						</div>
						<div class="row">
							<small class="text-muted"><a class="h4" >지난 방문지입니다.</a></small>
						</div>
						<div class="row rprice">
							${list.price}원
						</div>
					</div>
					<div class="col-3">
						<button type="button"  id="btnRe_s" class="btn btn-primary btn-lg btnrlist btnRe_s" onclick="btnReview(rCode${status.index})">리뷰작성</button>
						<button type="button"  class="btn btn-primary btn-lg btnrlist btnSe_s" onclick="btnSelect(rCode${status.index})">리뷰보기</button>
						<input type="hidden" name="rCode${status.index}" value="${list.rCode}"/>
						<input type="hidden" name="eMail" value="${list.eMail}"/>
						<input type="hidden" name="rCo" id="rCo_s"/>
					</div>
				</div>
			</div>
		</c:forEach>
		</form>
	</div>
<script>
user()
</script>
</body>
</html>