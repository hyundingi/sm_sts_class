<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인덱스페이지</h2>

<div>로그인 되었습니다. </div>
<div>아이디 : ${id }</div>
<div>비밀번호 : ${pw }</div>
<div>아이디 : ${member.id }</div>
<div>아이디 : ${member.name }</div>

<div><a href="/login">로그인</a></div>

</body>
</html>