<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/board.css">

<input type="hidden" id="pg" value="${pg }">

<table id="boardListTable" border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="100">조회수</th>
	</tr>
</table>


<div id="boardPagingDiv" style="width:700px; text-align: center;"></div>
<br><br>

<form name="" method="post" action="">
<div style="text-align: center;">
<input type="hidden" name="pg" value="1">
<select name="searchOption" id="searchOption" style="width: 80px;">
	<option value="subject">제목
	<option value="id">아이디
</select>
<input type="text" name="keyword" value="${keyword }" placeholder="검색어 입력">
<input type="submit" value="검색">
</div>
</form>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/board.js" type="text/javascript"></script>




<script type="text/javascript">
function isLogin(seq, pg){
	if("${memId}"=="")
		alert("먼저 로그인하세요");
	else
		location.href="/miniproject/board/boardView.do?seq="+seq+"&pg="+pg;		
}

window.onload=function(){
	if('${searchOption}'=='subject' || '${searchOption}'=='id')
		document.getElementById('searchOption').value = '${searchOption}';
}

function boardSearch(pg){
	location.href="/miniproject/board/boardSearch.do?pg="+pg
			+"&searchOption=${searchOption}"
			+"&keyword="+encodeURIComponent("${keyword}");
}
</script>




















