<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인 페이지</title>
<!-- 결제 CDN -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<link href="colorbox/colorbox.css" rel="stylesheet">
<link href="css/reserve_insert_k.css" type="text/css" rel="stylesheet">

<script src="js/jquery.colorbox-min.js"></script>
<script src="js/reserve_insert_k.js"></script>

</head>
<body>
<div class="container">
<div class="row mt-5">
		<div class="col-9">
			<form id="rsForm_k" name="rsForm_k" method="post">
			<section class="mb-5">
				<h3 class="mb-5">예약자 정보</h3>
				<div class="form-group mt-2 mb-5">
  					<label class="col-form-label col-form-label-lg" for="reserve_name_k">예약자 이름</label>
  					<input type="text" class="form-control form-control-lg w-75" placeholder="체크인시 필요한 정보입니다."
  						name="reserve_name_k" id="reserve_name_k">
				</div>
				<div class="form-group">
  					<label class="col-form-label col-form-label-lg p-0" for="reserve_Phone_k">휴대폰 번호</label><br/>
					<!-- <span>개인 정보 보호를 위해 안심번호로 숙소에 전송합니다.</span> -->
  					<input type="text" class="form-control form-control-lg w-75 mt-2" placeholder="체크인시 필요한 정보입니다."
  						name="reserve_Phone_k" id="reserve_Phone_k" value="${vo.phone }">
				</div>
			</section>
			<section>
				<h3 class="mb-3">결제수단 선택</h3>
      			<select class="form-control w-25" id="paySelect_k" name="paySelect_k">
       	 			<option value='1'>신용/체크카드</option>
        			<option value='2'>카카오페이</option>
      			</select>
			</section>
			<input type='hidden' name='rCode' id='rCode' value='${vo.rCode }'/>
			<input type='hidden' name='roomCode' id='roomCode' value='${vo.roomCode }'/>
			<input type='hidden' name='checkIn' id='checkIn' value='${vo.checkIn }'/>
			<input type='hidden' name='checkOut' id='checkOut' value='${vo.checkOut }'/>
			<input type='hidden' name='period' id='period' value='${vo.period }'/>
			<input type='hidden' name='email' id='email' value='${sessionScope.email }'/>
			<input type='hidden' name='rName' id='rName' value='${vo.rName }'/>
			<input type='hidden' name='roomName' id='roomName' value='${vo.roomName }'/>
			<input type='hidden' name='price' id='price' value='${vo.price }'/>
			</form>
			<section class="pt-3 ml-4">
				<div class="custom-control custom-checkbox p-1">
  					<input type="checkbox" class="custom-control-input" id="checkAll_k">
  					<label class="custom-control-label" for="checkAll_k">전체 동의</label><br/>
				</div>
				<div class="custom-control custom-checkbox p-1">
					<input type="checkbox" name="checkOk" class="custom-control-input" id="checkOk1_k">
  					<label class="custom-control-label" for="checkOk1_k">숙소이용규칙 및 취소/환불규정 동의<span class="text-danger">(필수)</span></label><br/>
				</div>
				<div class="custom-control custom-checkbox p-1">
					<input type="checkbox" name="checkOk" class="custom-control-input" id="checkOk2_k">
  					<label class="custom-control-label" for="checkOk2_k">개인정보 수집 및 이용 동의<span class="text-danger">(필수)</span></label><br/>
				</div>
				<div class="custom-control custom-checkbox p-1">
					<input type="checkbox" name="checkOk" class="custom-control-input" id="checkOk3_k">
  					<label class="custom-control-label" for="checkOk3_k">개인정보 제 3자 제공 동의<span class="text-danger">(필수)</span></label><br/>
				</div>
			</section>
		</div>
		<div class="col-3 p-0">
			<div class="h-auto rounded p-0" id="form_check_k">
			<section class="border-bottom m-4 pt-4">
				<p>
					<strong>숙소 이름</strong><br/>
					${vo.rName }
				</p>
				<p>
					<strong>객실 타입/기간</strong><br/>
					${vo.roomName } / ${vo.period }박
				</p>
				<p>
					<strong>체크인</strong><br/>
					${vo.checkIn }
				</p>
				<p>
					<strong>체크아웃</strong><br/>
					${vo.checkOut }
				</p>
			</section>
			<section class="m-4">
                <p class="mb-2">
                	<strong>
                		<b>총 결제 금액</b>(VAT포함)
                	</strong>
                </p>
               	<span class="text-danger" id="price_k"><fmt:formatNumber value="${vo.price}" type="number" />원</span>
                <ul class="pl-4 mt-2">
                    <li>해당 객실가는 세금, 봉사료가 포함된 금액입니다</li>
                    <li>결제완료 후 <span class="text-danger">예약자 이름</span>으로 바로 <span class="text-danger">체크인</span> 하시면 됩니다</li>
                </ul>
            </section>
            <button type="button" class="btn btn-primary btn-lg btn-block p-3" id="btnPay_k">결제하기</button>
            </div>
		</div>
	</div>
</div>

<script>
removeChar(); // '-' 입력 불가능
ck_status_k(); // 전체 동의 체크
btnFunc_k();
</script>
</body>
</html>