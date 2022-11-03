<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보도 자료</title>
<link href="../css/news.css" rel="stylesheet" type="text/css">
<script src="../js/news.js"></script>
</head>
<body>
	<div>
		<jsp:include page="../top/top.jsp" />
	</div>

	<div id="mainWrap">
		<div>
			<form method="get" action="/news">
				<input type="text" name="findStr" />
				<input type="hidden" name="display" value="16"/>
			</form>
		</div>
		<div id="items">${str}</div>
	</div>

	<div>
		<jsp:include page="../bottom/bottom.jsp" />
	</div>
</body>
</html>