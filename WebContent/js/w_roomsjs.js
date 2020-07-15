/**
 * 
 */

//체크인 체크아웃 데이트 설정
let btnFunc_w = function(){
	
	if($('#btnHotel') != null) {
		$('#btnHotel').click(function(){
			$('#view2_w').attr('style','display:none');
			$('#view3_w').attr('style','display:none');
			$('#view1_w').removeAttr('style','display:block');
		});
	}
	
	if($('#btnLodging') != null) {
		$('#btnLodging').click(function(){
			$('#view1_w').attr('style','display:none');
			$('#view3_w').attr('style','display:none');
			$('#view2_w').removeAttr('style','display:block');
		});
	}
	
	if($('#btnReview') != null) {
		$('#btnReview').click(function(){
			$('#view1_w').attr('style','display:none');
			$('#view2_w').attr('style','display:none');
			$('#view3_w').removeAttr('style','display:block');
		});
	}
	

	var deadLine = new Date(),
    y = deadLine.getFullYear(),
    m = deadLine.getMonth()+1,
    d = deadLine.getDate(),
    h = deadLine.getHours(),
    M = deadLine.getMinutes();
 
	if(h >= 16 && M >= 30 ) d++;
	deadLine = y + "-" + m + "-" + d;
 
	$(function(){
 
	    // 분 단위로 minDate 제어  - 16:30 지나면 minDate 일 단위에 하루 플러스 하여 선택불가 만들기
	    $( "#checkIn_w" ).datepicker({   // http://blog.naver.com/wizardkyn/220661505153
		      minDate: new Date()  //1. 좌측 달력 날짜의 최초 값은 기본 기능에 나와 있듯 “오늘” 날짜이며, 오늘 날짜 이전으로 월 & 일 이동 불가
		              //minDate 옵션 설정
		      ,maxDate: "+2M"
		      ,showOtherMonths: true
		      ,dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토"] //달력 한글화(요일)
	    	  ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
        	  ,dayNamesShort: ['일','월','화','수','목','금','토']
		      ,monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]//달력 한글화(월)
		      ,yearSuffix:"년"
		      ,showMonthAfterYear:true
		      ,nextText:"다음달"
		      ,prevText:"이전달"
		      ,dateFormat:"mm.dd D"
		      ,onSelect: function(selected,evnt){
			        //3. 좌측 달력에서 날짜를 선택하면 우측 달력은 좌측 달력에서 선택된 날짜 이전으로 월 & 일 이동 불가
			        var day = $("#checkIn_w").datepicker('getDate');
			        day.setMonth(day.getMonth());
			        day.setDate(day.getDate() + 1);
			        $('#checkOut_w').datepicker('option','minDate', day);//오른쪽달력 minDate 옵션으로 왼쪽달력의 선택된 날짜를 지정
			        $('#checkOut_w').datepicker('setDate', day);
		      }
		      ,onChangeMonthYear:function(year,month,evnt){//왼쪽이나 오른쪽버튼을 눌렀을때 호출되는 콜백함수
				    //2. 좌측 달력의 ‘월“ 과 우측 달력의 ’월‘ 은 동일하게 움직이도록 처리
				    var day2 = $("#checkIn_w").datepicker('getDate');
				    day2.setMonth(month-1);
				    day2.setFullYear(year);
				    $('#checkOut_w').datepicker('setDate', day2)
		 
		      }
	 
	   });
	    
	   $( "#checkOut_w" ).datepicker({
	        maxDate: "+2M"
	        ,dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토"]//달력 한글화(요일)
	   		,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
  			,dayNamesShort: ['일','월','화','수','목','금','토']
	        ,monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]//달력 한글화(월)
	        ,yearSuffix:"년"
	        ,showMonthAfterYear:true
	        ,nextText:"다음달"
	        ,prevText:"이전달"
	        ,dateFormat:"mm.dd D"
	   });
   }); 
}

Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";
 
    var weekName = ["일", "월", "화", "수", "목", "금", "토"];
    var d = this;
     
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};
 
String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};