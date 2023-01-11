<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file = "/air/airHeader.jsp" %>
<%
	if(session.getAttribute("loginUser") == null){
		request.setAttribute("message", "로그인이 필요한 페이지입니다.");
		RequestDispatcher rd = request.getRequestDispatcher("/air/airLogin.jsp");
		rd.forward(request, response);
		
	}
%>
<c:if test = "${loginUser.id != param.id }">
<%
request.setAttribute("message", "접근할수 없습니다.");
RequestDispatcher rd = request.getRequestDispatcher("/air/errorPage.jsp");
rd.forward(request, response);
%>
</c:if>
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
<form action = "AirServlet" method = "post" name = "frm">
<input type = "hidden" name = "command" value = "tiket_delete">
<table>
	<tr>
		<th>항공기이름</th><th>출발시간</th><th>도착시간</th><th>출발지</th><th>도착지</th>
		<th>가격</th><th>좌석</th><th>예약자 성함</th><th>핸드폰번호</th><th>결제방법</th><th>취소</th>
	</tr>
	<c:forEach items="${alist }" var = "alist">
	<tr>
		<td>${alist.name }</td>
		<td>${alist.boarding }</td>
		<td>${alist.landing }</td>
		<td>${alist.startpoint }</td>
		<td>${alist.destination }</td>
		<td>${alist.price }</td>
		<c:forEach items="${mlist }" var = "mlist">
		<td>${mlist.air_sit }</td>
		<td>${mlist.kname }</td>
		<td>${mlist.phone }</td>
		<td>${mlist.pay }</td>
		<td><input type = "submit" value = "취소" onclick = "return deleteCheck()"></td>
		<input type = "hidden" name = "id" value = "${mlist.id }">
		<input type = "hidden" name = "air_sit" value = "${mlist.air_sit }">
		<input type = "hidden" name = "name" value = "${alist.name }">
		<input type = "hidden" name = "sid" value = "${loginUser.id }">
		</c:forEach>
	</tr>
	</c:forEach>
</table>
</form>
</div>
</body>
</html>