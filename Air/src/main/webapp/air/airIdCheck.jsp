<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인 페이지</title>
<script type="text/javascript" src = "script/Air.js"></script>
</head>
<body>
<form action = "AirServlet" method = "post" name = "frm">
<input type = "hidden" name = "command" value = "idCheck">
아이디 : 
		
		<input type = "text" name = "id" value = "${id }">
		<input type = "submit" value = "중복체크"><br>
		
	
<c:if test = "${result == -1 }">
	<script type = "text/javascript">opener.document.frm.id.value=""</script>
	${id }는 이미 사용중입니다.
</c:if>
<c:if test = "${result == 1 }">
	${id }는 사용 가능한 아이디 입니다.<br>
	<input type = "button" value ="사용" class="cancer" onclick = "idok()">
</c:if>
</form>
</body>
</html>