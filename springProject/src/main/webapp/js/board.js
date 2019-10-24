$('#boardWriteBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val()=='')
		$('#subjectDiv').text('제목을 입력하세요').css('color', 'red').css('font-size','8pt');
	else if($('#content').val()=='')
		$('#contentDiv').text('내용을 입력하세요').css('color', 'red').css('font-size','8pt');
	else
		$.ajax({
			type: 'post',
			url: '/springProject/board/boardWrite',
			data: {'subject': $('#subject').val(), 'content': $('#content').val()},
			success: function(){
				alert("글쓰기 성공");
			},
			error: function(err){
				console.log(err);
			}
		});
});

$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/springProject/board/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items) {
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						href: 'javascript:void(0)',
						text: items.subject,
						id: 'subjectA',
						class: items.seq+'' //a태그에 번호 클래스속성을 주입
					
				}))).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'));
			});
			
			//페이징처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			//로그인 여부
			$('#boardListTable').on("click", '#subjectA', function(){
				//alert($(this).text());
				//alert($(this).prop('tagName'));
				if(data.memId == null)
					alert('먼저 로그인하세요');
				else
					//alert($(this).parent().prev().text());
					//alert($(this).attr('class')); //제목을 클릭한 class속성 얻어오기
					
					location.href='/springProject/board/boardView?seq='
						+$(this).attr('class')
						+'&pg='
						+$('#pg').val();
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});















