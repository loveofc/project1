<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<script src="../js/menu.js"></script>
</head>
<body>
	<div id="allWrap">

		<jsp:include page="../top/top.jsp" />

		<div id="contents">
			<div id="img"></div>
			<ul id="menuList">
				${menuType}
			</ul>
		</div>
		<div id="detailMenu">
		<c:forEach var="list" items="${lists}">
			<div class="details">
			<p><img src ="/chicken/${list.imgname}"/></p>
			 <h1>${list.menuname}</h1>
			 <p>${list.descmenu}</p>
			 <h3>가격 : ${list.price}</h3>
			</div>
		</c:forEach>
		</div>

		<jsp:include page="../bottom/bottom.jsp" />


	</div>

</body>
</html>