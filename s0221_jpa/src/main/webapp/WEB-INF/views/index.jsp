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
	<h4>섹션 : ${session_id }</h4>
	<ul>
		<li><a href="/login">로그인</a></li>
		<li><a href="/member/logout">로그아웃</a></li>
		<li><a href="/member">회원가입</a></li>
		<li><a href="/mlist">회원리스트</a></li>
		<li><a href="/board/blist">게시판</a></li>
		<li><a href="/board/boardwrite">글쓰기</a></li>
		<hr>
		<li><a href="/board/bview?bno=2">게시글보기</a></li>

	</ul>

</body>
</html>