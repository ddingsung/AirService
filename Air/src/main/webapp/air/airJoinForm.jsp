<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<%
	if(session.getAttribute("loginUser") != null){
		RequestDispatcher rd = request.getRequestDispatcher("/air/airMain.jsp");
		rd.forward(request, response);
		
	}
%>
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
<input type = "hidden" name = "command" value = "Join">
<h1>회원가입 폼</h1>
<section>
<table>
	<tr>
		<th>아이디</th>
		<td>
		<input type = "text" name = "id" size = "20">*필수
		<input type = "hidden" name = "reid">
		<input type = "button" value = "중복체크" onclick = "idCheck()">
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type = "password" name = "pass" size = "20">*필수</td>
	</tr>
	<tr>
		<th>비밀번호 확인</th>
		<td><input type = "password" name = "passCheck" size = "20">*필수</td>
	</tr>
	<tr>
		<th>한글 이름</th>
		<td><input type = "text" name = "kname" size = "20">*필수</td>
	</tr>
	<tr>
		<th>영어 이름</th>
		<td><input type = "text" name = "ename" size = "20">*필수</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type = "text" name = "email" size = "20">*필수</td>
	</tr>
	<tr>
		<th>핸드폰번호</th>
		<td><input type = "text" name = "phone" size = "20">*필수</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
		<input type = "radio" name = "gender" value = "M">남자
		<input type = "radio" name = "gender" value = "W">여자
		</td>
	</tr>
</table>
<input type = "submit" value = "회원가입" onclick = "return JoinCheck()">
<input type = "reset" value = "다시작성">
</section>
</form>
</div>
</body>
</html>