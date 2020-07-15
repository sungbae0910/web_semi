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
<style>
	body, html {
	margin: 0;
	padding: 0;
	height: 100%;
	}
	
	#insert_f{
		width:700px;
		background-color:#eee;
		margin: auto;
		height: 900px;
	}
	
	#insert_f #agree_f input[type='checkbox'] {
		display: none;
	}
	#insert_f #agree_f input[type='checkbox']+label{
		cursor: pointer;
	}
	#insert_f #agree_f input[type='checkbox']+label span{
	display: inline-block;
	width:20px;
	height: 20px;
	background-color:#fff;
	border: 1px solid #aaa;
	cursor:pointer;
	border-radius: 3px;
	vertical-align:middle;
	box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#insert_f #agree_f input[type='checkbox']:checked+label span{
	background-image: url("../image/checked_f.JPG");
	border: 1px solid #f62a4b;
	background-repeat : no-repeat;
	background-size : cover;
	box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
	#bedtype_f input[type='radio'] {
		display: none;
	}
	#bedtype_f input[type='radio']+label {
		cursor: pointer;
	}
	#bedtype_f input[type='radio']+label span{
		display: inline-block;
		width:20px;
		height: 20px;
		background-color:#fff;
		border: 1px solid #aaa;
		cursor:pointer;
		border-radius: 3px;
		vertical-align:middle;
		box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#bedtype_f input[type='radio']:checked+label span{
		background-image: url("../image/checked_f.JPG");
		border: 1px solid #f62a4b;
		background-repeat : no-repeat;
		background-size : cover;
		box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
	#aType_f input[type='radio'] {
		display: none;
	}
	#aType_f input[type='radio']+label {
		cursor: pointer;
	}
	#aType_f input[type='radio']+label span{
		display: inline-block;
		width:20px;
		height: 20px;
		background-color:#fff;
		border: 1px solid #aaa;
		cursor:pointer;
		border-radius: 3px;
		vertical-align:middle;
		box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#aType_f input[type='radio']:checked+label span{
		background-image: url("../image/checked_f.JPG");
		border: 1px solid #f62a4b;
		background-repeat : no-repeat;
		background-size : cover;
		box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
</style>
<body>
	<div id='insert_f'>
	<form id='frm_insert_f' name='frm_insert_f' method='post' enctype="multipart/form-data">
	<h3>객실 정보</h3>
		<div id='room_f'>
			<div id='room_in_f'>
				
				<input type='hidden' name='rCode' value='${rCode }'/>
				<label>방이름</label><br/>
				<input type='text' name='roomName'/>
				
				<br/>
				<label>수용 가능 인원</label><br/>
				<select name='rMaxPeople'>
					<option value='1'>1명</option>
					<option value='2'>2명</option>
					<option value='3'>3명</option>
					<option value='4'>4명</option>
					<option value='5'>5명</option>
					<option value='6'>6명</option>
					<option value='7'>7명</option>
					<option value='8'>8명</option>
					<option value='9'>9명</option>
					<option value='10'>10명</option>
				</select>
				
				<br/>
				<label>가격</label><br/>
				<input type='text' name='price'><label>원</label><br/>
				
				<br/>
				<label>객실내시설</label>
				<div id='agree_f'><input type="checkbox" name='tv' id='agree_check16_f' /><label for='agree_check16_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>			
				<div id='agree_f'><input type="checkbox" name='wifi' id='agree_check17_f' /><label for='agree_check17_f'><span></span>&nbsp;&nbsp;&nbsp;WIFI</label></div>
				<div id='agree_f'><input type="checkbox" name='shower' id='agree_check18_f' /><label for='agree_check18_f'><span></span>&nbsp;&nbsp;&nbsp;샤워실</label></div>
				<div id='agree_f'><input type="checkbox" name='aircon' id='agree_check19_f' /><label for='agree_check19_f'><span></span>&nbsp;&nbsp;&nbsp;에어컨</label></div>
				<div id='agree_f'><input type="checkbox" name='spa' id='agree_check20_f' /><label for='agree_check20_f'><span></span>&nbsp;&nbsp;&nbsp;스파</label></div>
				<div id='agree_f'><input type="checkbox" name='tub' id='agree_check21_f' /><label for='agree_check21_f'><span></span>&nbsp;&nbsp;&nbsp;욕조</label></div>
				<div id='agree_f'><input type="checkbox" name='computer' id='agree_check22_f' /><label for='agree_check22_f'><span></span>&nbsp;&nbsp;&nbsp;컴퓨터</label></div>
				<div id='agree_f'><input type="checkbox" name='iron' id='agree_check23_f' /><label for='agree_check23_f'><span></span>&nbsp;&nbsp;&nbsp;다리미</label></div>
				<div id='agree_f'><input type="checkbox" name='refr' id='agree_check24_f' /><label for='agree_check24_f'><span></span>&nbsp;&nbsp;&nbsp;냉장고</label></div>
				<div id='agree_f'><input type="checkbox" name='socket' id='agree_check25_f' /><label for='agree_check25_f'><span></span>&nbsp;&nbsp;&nbsp;개인콘센트</label></div>
				
				<h4>베드타입</h4>
				<div id='bedtype_f'><input type="radio" name='bed' class='bed_f' id='bed1_f' value='1'/><label for='bed1_f'><span></span>&nbsp;&nbsp;&nbsp;싱글</label></div>
				<div id='bedtype_f'><input type="radio" name='bed' class='bed_f' id='bed2_f' value='2'/><label for='bed2_f'><span></span>&nbsp;&nbsp;&nbsp;더블</label></div>
				<div id='bedtype_f'><input type="radio" name='bed' class='bed_f' id='bed3_f' value='3'/><label for='bed3_f'><span></span>&nbsp;&nbsp;&nbsp;트윈</label></div>	
				<div id='bedtype_f'><input type="radio" name='bed' class='bed_f' id='bed4_f' value='4'/><label for='bed4_f'><span></span>&nbsp;&nbsp;&nbsp;온돌</label></div>	
				
				<br/>
				<label>방 사진을 선택해주세요</label><br/>
				<input type="file" name='room_photo' id='room_photo'/><br/>
				<img width='500px' height='300px' id = 'room_pre'/><br/>
				<hr/>
			</div>
		</div>
		</form>
	</div>
	<input type='submit' id='btnInsert_f' value='등록 하기!!!!!!!!!!!!!!!!!!!'/>
		
		<script>
		//객실 사진 변경시
		$('#room_photo').change(function(event){
			let ele = event.target;
			let url = ele.files[0];
				
			let reader = new FileReader();
			reader.readAsDataURL(url);
			
			reader.onload = function(e){
				let img = new Image();//이미지 객체 생성하라!!
				img.src = e.target.result;
				$('#room_pre').attr('src',img.src);
			}		
		});
		</script>
</body>
</html>