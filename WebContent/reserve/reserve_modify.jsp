<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="colorbox/colorbox.css" rel="stylesheet">
<link href="css/reserve_insert_k.css" type="text/css" rel="stylesheet">
<script src="js/jquery.colorbox-min.js"></script>
<script src="js/reserve_delete_k.js"></script>
</head>
<body>
<div class="col-12 border p-5">
	<div class="mb-5" id="reserveDel_k">
		<strong>${vo.rName }</strong><br/>
		<span>${vo.roomName }/${vo.period }박</span>	
	</div>
	<section class="mt-4" id="section_modify_k">
		<div class="mb-4">
			<p class="w-50 mb-2"><strong class="text-secondary">체크인</strong>${vo.checkIn }</p>
			<p class="w-50"><strong class="text-secondary br-5">체크아웃</strong>${vo.checkOut }</p>
		</div>
		<div class="border-bottom pb-3">
			<p class="w-50 mb-2"><strong class="text-secondary">예약 번호</strong>${vo.rNo }</p>
			<p class="w-50 mb-2"><strong class="text-secondary">예약자 이름</strong>${vo.rsName }</p>
			<p class="w-50"><strong class="text-secondary">휴대폰 번호</strong>${vo.rPhone }</p>
		</div>
		<div class="border-bottom mt-4 pb-2">
			<strong>결제정보</strong>
			<p class="w-50"><strong class="text-secondary mt-2">총 결제금액</strong><fmt:formatNumber value="${vo.price}" type="number" />원</p>
		</div>
	</section>
	<input type='hidden' name='rNo' id='rNo' value='${vo.rNo }'/>
	<input type='hidden' name='rCode' id='rCode' value='${vo.rCode }'/>
	<button type="button" class="btn btn-danger btn-lg mt-3" id="btnDelete_k" onclick="deleteAjax_k('${sessionScope.email}')">예약 취소</button>
</div>

<script>
//btnFunc_k();
</script>
</body>
</html>