<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>


<div class="container-fluid pl-0 pr-0">
	<div class="jumbotron text-center pt-0 pb-0 bg-danger">
		<img src="./image/main.png" style="height:440px; padding-top: 60px; overflow: hidden;"/>
	</div>
</div>
<div class="container">
	<!-- menu -->
		<div class='m_menu bg-white'>
			<ul>
				<li id='ht_f'><a onclick="motel()"><span class="ico_01">&nbsp;</span><p>모텔</p></a></li>
				<li id='mt_f'><a onclick="hotel()"><span class="ico_02">&nbsp;</span><p>호텔</p></a></li>
				<li id='ps_f'><a onclick="penshion()"><span class="ico_03">&nbsp;</span><p>펜션</p></a></li>
				<li id='gh_f'><a onclick="guesthouse()"><span class="ico_04">&nbsp;</span><p>게스트하우스</p></a></li>
			</ul>
		</div>
		<form id='frm_f' name='frm_f' method='post'>
			<input type='hidden' name='aType' id='aType' value=''/>
			<input type='hidden' name='nowPage_f' id='nowPage_f' value='1'/>
			<input type="hidden" name='place_f' id='place_f' value="구전체호텔"/>
			<input type="hidden" name='sort_f' id='sort_f' value='asc'/>
		</form>
											
		<h2 class="pt-5">공지사항 및 소식</h2>
		<ul class="list-group list-group-horizontal pt-3" id="nt_k">
			<li class="list-group-item w-50 p-0 mr-3" onclick="gont_k()" >
				<div>
				<div style="width:200px;height:200px;float:left;"><img src="./image/banner1.jpg" class="mr-3" alt="사진1" style="width:200px;height:200px"></div>
					<div style="padding-left:10px;padding-right:10px;padding-top:85px;width:375px;height:200px;float:left;"><strong id="title0_k" style="font-size:20px;"></strong></div>
				</div>
			</li>
			<li class="list-group-item w-50 p-0" onclick="gont_k()">
				<div>
				<div  style="width:200px;height:200px;float:left;"><img src="./image/banner2.jpg" class="mr-3" alt="사진2" style="width:200px;height:200px"></div>
					<div style="padding-left:10px;padding-right:10px;padding-top:75px;width:375px;height:200px;float:left;"><strong id="title1_k" style="font-size:20px;"></strong></div>
				</div>
			</li>
		</ul>
		
		<h2 class="pt-5">이벤트 및 광고</h2>
		<div id="carouselExampleIndicators" class="carousel slide pt-3" data-ride="carousel">
  			<ol class="carousel-indicators">
    			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  			</ol>
  			<div class="carousel-inner">
    			<div class="carousel-item active">
      				<img class="d-block w-100" src="./image/adv1.png" alt="First slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="./image/adv2.jpg" alt="Second slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="./image/adv3.jpg" alt="Third slide">
    			</div>
  			</div>
  			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    			<span class="sr-only">Previous</span>
  			</a>
  			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    			<span class="carousel-control-next-icon" aria-hidden="true"></span>
    			<span class="sr-only">Next</span>
  			</a>
		</div>
		
		<ul class="list-group list-group-horizontal pt-4">
			<li class="list-group-item p-0">
				<img src="./image/ad1.png" alt="사진1" class="img-fluid">
			</li>
			<li class="list-group-item ml-3 p-0">
				<img src="./image/ad2.png" alt="사진2" class="img-fluid">
			</li>
		</ul>
		
		<script>
			let motel = function(){
				$('#place_f').val('구전체모텔');
				$('#aType').val('1');
				$('#frm_f').attr('action','motel.ff').submit();
			}
			let hotel = function(){
				$('#place_f').val('구전체호텔');
				$('#aType').val('2');
				$('#frm_f').attr('action','hotel.ff').submit();
			}
			let penshion = function(){
				$('#place_f').val('구전체펜션');
				$('#aType').val('3');
				$('#frm_f').attr('action','penshion.ff').submit();
			}
			let guesthouse = function(){
				$('#place_f').val('구전체게하');
				$('#aType').val('4');
				$('#frm_f').attr('action','guesthouse.ff').submit();
			}
			
			// 게시판 가져오기
				$.getJSON('ntSearch.se', {}, function(json) {
					for(i=0; i<json.length; i++) {
						let d = json[i];
	 					$('#title' + i + '_k').text(d.title);
					}
				});
			let gont_k = function() {
				location.href="nt_select.mm";
			}
		</script>
		
</div>
</body>
</html>