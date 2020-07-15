<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="p-0" id="reserve_ck_k">
	<strong class="m-3 mb-3">예약내역 확인</strong>
	<div class="border-top border-bottom p-3 m-0">
		<p class="mb-1">${param.rName }</p>
		<p>${param.roomName } / ${param.period }박</p>
		<p class="text-right mb-1">
			<span class="text-secondary float-left">체크인</span>
			<b class="text-right">${param.checkIn }</b>
		</p>
		<p class="border-bottom pb-3 text-right">
			<span class="text-secondary float-left">체크아웃</span>
			<b>${param.checkOut }</b>
		</p>
		
		<ul class="pl-4 mb-0">
			<li>미성년자는 보호자 동반 시 투숙이 가능합니다.</li>
			<li><b class="text-danger">취소 및 환불 규정</b>에 따라 취소수수료 부과 및 취소불가 될 수 있습니다.</li>
		</ul>
	</div>
	<div class="pt-3 pr-3" align="right">
		<button type="button" class="btn btn-link text-secondary p-0 mr-2" id="btnCkClose_k">취소</button>
		<button type="button" class="btn btn-link text-info p-0" id="btnPayOk_k">동의 후 결제</button>
	</div>
</div>

<script>
btnFunc_k();
function parentFunc() {
	insertAjax_k();
}
</script>
</body>
</html>