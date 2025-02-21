<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
		<style>
			label{display: inline-block; width: 70px;}
		</style>
	</head>
	<body>
	  <h2>회원정보수정</h2>
	  <form action="memUpdate" method="post">
	    <label>아이디</label>
	    <input type="text" name="id" value="${member.id }"><br/>
	    <label>패스워드</label>
	    <input type="text" name="pw"  value="${member.pw }"><br/>
	    <label>이름</label>
	    <input type="text" name="name"  value="${member.name}"><br/>
	    <label>전화번호</label>
	    <input type="text" name="phone"  value="${member.phone }"><br/>
	    <label>성별</label><br/>
	    <input type="radio" id="man" name="gender" value="남자" ${(fn:contains(member.gender, "남자"))?'checked':'' }>
	    <label for="man">남자</label>
	    <input type="radio" id="woman" name="gender" value="여자" ${(fn:contains(member.gender, "여자"))?'checked':'' }>
	    <label for="woman">여자</label>
	    <br/>
	    <label>취미</label><br/>
	    <input type="checkbox" id="game" name="hobby" value="게임" ${(fn:contains(member.hobby, "게임"))?'checked':'' }>
	    <label for="game">게임</label>
	    <input type="checkbox" id="golf" name="hobby" value="골프" ${(fn:contains(member.hobby, "골프"))?'checked':'' }>
	    <label for="golf">골프</label>
	    <input type="checkbox" id="swim" name="hobby" value="수영" ${(fn:contains(member.hobby, "수영"))?'checked':'' }>
	    <label for="swim">수영</label>
	    <input type="checkbox" id="run" name="hobby" value="조깅" ${(fn:contains(member.hobby, "조깅"))?'checked':'' }>
	    <label for="run">조깅</label>
	    <input type="checkbox" id="book" name="hobby" value="독서" ${(fn:contains(member.hobby, "독서"))?'checked':'' }>
	    <label for="book">독서</label>
	    <br/>
	    <input type="submit" value="회원정보수정">
	  </form>
	  
	  <div><a href="/">메인페이지 이동</a></div>
	  <div><a href="/memUpdate?id=${member.id }">회원정보수정</a></div>
	
	</body>
</html>