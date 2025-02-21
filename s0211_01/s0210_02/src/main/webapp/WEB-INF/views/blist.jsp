<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/notice_list.css">
  <style>
  a {text-decoration: none; color: inherit;}
  </style>
  <script>
  const searchBtn = () => {
	  alert("검색을 짆애합니다.")
	  if($(".searchW").val().length <1){
		  alert("검색어를 입력하셔야 검색이 가능합니다.")
		  $(".searchW").focus();
		  return;
	  }
	  alert("검색을 진행합니다.")
	  searchFrm.submit();
  }
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/board/blist" name="searchFrm" method="get">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="btitle">제목</option>
          <option value="bcontent">내용</option>
        </select>

        <div class="title">
          <input type="text" name="searchW" class="searchW"  size="16">
        </div>
  
        <button type="button" onclick="searchBtn()"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="13%">
        <col width="*">
        <col width="13%">
        <col width="13%">
        <col width="13%">
        <col width="13%">
        <col width="5%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>파일첨부</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach items="${list }" var="bdto">
      <tr>
        <td><span class="table-notice">${bdto.bno }</span></td>
        <td class="table-title">
        <a href="/board/bview?bno=${bdto.bno }&page=${page}">
        <c:forEach var="i" begin="1" end="${bdto.bindent}">
        ⤿
        </c:forEach> 
        ${bdto.btitle }</a>
        </td>
        <td>${bdto.id}</td>
        <td><fmt:formatDate value="${bdto.bdate}" pattern="yyyy-MM-dd"/></td>
        <td>${bdto.bhit }</td>
        <td>
        	<c:if test="${bdto.bfile != null }">
        		<a href="/upload/board/${bdto.bfile }" download>
        		<img src="/images/fileicon.png" width="20px">
        		</a>
        	</c:if>
        </td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
      <a href="/board/blist?page=1&category=${category}&searchW=${searchW}"><li class="first"></li></a>
      <c:if test="${page < 1 }">
      <a href="/board/blist?page=1&category=${category}&searchW=${searchW}"><li class="prev"></li></a>
      </c:if>
      <c:if test="${page > 1 }">
      <a href="/board/blist?page=${page-1 }&category=${category}&searchW=${searchW}"><li class="prev"></li></a>
      </c:if>
      <c:forEach var="i" begin="${ startpage}" end="${ endpage}">
      <c:if test="${page==i }">
      <li class="num on"><div>${i }</div></li>
      </c:if>
      <c:if test="${page!=i }">
      <a href="/board/blist?page=${i }&category=${category}&searchW=${searchW}">
      <li class="num "><div>${i }</div></li>
      </c:if>
      </a>
      </c:forEach>
      <c:if test="${page < endpage }">
      <a href="/board/blist?page=${page+1 }&category=${category}&searchW=${searchW}"><li class="next"></li></a>
      </c:if>
      <c:if test="${page > endpage }">
      <a href="/board/blist?page=${endpage }&category=${category}&searchW=${searchW}"><li class="next"></li></a>
      </c:if>
      <a href="/board/blist?page=${endpage }&category=${category}&searchW=${searchW}"><li class="last"></li></a>
    </ul>

    <a href="bwrite"><div class="write">쓰기</div></a>
  </section>

</body>
</html>