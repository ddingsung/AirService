<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 폼</title>
<link rel = "stylesheet" href = "air/Air.css">
<style>
#wrap{
position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  text-align:center;
}
#text{
	 width:300px;
  height:30px;
  font-size:20px;
}
</style>
</head>
<body>
<form action = "AirServlet" method = "post" name = "frm">
<input type = "hidden" name = "command" value = "main_search_form">
<div id = "wrap" align = "center">
<section>
<table>
	<tr>
		<td><input id = "text" type = "text" name = "startpoint" placeholder="출발지를 입력해주세요." 
		onfocus = "this.placeholder=''" onblur = "this.placeholder='출발지를 입력해주세요.'"></td>
	</tr>
	<tr>
		<td height = "25px"></td>
	</tr>
	<tr>
		<td><input id = "text" type = "text" name = "destination" placeholder="도착지를 입력해주세요." 
		onfocus = "this.placeholder=''" onblur = "this.placeholder='도착지를 입력해주세요.'"></td>
	</tr>
</table>
<br><br>
<input type = "submit" value = "검색" style = "width : 100px;" onclick = "return searchCheck()">
</section>
</div>
</form>
</body>
</html>