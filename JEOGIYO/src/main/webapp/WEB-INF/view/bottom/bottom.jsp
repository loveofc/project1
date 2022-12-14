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

#bottom_wrap {
	display: flex;
	margin: 10px auto;
	width:1440px;
	justify-content: space-between;
}
#bottom_contents{
	padding:20px;
	margin:0px;
}
.under600{
	display:none;
}
@media (max-width: 800px) {

	#bottom_wrap{
		width:100%;
	}
	.under600{
	display:block;
	}
	.over600{
	display:none;
	}
}
</style>
</head>
<body>
	<div id="bottom_wrap">
		<div id="bottom_contents" class="over600">
			사업장소재지 : 39852 경상북도 칠곡군 가산면 송신로 78 | 본사(오산교육원)주소 : 18150 경기도
			오산시 동부대로 436번길 55-18 | 상호명 : 교촌에프앤비(주) | 대표이사 : 윤진호 | 대표번호 :
			031-371-3500 | 소비자상담번호 : 080-320-3000 | 사업자등록번호 : 513-81-16574 |
			통신판매업신고 : 2012-경상북도칠곡-00023호 | 개인정보보호책임자 : 김명식 | 영업시간 : 12:00~23:30 |
			Copyright 2015 © KYOCHON F&B. All rights reserved.
		</div>
		<div id="bottom_contents" class="under600">
			<p>사업장소재지 :<br/>39852 경상북도 칠곡군 가산면 송신로 78</p>
			<p>본사(오산교육원)주소 :<br/>18150 경기도 오산시 동부대로 436번길 55-18</p>
			<p>상호명 : 교촌에프앤비(주) | 대표이사 : 윤진호</p>
			<p>대표번호 : 031-371-3500 | 소비자상담번호 : 080-320-3000</p>
			<p>사업자등록번호 : 513-81-16574</p>
			<p>통신판매업신고 : 2012-경상북도칠곡-00023호</p>
			<p>개인정보보호책임자 : 김명식 | 영업시간 : 12:00~23:30</p>
			<p>Copyright 2015 © KYOCHON F&B. All rights reserved.</p>
		</div>
	</div>
</body>
</html>


