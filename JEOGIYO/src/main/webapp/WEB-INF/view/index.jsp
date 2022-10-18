<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
					<img src="../img/kimyujung.png" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="../img/namjihyen.png" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="../img/kimyujung2.png" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="../img/seohyenjin.png" width="100%" height="100%">
				</div>
				<div class="list">
					<img src="../img/jichanguk.png" width="100%" height="100%">
				</div>
			</div>

			<div>
				<img src="../img/event.png" id="NewMenu">
			</div>
		</div>
		<button onclick="slideFunc()">변경</button>
		<div id="m2">
			<div class="m2Child"></div>
			<div class="m2Child">
				<h2>SEARCH.....</h2>
				<form method="get" action="index">
					<p>매장명을 입력해주세요.</p>
					<input type="text" name="storeName">
					<button>검색</button>
				</form>
				<hr>
				<div id="storeSearch">
					<c:forEach var="list" items="${lists}">
						<div class="listResult">
							<p>${list.storeName}</p>
							<p>${list.addr}</p>
							<p>${list.phone}</p>
							<p>${list.time}</p>
						</div>
					</c:forEach>
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