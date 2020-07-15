<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='colorbox.css'/>
<script src="../js/jquery-3.4.1.js"></script>
<script src='jquery.colorbox-min.js'></script>
</head>
<body>
<a id='colorbox' href='#dialog' >Dialog with colorbox</a>
<div id='dialogs' style='display: none;'>
  <div id='dialog'>
   <h1>Auto OPEN colorbox</h1>
   <p>안녕하십니까 제이름은 하하ㅏ하하하하하하하하하하하하하 안주현 누나 바보아아아하하하하하하하</p>
  </div>
</div>
<script>
$('a').colorbox({
	 inline:true,
    width:550
});
</script>
</body>
</html>