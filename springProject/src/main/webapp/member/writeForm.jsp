<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.clfix { *zoom:1; }
	.clfix:after { content: ''; clear: both; display: block; }
	
	.content_wrap{}
	
	#writeForm{float: left;}
	
	.checkBox{width: 40%; float: left;}
	.checkBox > div{ height: 35px; border: 1px solid #eaeaea; box-sizing: border-box;}
</style>
<div class="content_wrap clfix">
	<form name="writeForm" id="writeForm" method="post" action="/miniproject/member/write.do">
		<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<th width="80">이름</th>
			<td><input type="text" name="name" id="name" placeholder="이름 입력"></td>
		</tr>
		<tr>
			<th width="80">아이디</th>
			<td>
				<input type="text" name="id" placeholder="아이디 입력" style="width: 200px;">
				<input type="hidden" name="check" value="">
			</td>
		</tr>
		<tr>
			<th width="80">비밀번호</th>
			<td><input type="password" name="pwd" style="width: 230px;"></td>
		</tr>
		<tr>
			<th width="80">재확인</th>
			<td><input type="password" name="repwd" style="width: 230px;"></td>
		</tr>
		<tr>
			<th width="80">성별</th>
			<td>
				<input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1">여
			</td>
		</tr>
		<tr>
			<th width="80">이메일</th>
			<td>
				<input type="text" name="email1" style="width: 150px;">
				@
				<input type="text" name="email2" placeholder="직접입력" list="list">
				<datalist id="list">
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="google.com">google.com</option>
					<option value="nate.net">nate.net</option>
				</datalist>
			</td>
		</tr>
		<tr>
			<th width="80">핸드폰</th>
			<td>
				<select name="tel1" style="width: 50px;">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="012">019</option>
				</select>
				-
				<input type="text" name="tel2" style="width: 50px;">
				-
				<input type="text" name="tel3" style="width: 50px;">
			</td>
		</tr>
		<tr>
			<th width="80">주소</th>
			<td>
				<input type="text" name="zipcode" id="daum_zipcode" style="width: 70px;" readonly>
				<input type="button" value="우편번호검색" id="checkPostBtn"><br>
				<input type="text" name="addr1" id="daum_addr1" style="width: 350px;" placeholder="주소" readonly><br>
				<input type="text" name="addr2" id="daum_addr2" style="width: 350px;" placeholder="상세 주소">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="checkWrite()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
		</table>
	</form>
	
	<div class="checkBox">
		<div id="nameCheck"></div>
		<div id="idCheck"></div>
		<div id="pwdCheck01"></div>
		<div id="pwdCheck02"></div>
	</div>
</div>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/member.js" type="text/javascript"></script>















