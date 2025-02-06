<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<div><a href="/">메인페이지 이동</a></div>
<form action="login" method="post">
<label>아이디</label>
<input type="text" name="id">
<label>비밀번호</label>
<input type="password" name="pw">
<input type="submit" value="로그인">
</form>

</body>
</html>