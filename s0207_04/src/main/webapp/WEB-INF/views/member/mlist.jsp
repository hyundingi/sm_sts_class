<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<h2>회원정보</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>번호</th>
			<th>성별</th>
			<th>취미</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${list }" var="mdto">
		<tr>
			<td>${mdto.id }</td>
			<td>${mdto.pw }</td>
			<td>${mdto.name }</td>
			<td>${mdto.phone }</td>
			<td>${mdto.gender }</td>
			<td>${mdto.hobby }</td>
			<td>${mdto.mdate }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>