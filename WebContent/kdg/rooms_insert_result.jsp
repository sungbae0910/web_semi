<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${map_f.msg }</h3>
	<form id='frm_f' name='frm_f' method='post' enctype="multipart/form-data">
		<input type='text' name='rCode' value='${map_f.rCode }'/>
	</form>
	<input type='submit' name='btnRoomInsert_f' id='btnRoomInsert_f' value='방 추가하기'/>
	<input type='submit' name='btnFirst_f' id='btnFirst_f' value='처음으로'/>

</body>
</html>