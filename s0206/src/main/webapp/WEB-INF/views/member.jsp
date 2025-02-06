<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="join" method="post">
		<label>아이디</label> 
		<input type="text" name="id"><br /> 
		<label>패스워드</label>
		<input type="text" name="pw"><br />
		<label>이름</label>
		<input type="text" name="name"><br />
		<label>전화번호</label>
		<input type="text" name="tel"><br />
		<label>성별</label>
		<input type="radio" id="man" name="gender" value="남자">
		<label>남자</label>
		<input type="radio" id="woman" name="gender" value="여자">
		<label>여자</label><br />
		<label>취미</label>
		<input type="checkbox" id="game" name="hobby" value="게임">
		<label>게임</label>
		<input type="checkbox" id="golf" name="hobby" value="골프">
		<label>골프</label>
		<input type="checkbox" id="swim" name="hobby" value="수영">
		<label>수영</label>
		<input type="checkbox" id="run" name="hobby" value="조깅">
		<label>조깅</label>
		<input type="checkbox" id="book" name="hobby" value="독서">
		<label>독서</label>
		<br/>
		<input type="submit" value="회원가입">
	</form>
	<div>
		<a href="/">메인페이지 이동</a>
	</div>
</body>
</html>