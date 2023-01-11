<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main_header{
	position : relative;
	height : 55px
}
#main_header > div.header{
	position : absolute;
	top : 5px;
	right : 0px;
}
.header td{
	border:white;
}
.header ul{
	list-style-type : none;
}
.header ul li {
	display : inline;
	font: normal 12px 'Dotum';
}
</style>
</head>
<body>
<header id = "main_header">
<div class = "header">
	<c:if test = "${empty loginUser }">
	<ul>
		<li>
		<a href = "AirServlet?command=air_login_form" style = "text-decoration:none">로그인</a>
		</li>
	</ul>
	</c:if>
	<c:if test = "${!empty loginUser }">
	<ul>
		<li><b>${loginUser.kname }</b></li>
		<c:choose>
			<c:when test = "${loginUser.root == 'A'}">
			<li>관리자님</li>
			<li><a href = "AirServlet?command=root_page&id=${loginUser.id }">관리자페이지</a></li>
		<li><a href = "AirServlet?command=logout">로그아웃</a></li>
			</c:when>
		<c:otherwise>
			<li>일반회원님</li>
			<li><a href = "AirServlet?command=my_page&kname=${loginUser.kname}&id=${loginUser.id}">마이페이지</a></li>
		<li><a href = "AirServlet?command=logout">로그아웃</a></li>
		</c:otherwise>
		</c:choose>
		
	</ul>
	</c:if>
</div>
</header>

</body>
</html>