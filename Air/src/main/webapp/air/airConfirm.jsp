<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/air/airHeader.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<h1>예매 완료</h1><br>
<c:forEach items = "${list }" var = "list">
${list.kname }님 ${list.air_name }항공편의 ${list.air_sit } 좌석을 성공적으로 예매하였습니다! (결제 방식 : 
<c:choose>
	<c:when test = "${list.pay == 'card' }">
	카드)
	</c:when>
	<c:when test = "${list.pay == 'bank' }">
	무통장입금)
	</c:when>
	<c:otherwise>
	마일리지ㅇ)
	</c:otherwise>
</c:choose>
</c:forEach>

</body>
</html>