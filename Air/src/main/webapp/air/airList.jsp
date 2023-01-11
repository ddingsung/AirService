<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file = "/air/airHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공편</title>
<link rel = "stylesheet" href = "css/Air.css">
</head>
<body>
<div id = "wrap" align = "center">
<form action = "AirServlet" method = "post" name = "frm">
<h1>항공편</h1>
<table>
	<tr>
		<th>num</th><th>항공기이름</th><th>출발 시간</th><th>도착 시간</th><th>출발지</th><th>도착지</th><th>가격</th>
	<tr>
	<c:forEach items = "${list }" var = "list">
	<tr id = "records">
		<td>${list.num }</td>
		<td>${list.name }</td>
		<td>${list.boarding }</td>
		<td>${list.landing }</td>
		<td>${list.startpoint }</td>
		<td>${list.destination }</td>
		<td>${list.price }</td>
	</tr>
	</c:forEach>
</table>
</form>
</div>
</body>
</html>