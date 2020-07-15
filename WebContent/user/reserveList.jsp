<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약현황</title>
<!-- <script src="./js/jquery3.4.1.js"></script> -->
<!-- <script src="./js/user_s.js"></script> -->
<script src="./js/reserve_insert_k.js"></script>
</head>
<body>
<h3>예약현황</h3>

<div class="d-flex flex-column" >
	<form method="post" name="frm_k" id="frm_k">
		<input type="hidden" id="rCode" name="rCode" value=""/>
		<input type="hidden" id="rNo" name="rNo" value=""/>
	<c:forEach var="list" items="${list}">
	<!-- 내부 빨간박스 -->
	<div class="p-4 rlist" onclick="">
		<div class="row">
			<div class="col-3">
				<img src="./upload/${list.sysFile}.jpg" class="img-thumbnail" style="width:200px; height:200px; ">
			</div>
			<div class="col-6">
				<div class="row">
					<a class="h3" >${list.rName}</a><br/>
				</div>
				<div class="row">
					<a class="h4" >${list.rPlace} | ${list.address}</a><br/>
				</div>
				<div class="row">
					<small class="text-muted"><a class="h4" >${list.gInfo}</a></small>
				</div>
				<div class="row rprice">
					${list.price}원
				</div>
			</div>
			<div class="col-3">
				<button type="button" class="btn btn-primary btn-lg btnrlist" onclick="rsView_k(${list.rNo}, ${list.rCode})">예약변경/취소</button>
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