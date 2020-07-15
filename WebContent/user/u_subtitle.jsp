<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>u_subtitle</title>
<link rel='stylesheet' type='text/css' href='./css/user_s.css'/>
<!-- <script src="./js/jquery3.4.1.js"></script> -->
<!-- <script src="./js/user_s.js"></script> -->
</head>
<body>
<%
	String inc2 = "../review/mypage.mp";
	if(request.getParameter("inc2") != null){
		inc2 = request.getParameter("inc2");
	}
%>

<!-- <div id ='top_f'>위에
	<div id='top_in_f'>
		<h1>호텔</h1>
		<div>
			<img src="./image/reviewlogo.png">
		</div>
	</div>
</div> -->
<div id ='top_f'><!-- 위에 -->
	<div id='top_in_f'>
		<h1>더보기</h1>
		<div id='goo_select_f'>
		</div>
		<div id='topImg_f'>
		</div>
	</div>
</div>
<div class="container" style="padding-top: 30px">
	<!-- submenu -->
	<div class="row">
		<div class="col-3 u_list" >
			<ul class="nav flex-column" >
				<li class="nav-item">
					<a class="nav-link active" href="#" onclick="myPage('${sessionScope.email}')">내 정보 관리</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#" onclick="reserveList('${sessionScope.email}')">예약 현황</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#" onclick="lastPlace('${sessionScope.email}')">이용현황</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">포인트</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">쿠폰함</a>
				</li>
			</ul>
		</div>
		<div class="col-9">
			<jsp:include page="<%=inc2 %>"/>
		</div>
	</div>
</div>
<%-- <form method="post" name="frm" id="frm">
	<input type="hidden" name="eMail" id="eMail" value="${vo.eMail}"/>
</form> --%>
</body>
</html>