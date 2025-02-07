<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인페이지</h2>
	<ul>
	<c:if test="${session_id == null}">
		<li><a href="/member/login">로그인</a></li>
		<li><a href="/member/join">회원가입</a></li>
	</c:if>
	
	<c:if test="${session_id != null}">
		<li><a href="/board/blist">게시판</a></li>
		<li><a href="/board/bview?bno=2">게시글보기</a></li>
		<li><a href="/member/mlist">회원정보</a></li>
		<li><a href="/member/logout">로그아웃</a></li>
	</c:if>
	
	</ul>

</body>
</html>