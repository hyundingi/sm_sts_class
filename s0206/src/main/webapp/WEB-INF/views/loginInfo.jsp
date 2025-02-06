<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2{text-align: center;}
table, th, td{border: 1px solid black; border-collapse: collapse;}
table{margin: 10px auto;}
th{backgroud-color: pink;}
th, td{width: 150px; height: 40px; text-align: center;}
</style>
</head>
<body>
<h2>로그인정보</h2>
	<table>
	<colgroup>
		<col width= 15%>
		<col width= 15%>
		<col width= 15%>
		<col width= 15%>
	</colgroup>
		<tr>
			<th>아이디</th>
			<th>아이디</th>
			<th>패스워드</th>
			<th>패스워드</th>
		</tr>
		<tr>
			<td>${member.id }</td>
			<td>${id }</td>
			<td>${member.pw }</td>
			<td>${pw }</td>
		</tr>
	</table>
	<div>
		<a href="/">메인페이지 이동</a>
	</div>

</body>
</html>