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
#login{
	margin: 10px auto;
	padding: 0px 15px;
	width: 1440px;
	
}
#login ul{
	display: flex;
	margin: 5px auto;
	list-style:none;
	flow:right;
}
#login ul li{
	display:block;
	width:70px;
	height:30px;
	margin-right:10px;
	text-align:center;
	line-height:30px;
	
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
@media (max-width: 800px) {

	#wrap{
		width:100%;
	}
	#login{
		width:100%;
	}
}
</style>
</head>
<body>
	<div id="login">
			<ul>
				<li>로그인</li>
				<li>회원가입</li>
				<li>고객센터</li>
			</ul>
		</div>
	<div id="wrap">
		
		<h2 id="logo">
			<a href="../">JEOGIYO 2000</a>
		</h2>
		<div>
			<ul id="lists">
				<li><a href="../nav/menu">메뉴</a></li>
				<li>|</li>
				<li><a href="../nav/map">매장안내</a></li>
				<li>|</li>
				<li><a href="../news">뉴스검색</a></li>
				<li>|</li>
				<li><a href="../nav/orders">온라인주문</a></li>
			</ul>
		</div>
	</div>
</body>
</html>