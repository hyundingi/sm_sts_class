<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인페이지</h2>
	<c:if test="${session_id == null }">
		<div>session_id : 섹션 아이디가 엄서용~</div>
	</c:if>
	<c:if test="${session_id != null }">
		<div>session_id : ${session_id}</div>
	</c:if>
	<ul>
		<a href="login">로그인</a>
	</ul>
	<ul>
		<a href="logout">로그아웃</a>
	</ul>

</body>
</html>