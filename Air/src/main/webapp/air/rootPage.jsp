<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
<h1>관리페이지</h1>
<ul>
	<li><a href = "AirServlet?command=member_manager&id=${param.id }">예매자 관리</a></li>
	<li><a href = "AirServlet?command=air_manager&id=${param.id }">항공편 관리</a></li>
	<li><a href = "#">기타</a></li>
</ul>
</div>
</body>
</html>