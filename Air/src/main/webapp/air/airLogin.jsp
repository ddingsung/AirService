<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<div id = "wrap" align = "center">
<h1>회원 로그인</h1>
<form action = "AirServlet" method = "post" name = "frm">
<input type = "hidden" name = "command" value = "login_check">
<table>
	<tr>
		<th>아이디</th>
		<td><input type = "text" name = "id" size = "20"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type = "password" name = "pass" size = "20"></td>
	</tr>
	<tr>
		<td colspan = "2" align ="center">${message }</td>
	</tr>
</table>
<input type = "submit" value = "로그인" onclick = "return loginCheck()">
<input type = "button" value = "회원가입" onclick = "location.href = 'AirServlet?command=air_join_form'">
</form>
</div>
</body>
</html>