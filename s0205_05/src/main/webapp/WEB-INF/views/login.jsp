<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지 입니당</h2>

	<form action="/dologin" method="post">
		<label>아이디</label> 
		<input type="text" name="id"> 
		<br/>
		<label>비밀번호</label>
		<input type="text" name="pw"> 
		<br/>
		<input type="submit" name="전송">
	</form>
	
	<div><a href="/">메인페이지로 이동</a></div>

</body>
</html>