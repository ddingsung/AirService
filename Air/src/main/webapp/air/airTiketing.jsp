<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
	if(session.getAttribute("loginUser") == null){
		request.setAttribute("message", "로그인이 필요한 페이지입니다.");
		RequestDispatcher rd = request.getRequestDispatcher("/air/airLogin.jsp");
		rd.forward(request, response);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/Air.css">
</head>
<body>
<div id = "wrap" align = "center">
<form name = "frm" action = "AirServlet" method = "post">
<input type = "hidden" name = "command" value = "air_tiketing">
<input type = "hidden" name = "air_name" value = "${param.name }">
<input type = "hidden" name = "id" value = "${loginUser.id }">
결제 방법
<select name = "pay">
<option value = "card">카드
<option value = "bank">무통장입금
<option value = "point">마일리지
</select>
&nbsp;
좌석선택
<select name = "air_sit">
<c:forEach items = "${sit}" var = "sit">
 	<c:choose>
		<c:when test = "${sit.status == 'N' }">
			<option value = "${sit.name }">${sit.name }
		</c:when>
	</c:choose>
</c:forEach>
</select>
<br><br>
${loginUser.kname }님이 예약하시려는 비행기 ${param.name }을 예매하시겠습니까?
<br>
<input type = "submit" value = "네">
</form>
</div>
</body>
</html>