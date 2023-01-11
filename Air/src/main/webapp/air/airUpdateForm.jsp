<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/Air.css">
<script type="text/javascript" src = "script/Air.js">
</script>
</head>
<body>
<div id = "wrap" align = "center">
<form name = "frm" action = "AirServlet" method = "post">
<input type = "hidden" name = "command" value = "memberUpdate">
<h1>항공 수정</h1>
<section>
<table>
	<tr>
		<td>이름</td>
		<td><input type = "text" name = "name" value = "${list.name }"></td>
	</tr>
	<tr>
		<td>출발 시간</td>
		<td><input type=  "text" name = "landing" value = "${list.landing }"></td>
	</tr>
	<tr>
		<td>도착 시간</td>
		<td><input type=  "text" name = "boarding" value = "${list.boarding }"></td>
	</tr>
	<tr>
		<td>출발지</td>
		<td><input type=  "text" name = "startpoint" value = "${list.startpoint }"></td>
	</tr>
	<tr>
		<td>도착지</td>
		<td><input type=  "text" name = "destination" value = "${list.destination }"></td>
	</tr>
</table>
<input type = "submit" value = "수정" onclick = "return updateCheck()">
<input type = "reset" value = "다시작성">
</section>
</form>
</div>
</body>
</html>