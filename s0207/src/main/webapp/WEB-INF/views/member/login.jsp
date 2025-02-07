<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<script>
		if("${param.chk}"=="0"){
			alert("아이디 또는 패스워드가 일치하지 않습니다.")
		}
	</script>
	<form action="/member/login" method="post">
		<label>아이디</label> 
		<input type="text" name="id"> <br/>
		<label>비밀번호</label>
		<input type="password" name="pw"> <br/>
		<input type="submit" value="로그인">
	</form>
	<div>
		<a href="/">메인페이지 이동</a>
	</div>

</body>
</html>