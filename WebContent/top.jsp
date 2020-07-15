<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.4.1.js"></script>
<script src="js/user_s.js"></script>
<style>
#top_list_k li{
	padding:0px 5px;
}
#top_list_k li>a{
	color:#faa;
}
#top_list_k li a:hover{
	color:#fff;
}
#top_list_k li .dropdown-item:hover{
	color:#f6323e;
}
#search_k{
	border:none;
	background-color:rgba(0,0,0,0);
}
#search_k{
	border:none;
	background-color:rgba(0,0,0,0);
}


#searchbox_main{
	width:100%;
	height: 422px;
	position:absolute;
	top:0px;
	display: none;
}
#searchbox{
	margin:auto;
	width: 717px;
	height: 422px;
	
}
#searchbox #search_top{
	width:717px;
	height: 72px;
	background-color:#f6323e;
}
#searchbox #search_top #top_left{
	float:left;
	width:72px;
	height: 72px;
	background-image: url('./image/find.jpg');
	cursor: pointer;
}
#searchbox #search_top #top_middle{
	float:left;
	width:573px;
	height: 72px;
}
#searchbox #search_top #top_right{
	float:left;
	width:72px;
	height: 72px;
	background-image: url('./image/exit.jpg');
	cursor: pointer;
}
#searchbox #search_top #top_middle #findStr{
	width: 572px;
	height: 71px;
	border: 1px solid #f6323e;
	background-color: #f6323e;
	font-size: 1.1em;
	color:#eee;
}
#searchbox #search_botoom{
	width:717px;
	height: 352px;
	background-color:#fff;
	box-sizing: border-box;
	padding: 25px;
	border-radius: 0px 0px 10px 10px;
}
#btnMy_c{
	background-color:#f6323e;
	border:none;
}
#nName_c{
	color:#000;
	font-weight:bold;
	font-size:1em;
}
#logout_c{
	cursor:pointer;
}
#sel{
	width:717px;
	height:352px;
	overflow:auto;
}
#sel::-webkit-scrollbar {
    width: 10px;
  }
#sel::-webkit-scrollbar-thumb {
    background-color: #2f3542;
    border-radius: 10px;
  }
#sel::-webkit-scrollbar-track {
    background-color: grey;
    border-radius: 10px;
  }

.nav-item .nav-link {
	cursor:pointer;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-danger fixed-top justify-content-center">
	<div class="container p-0">
				 
				<a class="navbar-brand ml-2" href="index.jsp?middle=main.jsp">
					<img src="./image/logo_white.png">
				</a>
					
					<form class="form-inline ml-auto mr-2" id="frm" name="frm"> 
						<button class="btn btn-primary my-2 my-sm-0" id="search_k" type="button">
							<i class="fas fa-search"></i>
						</button>
						<input type="hidden" name="eMail" id="eMail"/>
					</form>
					<ul class="navbar-nav" id="top_list_k">
						<li class="nav-item">
							 <a class="nav-link" onclick="reserveList('${sessionScope.email}')">예약 내역</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">더보기</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="index.jsp?middle=./plus_menu/nt_select.jsp">공지사항</a>
								 <a class="dropdown-item" href="index.jsp?middle=./plus_menu/notice.jsp?sp=pv_select.jsp">이용 약관</a>
							</div>
						</li>
						<li class="nav-item">
							<%
								String email = (String)request.getSession().getAttribute("email");
								String nName = (String)request.getSession().getAttribute("nName");
								if(email != null){
									session.setAttribute("email", email);		
								} 
								if(session.getAttribute("email") == null){%>
							 		<a class="nav-link" href="./login/login.jsp">로그인</a>
							<% }else{ %>
									<div class="dropdown">
							  			<button type="button" id='btnMy_c' class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							   			  	
							   			  		<img src='./image/myLogo_c.png'>
							   			  	
							   			 </button>
							   		<div class="dropdown-menu">
											<div class="dropdown-header" id='nName_c'><%=nName %></div>
							      			<div class="dropdown-divider"></div>
							     			<a class="dropdown-item" href="#" onclick="myPage('${sessionScope.email}')">내정보</a>
							     			<a class="dropdown-item" href="#" onclick="reserveList('${sessionScope.email}')">예약내역</a>
							     			<a class="dropdown-item" href="#" onclick="lastPlace('${sessionScope.email}')">지난 방문지</a>
							     			<a class="dropdown-item" id='logout_c'>로그아웃</a>
							   			</div>
							  		</div>
							<% } %>
						</li>
					</ul>
	</div>
				<div id ='searchbox_main'>
					<div id ='searchbox'>
						<form id="frm_search" name="frm_search" method='post'>
						<div id='search_top'>
							<div id='top_left' onclick=''>
							</div>
							<div id='top_middle'>
								<input type='text' name='findStr' id='findStr' placeholder="지역, 숙소명"/>
							</div>
							<div id='top_right'>
							</div>
						</div>
						<div id='search_botoom p-0'>
						<input type='hidden' name='rCode' id='rCode' value=''/>
						<select name='sel' id='sel' class='sel' size='20' tabindex='11'>
						</select>
						</div>
					</form>
					</div>
				</div>
</nav>
	<script>
		user()
		$('#search_k').click(function(){
			$('#searchbox_main').slideToggle(100);
		})
		if($('#top_right')!=null){
			$('#top_right').click(function(){
				$('#searchbox_main').slideToggle(100);
			})
		}
		$('#logout_c').click(function(){
			location.href = './login/logout.jsp';
		});
		
		if($('#findStr') != null) {
			$('#findStr').keyup(function() {
				let findStr = $('#findStr').val();
				if(findStr != "") {
					$.getJSON('search.se', { 'findStr':findStr }, function(json) {
						frm_search.sel.length = 0;
						console.log(json);
						if(json.length>0) {
							$('#sel').removeClass();
						}
						else {
							$('#sel').addClass('sel');
						}
						for(i=0; i<json.length; i++) {
							let d = json[i];
							let op = new Option("(" + d.rPlace + ")" + d.rName);
							
							frm_search.sel.options[i] = op;
							frm_search.sel.options[i].value = d.rCode;
						}
						frm.sel.selectedIndex = 0;
					});
				} else {
					frm_search.sel.options.length = 0;
				}
				
			});
			
			$('#sel').dblclick(function() {
				let temp = $(this).val();
				$('#rCode').val(temp);
				$('#frm_search').attr('action','roomView.ff').submit();
			});
		}
	</script>
</body>
</html>