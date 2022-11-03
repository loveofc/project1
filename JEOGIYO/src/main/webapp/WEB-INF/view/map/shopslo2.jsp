<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장찾기</title>
<!--  -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6fdbd356ee826b53078c35f9f402ed51&libraries=services,clusterer,drawing"></script>
<link href="../css/shopslo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../top/top.jsp" />
	<h2 id="storeSearch">매장찾기</h2>
	<form name="searchSHop" method="post" action="/nav/map"
		id="searchShop">
		<div class="shopSch">
			<div class="selType02">
				<select id="sido1" class="selectCus" title="시/도 선택"
					onchange="selectMain()" name="sub1">
					<option>시/도</option> ${option1}

				</select>
			</div>
			<div class="selType02">
				<select id="sido2" class="selectCus" title="시/군/구 선택"
					onchange="selectSub()" name="sub2">
					<option>시/구/군</option> ${option2}
				</select>
			</div>
			<div class="selType02">
				<input type="text" id="search" title="매장명 입력" name="storename"
					placeholder="매장명 입력" value="${storename}">
				<button id="btnSearch"  type="submit">검색</button>
			</div>
		</div>
	</form>
	<div id="contents">
		<div id="storelists">${strLists}</div>
		<div id="map"></div>
	</div>
	<div>
		<jsp:include page="../bottom/bottom.jsp" />
	</div>

	<script src="../js/store2.js"></script>
</body>
</html>