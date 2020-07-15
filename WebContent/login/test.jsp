<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='../js/jquery-3.4.1.js'></script>
</head>
<body>
<button id='btn'>버튼</button>
<div id='timer'></div>



<script>

$('#btn').click(function(){
	time();
});


function time(){
	var num = 5; // 몇분을 설정할지의 대한 변수 선언
    var myVar = myVal = setInterval(timeFunc, 1000);
	
	function timeFunc() {
	    var min = num / 60; 
	    min = Math.floor(min); //소수점이 생기면 버리기
	     console.log(min, sec);
	    var sec = num - (60 * min);
	    $('#timer').text(min + ' : ' + sec);
	
	    if(num == 0){
	        clearInterval(myVal);// num이 0이 되었을 때 clearInterval로 타이머 종료
	        myVal = "";
	    }
	    num--;
	}
}
</script>
</body>
</html>