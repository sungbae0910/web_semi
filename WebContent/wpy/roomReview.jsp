<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.js"></script>
<script src='./js/f_roomsJs.js'></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src='../js/w_roomsjs.js'></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>
<link rel='stylesheet' type='text/css' href='./css/bootstrap.min.css'/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

<label id='check_w'>체크인</label><br/>
<input type="text" name="" id="checkIn_w" value="체크인 날짜 선택"><br/>
<label id='check2_w'>체크아웃</label><br/>
<input type="text" name="" id="checkOut_w" value="체크아웃 날짜 선택"><br/>				
<hr/>

<div id='room_w' >
  <div id='roomview_photo_w'>
   <img src=''/>
  </div>
 <div id = 'room_right_w'>
  <div id='room_head_w'>
   <strong >슈페리얼 트윈(금연룸)</strong>
   </div>
   <div id='price_w'>
    <span>가격</span> 
    <span id='sub_price_w'>79,600원</span>
    <hr/>
    <button id='btn_w'  class="btn btn-outline-light text-left text-muted">객실 이용 안내</button>
   </div>
   <button type='button' class='	btn btn-danger' id='btnR_w' >예약</button>
 </div>
</div>
<BR/>
<script>
event_f();
btnFunc_f();
</script>
</body>
</html>