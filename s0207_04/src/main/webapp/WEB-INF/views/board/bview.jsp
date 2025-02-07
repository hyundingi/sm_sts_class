<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
h2 {
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	margin: 10px auto;
}

th {
	background-color: yellowgreen;
}

th, td {
	width: 150px;
	height: 40px;
	text-align: center;
}
</style>
</head>
<body>
	<h2>게시글 보기</h2>
	<table>
		<colgroup>
			<col width=10%>
			<col width=*>
			<col width=15%>
			<col width=15%>
			<col width=15%>
		</colgroup>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td></td>
		</tr>
		
		
	</table>
	<div>
		<a href="/">메인페이지 이동</a>
	</div>

</body>
</html>