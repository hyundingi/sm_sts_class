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
<form action="/member/join" method="post">
<label>아이디</label>
<input type="text" name="id"><br>
<label>비밀번호</label>
<input type="text" name="pw"><br>
<label>이름</label>
<input type="text" name="name"><br>
<label>번호</label>
<input type="text" name="phone"><br>
<label>성별</label>
<input type="text" name="gender"><br>
<label>취미</label>
<input type="text" name="hobby"><br>
<input type="submit" value="전송">

</form>

</body>
</html>