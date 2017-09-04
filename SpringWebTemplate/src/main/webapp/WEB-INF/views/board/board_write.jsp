<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content">

	<div class="page-header">
		<h1>
			Test <small>board</small>
		</h1>
	</div>
	<div class="board-write">
		<form class="form-horizontal" role="form" id="board_write_form">
			<div class="form-group">
				<span class="col-md-2 board-label control-label">Name</span>
				<div class="col-md-4">
					<p class="form-control-static">ABC DEFG</p>
				</div>
				<span class="col-md-1 board-label control-label">Password</span>
				<div class="col-md-5">
					<input type="text" class="form-control" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Title</label>
				<div class="col-md-10">
					<input type="text" class="form-control" name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Content</label>
			    <div class="col-md-10">
					<textarea class="form-control" rows="10" name="content"></textarea>
			    </div>
			</div>
			<div class="form-group">
				<label for="inputType" class="col-md-2 control-label">File</label>
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-body">
						    <div class="file">
								<input type="file" name="file">
								<button type="button" class="close delFile" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

		<hr>
		<div class="menu">
			<div class="write">
				<button class="btn btn-default" id="board_write_submit">Write</button>
				<button class="btn btn-default" class="cancel">Cancel</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$('.file').on('change', 'input[name=file]',function(){
	var file = $('.file');
	var count = 0;
	file.find('input[name=file]').each(function(idx, obj){
		if($(obj).val().length == 0){
			count++;
		}
	});
	if(count == 0){
		var clone = $(file[0]).clone(true, true);
		$(file[0]).parent().append(clone);
	}
});
$('.file').on('click', '.delFile',function(){
	if(confirm('Are you sure you want to remove this file?')){
		if($('.file').length > 2){
			$(this).parent().remove();
		} else {
			$(this).find('input[name=file]').val('');
		}	
	}
});
$('#board_write_submit').click(function(){
	var form = $('board_write_form');
	if(form.find('input[name=password]').val() != ''){
		form.find('input[name=password]').focus();
		alert('Enter the password');
	} else if(form.find('input[name=title]').val() != ''){
		form.find('input[name=title]').focus();
		alert('Enter the title');
	} else if(form.find('input[name=content]').val() != ''){
		form.find('input[name=content]').focus();
		alert('Enter the content');
	} else {
		form.action = '/board/write';
		form.method = 'post';
		form.submit();
	}
});
$('.cancel').click(function(){
	history.back();
});
</script>