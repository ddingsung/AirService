<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel = "stylesheet" href = "css/Air.css">
<style>
ul{
	list-style-type : none;
}
ul li {
	display : inline;
	font: normal 18px 'Dotum';
}
</style>
</head>
<body>
<div id = "wrap" align = "center">
<h1>${param.kname }(${param.id })님의 마이페이지</h1>
<ul>
	<li><a href = "AirServlet?command=member_tiket&id=${param.id }">예매정보확인</a></li>
	<li><a href = "AirServlet?command=member_update&id=${param.id }">내정보 수정</a></li>
</ul>
</div>
</body>
</html>