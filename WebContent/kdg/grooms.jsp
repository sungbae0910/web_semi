<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./js/jquery-3.4.1.js"></script>
<script src='./js/f_roomsJs.js'></script>
<script src='./js/w_roomsjs.js'></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<%
		String rooms_list = "rooms_list.jsp";
		if(request.getParameter("rooms_list")!=null){
			rooms_list = request.getParameter("rooms_list");
		}
	%>
	<div id ='main_f'><!-- 메인 -->
		<form id='frm_f' name='frm_f' method='post'>
			<input type="hidden" name='target' value="/grooms.jsp"/>
			<input type='hidden' name='nowPage_f' id='nowPage_f' value='${empty param.nowPage_f?1:param.nowPage_f }'/>
			<input type='hidden' name='aType' id='aType' value='4'/>
			<input type="text" name='place_f' id='place_f' value="${empty param.place_f?'구전체게하,.,.,.':param.place_f }"/>
			<input type="text" name='sort_f' id='sort_f' value="${empty param.sort_f?'asc':param.sort_f }"/>
		<div id ='top_f'><!-- 위에 -->
			<div id='top_in_f'>
				<h1>게스트하우스</h1>
				<div id='goo_select_f'>
					<div id='goo_f'>
						<span>게하전체 > ${empty param.place_f?'구전체게하':param.place_f } ▼</span>
					</div>
					<div id='goo_list_f'>
						<div id='goo1_f' onclick='goo1()'>도봉구 · 강북구 · 노원구 · 성북구</div>
						<div id='goo2_f' onclick='goo2()'>중랑구 · 동대문구 · 성동구 · 광진구</div>
						<div id='goo3_f' onclick='goo3()'>은평구 · 종로구 · 서대문구</div>
						<div id='goo4_f' onclick='goo4()'>중구 · 마포구 · 용산구</div>
						<div id='goo5_f' onclick='goo5()'>강동구 · 송파구 · 강남구</div>
						<div id='goo6_f' onclick='goo6()'>서초구 · 동작구 · 관악구 · 금천구</div>
						<div id='goo7_f' onclick='goo7()'>강서구 · 양천구 · 구로구 · 영등포구</div>
					</div>
				</div>
				<div id='topImg_f'>
				</div>
			</div>
		</div>
		<div id ='mid_f'>
			<div id ='mid_in_f'>
				<div id='left_f'>
					<div id='check_f'><!-- 체크박스 들어간 div -->
						<h3>날짜</h3>
						<label>체크인</label><br/>
						<input type="text" class="m-0" name="checkIn" id="checkIn_w" value=""><br/>
						<label>체크아웃</label><br/>
						<input type="text" class="m-0" name="checkOut" id="checkOut_w" value=""><br/>				
						<hr/>
						
						<h3>상세조건</h3>
						<input type='submit' name='btnReset' id='g_btnReset_f' class='btnReset_f' value='초기화'/>
						<input type='submit' name='btnApply' id='g_btnApply_f' class='btnApply_f' value='적용'/><br/>
						
						<h4>인원</h4>
						<select id='maxPeople' name='maxPeople'>
							<option value="1" <c:if test="${param.maxPeople == 1}">selected</c:if> >1명</option>
							<option value="2" <c:if test="${param.maxPeople == 2}">selected</c:if> >2명</option>
							<option value="3" <c:if test="${param.maxPeople == 3}">selected</c:if> >3명</option>
							<option value="4" <c:if test="${param.maxPeople == 4}">selected</c:if> >4명</option>
							<option value="5" <c:if test="${param.maxPeople == 5}">selected</c:if> >5명</option>
							<option value="6" <c:if test="${param.maxPeople == 6}">selected</c:if> >6명</option>
							<option value="7" <c:if test="${param.maxPeople == 7}">selected</c:if> >7명</option>
							<option value="8" <c:if test="${param.maxPeople == 8}">selected</c:if> >8명</option>
							<option value="9" <c:if test="${param.maxPeople == 9}">selected</c:if> >9명</option>
							<option value="10" <c:if test="${param.maxPeople == 10}">selected</c:if> >10명</option>
						</select>
						
						<h4 class='bed_f'>베드타입</h4>
						<input type='hidden' name='bedtype' value="${empty bedtype?'5':bedtype }" id='bedtype_f'/><!-- 베드 타일 보낼 히든 태그 -->
						<div id='bed_f'>
							<div id='bed1_f'>
							</div>
							<div id='bed2_f'>
							</div>
							<div id='bed3_f'>
							</div>
							<div id='bed4_f'>
							</div>
						</div>
						
						<h4>공용시설</h4>
					<!-- washer -->
						<c:choose>
						<c:when test="${vo_f.washer eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='washer' id='private1_f' checked="checked"/><label for='private1_f'><span></span>&nbsp;&nbsp;&nbsp;세탁기</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='washer' id='private1_f' /><label for='private1_f'><span></span>&nbsp;&nbsp;&nbsp;세탁기</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- lounge -->
						<c:choose>
						<c:when test="${vo_f.lounge eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='lounge' id='private2_f' checked="checked"/><label for='private2_f'><span></span>&nbsp;&nbsp;&nbsp;라운지</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='lounge' id='private2_f' /><label for='private2_f'><span></span>&nbsp;&nbsp;&nbsp;라운지</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- kitchen -->
						<c:choose>
						<c:when test="${vo_f.kitchen eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='kitchen' id='private3_f' checked="checked"/><label for='private3_f'><span></span>&nbsp;&nbsp;&nbsp;주방</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='kitchen' id='private3_f' /><label for='private3_f'><span></span>&nbsp;&nbsp;&nbsp;주방</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- dryer -->
						<c:choose>
						<c:when test="${vo_f.dryer eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='dryer' id='private4_f' checked="checked"/><label for='private4_f'><span></span>&nbsp;&nbsp;&nbsp;건조기</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='dryer' id='private4_f' /><label for='private4_f'><span></span>&nbsp;&nbsp;&nbsp;건조기</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- talsu -->
						<c:choose>
						<c:when test="${vo_f.talsu eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='talsu' id='private5_f' checked="checked"/><label for='private5_f'><span></span>&nbsp;&nbsp;&nbsp;탈수기</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='talsu' id='private5_f' /><label for='private5_f'><span></span>&nbsp;&nbsp;&nbsp;탈수기</label></div>
						 </c:otherwise>
						</c:choose>
						
						<h4>객실내 시설</h4>
						<!-- tv -->
						<c:choose>
						<c:when test="${vo_f.tv eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='tv' id='etc1_f' checked="checked"/><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='tv' id='etc1_f' /><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- wifi -->
						<c:choose>
						<c:when test="${vo_f.wifi eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='wifi' id='etc2_f' checked="checked"/><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;와이파이</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='wifi' id='etc2_f' /><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;와이파이</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- refr -->
						<c:choose>
						<c:when test="${vo_f.refr eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='refr' id='etc3_f' checked="checked"/><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;냉장고</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='refr' id='etc3_f' /><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;냉장고</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- aircon -->
						<c:choose>
						<c:when test="${vo_f.aircon eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='aircon' id='etc4_f' checked="checked"/><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;에어컨</label></div>
						 </c:when>
						<c:otherwise>
						 	<div id='chk_f'><input type="checkbox" name='aircon' id='etc4_f' /><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;에어컨</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- socket -->
						<c:choose>
						<c:when test="${vo_f.socket eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='socket' id='etc5_f' checked="checked"/><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;개인 콘센트</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='socket' id='etc5_f' /><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;개인 콘센트</label></div>
						 </c:otherwise>
						</c:choose>
					
						<h4>기타</h4>
					<!-- pet -->
						<c:choose>
						<c:when test="${vo_f.pet eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='pet' id='etc1_f' checked="checked"/><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;반려동물 동반</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='pet' id='etc1_f' /><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;반려동물 동반</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- smoke -->
						<c:choose>
						<c:when test="${vo_f.smoke eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='smoke' id='etc2_f' checked="checked"/><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내 흡연</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='smoke' id='etc2_f' /><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내 흡연</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- noSmoke -->
						<c:choose>
						<c:when test="${vo_f.noSmoke eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='noSmoke' id='etc3_f' checked="checked"/><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;금연</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='noSmoke' id='etc3_f' /><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;금연</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- parking -->
						<c:choose>
						<c:when test="${vo_f.parking eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='parking' id='etc4_f' checked="checked"/><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
						 </c:when>
						<c:otherwise>
						 	<div id='chk_f'><input type="checkbox" name='parking' id='etc4_f' /><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
						 </c:otherwise>
						</c:choose>
					<!-- breakfast -->
						<c:choose>
						<c:when test="${vo_f.breakfast eq 'on'}">
							<div id='chk_f'><input type="checkbox" name='breakfast' id='etc5_f' checked="checked"/><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
						 </c:when>
						<c:otherwise>
							<div id='chk_f'><input type="checkbox" name='breakfast' id='etc5_f' /><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
						 </c:otherwise>
						</c:choose>
					</div>
				</div>
				<div id ='right_f'>
					<div id ='search_f'><!-- 셀렉트된내용들 -->
						<div id='price_order_f'>
							<c:set var="ad" value="${empty sort_f?'체크인 날짜 선택':sort_f }" />
								<c:choose>

								<c:when test="${ad eq 'asc'}" ><input type='submit' name='btnAsc' id='btnAsc_f' class='asc_selected_f' value='낮은 가격순'/>
																<input type="submit" name='btnDsc' id='btnDsc_f' class='asc_select_f' value='높은 가격순'/></c:when>
								
								<c:when test="${ad eq 'dsc'}" ><input type='submit' name='btnAsc' id='btnAsc_f' class='asc_select_f' value='낮은 가격순'/>
																<input type="submit" name='btnDsc' id='btnDsc_f' class='asc_selected_f' value='높은 가격순'/></c:when>
								
								<c:otherwise> ... </c:otherwise>
								
								</c:choose>
						</div>
						
						<div id='page_change'>
							<h4 id='pricename'>
								<c:set var="ad" value="${empty sort_f?'낮은가격순':sort_f }" />
								<c:choose>

								<c:when test="${ad eq 'asc'}" > 낮은가격순 </c:when>
								
								<c:when test="${ad eq 'dsc'}" > 높은가격순 </c:when>
								
								<c:otherwise> ... </c:otherwise>
								
								</c:choose>
							</h4>
							
							<jsp:include page="<%=rooms_list %>"></jsp:include>
							
							
							<div id ='paging_f'>
							<c:if test="${p_f.nowPage > p_f.blockSize }">
								<input type='button'  class='btnBefore_f' onclick='goPage(1)'/>
							</c:if>
							
							<c:forEach var='i' begin='${p_f.startPage }' end='${p_f.endPage }'>
								<input type='button' class='btnMiddle_f' value='' ${(i==p_f.nowPage)? "class='here_f'":""} onclick='goPage(${i})'/>
							</c:forEach>
							
							<c:if test="${p_f.nowPage <p_f.totPage }">
								<input type='button'  class='btnAfter_f' onclick='goPage(${p_f.nowPage+1})'/>
							</c:if>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	
<script>
// 체크인 초기 날짜
let now = new Date();
frm_f.checkIn_w.value = now.format("MM.dd E");
// 체크아웃 초기 날짜
let next= new Date()
next.setDate(now.getDate() + 1);
frm_f.checkOut_w.value = next.format("MM.dd E");

event_f();
btnFunc_f();
</script>

</body>
</html>















