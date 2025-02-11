<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{box-sizing: border-box;}
a{color: inherit; text-decoration: none;}
li {list-style: none; height: 35px; padding-top: 3px;}
li:hover {background: white; opacity: 80%; font-weight: bold;}
div{background: lightgray; width: 200px; height: 300px; display: flex; justify-content: center; padding-right: 45px;}
</style>
<script>
if("${param.logout}" == "1"){
	alert("로그아웃 되었습니다.")
	location.href="/"
}
</script>

</head>
<body>
	<h2>메인페이지</h2>
	<h4>섹션 : ${session_id }</h4>
	<h4>${session_name }님 환영합니다. ༊*·˚˗ˋˏϟˎˊ˗˗ˋˏϟˎˊ˗˗.͙·☽˗˗ˋˏϟˎˊ˗˗ˋˏϟˎˊ˗˗ˋˏϟˎˊ˗</h4>
	<div>
	<ul>
		<li><a href="/member/login">﻿~❥ 로그인</a></li>
		<li><a href="/member/logout">﻿~❥﻿ 로그아웃</a></li>
		<li><a href="/member/member">﻿~❥ 회원가입</a></li>
		<li><a href="/board/blist?page=1">﻿~❥ 게시판</a></li>
		<li><a href="/board/bwrite">﻿~❥ 글쓰기</a></li>
		<hr>
		<li><a href="/board/bview?bno=2">﻿~❥ 게시글보기</a></li>
		<li><a href="/member/mlist">﻿~❥ 회원정보</a></li>

	</ul>
	</div>

</body>
</html>