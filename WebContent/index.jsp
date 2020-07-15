<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebProject</title>

<!-- css -->
<link rel="shortcut icon" href="#">
<link href="css/all.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/user_s.css" rel="stylesheet">
<!-- js -->
<script src="js/jquery-3.4.1.js"></script>



<style>
body { padding-top: 40px; }
</style>
</head>
<body>

<%
	String middle = "main.jsp";
	if(request.getParameter("middle")!=null){
		middle = request.getParameter("middle");
	}	
%>

<div id='main'>
	<!-- top.jsp -->
	<%@ include file="top.jsp" %>
	
	<!-- content -->
	<div class='content'>
  		<jsp:include page='<%=middle %>'/>
	</div>                                                
	<!-- bottom.jsp -->
	<%@ include file="bottom.jsp" %>
</div>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>