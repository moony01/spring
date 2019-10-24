<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
#subject {font-size: 30pt; font-weight: bold; }
</style>

<table border="1" width="450" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<td colspan="3" id="subject">${boardDTO.subject } <span id="subject"></span></td>
	</tr>
	<tr>
		<th width="150">글번호 : ${seq }</th>
		<th width="150">작성자 : ${boardDTO.id } <span id="id"></span></th>
		<th width="150">조회수 : ${boardDTO.hit } <span id="hit"></span></th>
	</tr>
	<tr>
		<td colspan="3" height="200" valign="top">
			<pre style="white-space: pre-line; word-break: break-all;">${boardDTO.content } <span id="content"></span></pre>
		</td>
	</tr>
</table>
	<input type="button" value="목록" onclick="location.href='/miniproject/board/boardList?pg=${pg}'">
	<input type="button" value="답글" onclick="location.href='/miniproject/board/boardReplyForm.do?pseq=${boardDTO.seq }&pg=${pg }'">             
	
	<input type="button" value="글수정" onclick="location.href='boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">     
	<input type="button" value="글삭제" onclick="location.href='boardDelete.do?seq=${boardDTO.seq }'">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- <script src="../js/board.js" type="text/javascript"></script> -->
<script type="text/javascript">
$(document).ready(function(){
	
	$.ajax({
		type: 'post',
		url: '/springProject/board/getBoard',
		data: {'seq': '${seq }'},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));	
			
			$('#subject').text(data.boardDTO.subject);
			$('#id').text(data.boardDTO.id);
			$('#hit').text(data.boardDTO.hit);
			$('#content').text(data.boardDTO.content);
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>











