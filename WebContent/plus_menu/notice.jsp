<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/bootstrap.min.css'/>
<link rel='stylesheet' type='text/css' href='./css/accordion.css'/>
<style>
	.content .container-fluid{
		padding-left: 0px;
		padding-right: 0px;
		width: 100%;
		background-color: #f6323e;
		height: 160px;
	}
	.content .container-fluid img{
		margin-top:3px;
	}
	#ch_m{
		border: none;
	}

</style>
</head>
<body>
<%
String inc = "./index_m.jsp";
if(request.getParameter("inc") !=null){
	inc = request.getParameter("inc");
}
String sp = "./nt_select.jsp";
if(request.getParameter("sp") != null){
	sp = request.getParameter("sp");
}
%>
<div class="container-fluid" style="height : 162px; border: none;">
	<h2 style="padding-top:80px; padding-left:420px; color:#fff; font-weight:bold;">더보기</h2>
	<img src="./image/dunk.png" style=" width:160px; height: 230px; position: absolute; left:1300px; top:69px;">
</div>


<div class="container" style='border: 1px solid #ffffff'>
  <div class="row">
    <div class="col-3" style='padding-top:50px; cursor : pointer;' >
	<ul>
		<jsp:include page="<%=inc %>"/>
	</ul>
    </div>
    <div class="col-9" style="padding-top : 50px;">
    
		<jsp:include page="<%=sp %>"/>
	
    </div>
  </div>

</div>

</body>
</html>