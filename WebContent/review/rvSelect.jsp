<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 테스트</title>
<script src="./js/jquery3.4.1.js"></script>
<script src="./js/user_s.js"></script>
</head>
<body>
<form method="post" name="frm_rvSe_s" id="frm_rvSe_s">
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">작성자</th>
      <th scope="col">제목</th>
      <th scope="col">내용</th>
      <th scope="col">작성일자</th>
      <th scope="col">별점</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${list}" varStatus="status">
    <tr>
      <th scope="row">1</th>
      <td><c:forEach begin="1" end="${list.rIndent}">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>${list.eMail}</td>
      <td>${list.title}</td>
      <td>${list.rContent}</td>
      <td>${list.rDate}</td>
      <td>
	    <div class="starRev">
			<span class="starR" id="star1_s${status.index}">★</span>
			<span class="starR" id="star2_s${status.index}">★</span>
			<span class="starR" id="star3_s${status.index}">★</span>
			<span class="starR" id="star4_s${status.index}">★</span>
			<span class="starR" id="star5_s${status.index}">★</span>
			<input type="hidden" name="star" id="star_s${status.index}" value="${list.stars}" />
			<input type="hidden" name="rvCnt" id="rvCnt_s" value="${rvCnt}"/>
			<input type="hidden" name="rNo" id="rNo_s${status.index}" value="${list.rNo}"/>
			<input type="hidden" name="rCode" id="rCode_s" value="${rCode}"/>
			<input type="hidden" name="rGroup" id="rGroup_s" value="${list.rGroup}"/>
			<input type="hidden" name="rStep" id="rStep_s"  value="${list.rStep}"/>
			<input type="hidden" name="rIndent" id="rIndent_s${status.index}" value="${list.rIndent}"/>
			<input type="hidden" name="index_s" id="index_s${status.index}" value="${status.index}"/>
		</div>
		<input type="hidden" name="rNo" id="rNo" value="${list.rNo}"/>
		<button type="button" class="btn btn-primary btn-lg btnRv_Mo_s">리뷰수정</button>
		<button type="button" class="btn btn-primary btn-lg btnRv_Re_s">리뷰답변</button>
		<button type="button" class="btn btn-primary btn-lg btnRv_De_s" onclick="rvDelete('${status.index}')">리뷰삭제</button>
	  </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<input type="hidden" name="indent" id="indent_s"/>
<input type="hidden" name="rno" id="rno_s"/>
</form>
<script>
// 리뷰테이블에 들어 있는 별점만큼 별점을 표시하기 위한 로직...
$(document).ready(function(){
	let rvCnt = $('#rvCnt_s').val();
	console.log(rvCnt);
	for(a=0; a<=rvCnt; a++){
		let value = $('#star_s'+a).val();
		console.log(value);
		for(i=0; i<=value; i++){
			$('#star'+i+'_s'+a).addClass('on');
		}
	}
});
user()
</script>
</body>
</html>