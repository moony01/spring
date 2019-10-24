<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>글쓰기</h3>
<form>
<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="subject" id="subject" size="50">
			<div id="subjectDiv"></div>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea name="content" id="content" rows="15" cols="50"></textarea>
			<div id="contentDiv"></div>	
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="글쓰기" id="boardWriteBtn">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/board.js" type="text/javascript"></script>























