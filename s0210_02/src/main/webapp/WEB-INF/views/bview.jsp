<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/read.css">
  <script>
  	const deleteBtn = (bno) => {
  		if(confirm("게시글을 삭제하시겠습니까?")){
  			alert("게시글이 삭제되었습니다.")
  			location.href="/board/bdelete?bno=${list.bno}&page=${page}";
  		}
  	}
  	
  	const modifyBtn = () => {
  		if(confirm("게시글을 수정하시겠습니까?")){
  			location.href="/board/bmodify?bno=${list.bno}";
  		}
  	}
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${list.btitle }</strong></td>
      </tr>
      <tr>
        <td>${list.id }</td>
        <td>조회수</td>
        <td>${list.bhit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${list.bcontent }</td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span>
        <c:if test="${ndto.bno  != null }">
        <a href="/board/bview?bno=${ndto.bno }">${ndto.btitle }</a>
        </c:if>
        <c:if test="${ndto.bno  == null }">
        <a >다음글이 없습니다.</a>
        </c:if>
        </td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span>
        <c:if test="${pdto.bno  != null }"> 
        <a href="/board/bview?bno=${pdto.bno }">${pdto.btitle }</a>
        </c:if>
        <c:if test="${pdto.bno  == null }"> 
        <a>이전글이 없습니다.</a>
        </c:if>
        </td>
      </tr>
    </table>

    <a href="/board/blist?page=${page }"><div class="list">목록</div></a>
    <a onclick="deleteBtn(${list.bno}, ${page })"><div class="list">삭제</div></a>
    <a onclick="modifyBtn()"><div class="list">수정</div></a>
    <a href="/board/breply?bno=${list.bno }&page=${page}"><div class="list">답변달기</div></a>
  </section>
</body>
</html>