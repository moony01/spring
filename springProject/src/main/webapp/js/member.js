$('#loginBtn').click(function(){
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	
	if($('#loginId').val()==''){
		$('#LoginIdDiv').text('아이디를 입력하세요').css('color','red').css('font-size','8pt');
	} 
	
	if($('#loginPwd').val()==''){
		$('#LoginPwdDiv').text('비밀번호를 입력하세요').css('color','red').css('font-size','8pt');
	}
	
	else {
		$.ajax({
			type: 'post',
			url: '/springProject/member/login',
			data: 'id='+$('#loginId').val()+'&pwd='+$('#loginPwd').val(),
			dataType: 'text',
			success: function(data){
				if(data == "success"){
					location.href = '/springProject/main/index'
				} else if(data == "fail") {
					$('#loginResultDiv').text('로그인 실패').css('color','red').css('font-size','8pt');
				}
			},
			error: function(e){
				console.log(e);
			}
			
		});
	}
});

function checkWrite() {
	$('#nameCheck').empty();
	$('#idCheck').empty();
	$('#pwdCheck01').empty();
	$('#pwdCheck02').empty();
	
	if(document.writeForm.name.value=="")
		$("#nameCheck").text('*이름을 입력하세요').css('color','red').css('font-size','8pt');
	else if(document.writeForm.id.value=="")
		$("#idCheck").text('*아이디를 입력하세요').css('color','red').css('font-size','8pt');
	else if(document.writeForm.pwd.value=="")
		$("#pwdCheck01").text('*비밀번호를 입력하세요').css('color','red').css('font-size','8pt');
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		$("#pwdCheck02").text('*비밀번호가 맞지 않습니다.').css('color','red').css('font-size','8pt');
	else if(document.writeForm.check.value!=document.writeForm.id.value)
		$("#idCheck").text('*중복체크 하세요').css('color','red').css('font-size','8pt');
	else
		document.writeForm.submit();
}

$('input[name=id]').focusout(function(){
	if($('input[name=id]').val()=='')
		$('#idCheck').text('먼저 아이디를 입력하세요').css('color','magenta').css('font-size','8pt');
	else
		$.ajax({
			type: 'post',
			url: '/springProject/member/checkId',
			data: 'id='+$('input[name=id]').val(),
			dataType: 'text',
			success: function(data){
				if(data=="exist")
					$('#idCheck').text('사용 불가능').css('color','magenta').css('font-size','8pt');
				else if(data=="not_exist"){
					$('#idCheck').text('사용 가능').css('color','blue').css('font-size','8pt');;
					$('#check').val($('#id').val());
				}
			},
			error: function(err){
				console.log(err);
			}
		});
});

$('#checkPostBtn').click(function(){
	window.open("/springProject/member/checkPost","","width=500 height=500 scrollbars=yes");
});

$('#postSearchBtn').click(function(){
	$('#sidoDiv').empty();
	$('#sigunguDiv').empty();
	$('#roadnameDiv').empty();
	
	if($('#sido').val()=='시도선택')
		$('#sidoDiv').text('시도를 선택하세요').css('color','magenta').css('font-size','8pt');
	else if($('#sido').val()!='세종' && $('#sigungu').val()=='')
		$('#sigunguDiv').text('시군구를 입력하세요').css('color','red').css('font-size','8pt');
	else if($('#roadname').val()=='')
		$('#roadnameDiv').text('도로명을 입력하세요').css('color','red').css('font-size','8pt');
	else {
		$.ajax({
			type: 'post',
			url: '/springProject/member/postSearch',
			data: $('#postSearchForm').serialize(),
			dataType: 'json',
			success: function(data){
				//JSON.stringify(data);
				
				$('table tr:gt(2)').remove();
				
				$.each(data.list , function(index, items){
					var address = items.sido+''
								+ items.sigungu+''
								+ items.yubmyundong+''
								+ items.ri+''
								+ items.roadname+''
								+ items.buildingname;
					
					address = address.replace(/null/g, '')
					
					$('<tr/>').append($('<td/>', {
						align: 'center',
						text: items.zipcode
					})).append($('<td/>', {
						colspan: '3',
						}).append($('<a/>', {
							href: '#',
							id: 'addressA',
							text: address
						}))
					).appendTo($('#postTable'));		 
				});//each
				
				$('a').click(function(){
					//alert($(this).parent().prev().text().prop('tagName'));
					//this는 (object object)니까 prop함수로 가져와야댐
					
					//alert($(this).parent().prev().text());
					
					//alert($(this).text());
					
					$('#daum_zipcode', opener.document).val($(this).parent().prev().text());
					$('#daum_addr1',  opener.document).val($(this).text());
					window.close();
				});
			},
			error: function(error){
				console.log(err);
			}
		});
	}
});

function checkPostClose(zipcode, address){
//	opener.writeForm.zipcode.value = zipcode;
//	opener.writeForm.addr1.value = address;
//	window.close();
//	opener.writeForm.addr2.focus();
	
//	opener.document.forms[0].zipcode.value = zipcode;
//	opener.document.forms[0].addr1.value = address;
//	window.close();
//	opener.document.forms[0].addr2.focus();
	
	opener.document.getElementById("daum_zipcode").value = zipcode;
	opener.document.getElementById("daum_addr1").value = address;
	window.close();
	opener.document.getElementById("daum_addr2").focus();
	
}

function checkLogin(){
	if(document.loginForm.id.value=="")
		alert("아이디를 입력하세요");
	else if(document.loginForm.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else
		document.loginForm.submit();
}

function checkModify(){
	if(document.modifyForm.name.value=="")
		alert("이름을 입력하세요");
	else if(document.modifyForm.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value)
		alert("비밀번호가 맞지 않습니다")
	else
		document.modifyForm.submit();
}













