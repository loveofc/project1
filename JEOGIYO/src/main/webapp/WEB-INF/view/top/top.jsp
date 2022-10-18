<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

#wrap {
	display: flex;
	margin: 10px auto;
	padding: 0px 15px;
	width: 1440px;
	justify-content: space-between;
}

#logo a {
	color: black;
	text-decoration: none;
	height: 50px;
	line-height: 70px;
	text-decoration: none;
}

#lists {
	color: black;
	font-size: 20px;
	display: flex;
	height: 50px;
	margin: 10px auto;
	justify-content: space-between;
	list-style: none;
	align-items: center;
}

#lists li a {
	font-weight: 800;
	color: black;
	padding: 10px;
	text-decoration: none;
}

#lists li a:hover {
	color: red;
	background-color: #F0F8FF;
}
</style>
</head>
<body>
	<div id="wrap">
		<h2 id="logo">
			<a href="../index">JEOGIYO 2000</a>
		</h2>
		<div>
			<ul id="lists">
				<li><a href="../nav/menu">메뉴</a></li>
				<li>|</li>
				<li><a href="../nav/map">매장안내</a></li>
				<li>|</li>
				<li><a href="../nav/news">보도자료</a></li>
				<li>|</li>
				<li><a href="../nav/orders">온라인주문</a></li>
			</ul>
		</div>
	</div>
</body>
</html>