<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = ./js/notice.js></script>

</head>
<body>

<div class="accordion">
	<div id="ch_m" style="padding-top: 50px;"><strong>서비스 공지사항</strong>
<hr/>
	<form method='post' name='frmm' id='frmm'>
	
	<c:forEach var="vo" items ="${list }" varStatus="status">
		<input type="checkbox" id="answer${vo.nno }">
		<label for="answer${vo.nno }" name="modifytitle">${vo.title }<br/><span>${vo.rDate }<input type="hidden" name="nnom${status.index}" value='${vo.nno}'/></span></label>

		<div>
		<c:set var="master" value="${sessionScope.email}"/>
		<!-- 비교할 값을 변수에 담아둠  -->
		<c:set var="master2" value="web@naver.com" />
		<!-- 마스터계정인지 확인하여 마스터계정일시 버튼을 보여줌 -->
		<c:if test="${master eq master2}">
		<input type="button" id="btnModifym" class="modifymemo" name="modifymemo" value="수정" onclick="btnmodify_m(nnom${status.index})"/>
		</c:if>
		<p><pre>${vo.memo}</pre></p>
	</div>
	
	</c:forEach>
	<input type="hidden" name="nno" id="nno" />
	<!-- 로그인할때 세션영역에 이메일지정한것을 가져옴  -->	
	<c:set var="master" value="${sessionScope.email}"/>
	<!-- 비교할 값을 변수에 담아둠  -->
	<c:set var="master2" value="web@naver.com" />
	<!-- 마스터계정인지 확인하여 마스터계정일시 버튼을 보여줌 -->
	<c:if test="${master eq master2}">
	<input type="button"  id="btnInsertm" value="등록"/>
	</c:if>
	<input type='hidden' name='nowPage' id='nowPage' value='${empty param.nowPage? 1 : param.nowPage }'/>
	</form>
	<div class="col-12 text-center" id='paging'>
		<c:if test="${p.nowPage > p.blockSize }">
		<input type='button' value='이전' onclick='goPage(1)'>
		</c:if><!-- blockSize보다 수가 작으면 이전 페이지는 나오지 않게 함 -->
		
		<c:forEach var='i' begin='${p.startPage }' end='${p.endPage }'>
			<input type='button' id='btn_number' value='${i }' ${(i==p.nowPage)? "class = 'here'" : "" }onclick='goPage(${i})'>
		</c:forEach>

		<c:if test="${p.nowPage < p.totPage }">
		<input type='button' value='다음' onclick='goPage(${p.nowPage+1})'>
		</c:if><!-- 최종페이지가 현제페이지보다 많으면 다음이 나오게 됨. -->
	</div>
	
	</div>
</div>

<%
	if(request.getParameter("nowPage") == null){
		out.print("<script> goPage(1)</script>");
	}
%>
<script>
btnFuncm();
</script>
</html>




