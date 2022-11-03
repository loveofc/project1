<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>intro</title>
<link href="css/index.css" rel="stylesheet" type="text/css">
<script src="js/index.js"></script>
</head>
<body>
	<div>
		<jsp:include page="./top/top.jsp" />
	</div>

	<div id="mainWrap">

		<div id="m1">
			<div class="contentsList">		
			
				<div class="list">
					<img src="./img/1.jpg" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="./img/2.jpg" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="./img/3.png" width="100%" height="100%">
				</div>
			  	<div class="list">
					<img src="./img/4.jpg" width="100%" height="100%">
				</div>			
			</div>
			
			<div id="imageWrap">
				<img src="./img/5.jpeg" id="NewMenu">
			</div>
		</div>
		<div id="m2">
			<div class="m2Child">
			<iframe width="100%" height="100%" src="https://www.youtube.com/embed/I2BRguSlZhE" title="YouTube video player" 
			frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
			allowfullscreen></iframe>
			</div>
			<div class="m2Child">
				<h2>SEARCH.....</h2>
				<form method="get" action="/findstore">
					<p>매장명을 입력해주세요.</p>
					<input type="text" name="storename">
					<button>검색</button>
				</form>
				<hr>
				<div id="storeSearch">
					${str}
					<p>
						<a href="../nav/map">더보기</a>
					</p>
				</div>

			</div>
			<div class="m2Child"></div>
		</div>
	</div>
	<div>
		<jsp:include page="./bottom/bottom.jsp" />
	</div>
</body>

</html>