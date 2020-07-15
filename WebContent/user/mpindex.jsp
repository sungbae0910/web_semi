<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="../js/jquery-3.4.1.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="css/all.min.css" rel="stylesheet">
<link href="../css/user_s.css" rel="stylesheet">
</head>
<body>
<div id='main'>
	<!-- top.jsp -->
	<%@ include file="../top.jsp" %>
	
	<!-- content -->
	<div class='content'>
		<jsp:include page="u_subtitle.jsp"/>
	</div>
	
	<!-- bottom.jsp -->
	<%@ include file="../bottom.jsp" %>
</div>

<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>