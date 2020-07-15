<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>

</head>
<body>
							<input type='hidden' name='rCode' id='rCode'/>
							<input type='hidden' name='rCo' id='rCo'/>
			
							
							
							
							<c:forEach var="vo" items="${list_f }" varStatus="status">
							<div id ='searched_frame_f' onclick='view(${vo.rCode})'>
								
								
								<div id='main_img_f'>
									<img src="./upload/${vo.sysFile }.jpg"/>
								</div>
								
								
								<div id='searched_f'>
									<div id='info_f'>
										<span>${vo.gInfo}</span>
									</div>
									<div id='name_f'>
										<strong>${vo.rName }</strong>
										<p>
											별점 : &nbsp;<em>${vo.stars}</em> &nbsp; (934)
										</p>
										<p>
											${vo.address}
										</p>
									</div>
									<div id='price_f'>
										<span><fmt:formatNumber value="${vo.price }" pattern="#,###" /> 원</span>
									</div>
								</div>
							</div>
							</c:forEach>
							
							
							
						
		
		
</body>
</html>