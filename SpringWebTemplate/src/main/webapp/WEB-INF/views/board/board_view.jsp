<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div id="content">

	<div class="page-header">
		<h1>
			Test <small>board</small>
		</h1>
	</div>
	<div class="board-view">
		<table class="table" id="board_view_table">
			<thead>
				<tr>
					<td class="id"><span class="glyphicon glyphicon-blackboard" aria-hidden="true"></span>1234</td>
					<td class="name"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>User1</td>
					<td class="date"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>2018/01/06</td>
					<td class="viewing"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>123</td>
				</tr>
				<tr>
					<td colspan="8" class="title">Title</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8">
						<div class="panel panel-default">
							<div class="panel-body content">
							    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.
							</div>
							<div class="panel-footer">
								<a class="file" href=""><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> abc.xlsx</a>
								<a class="file" href=""><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> abc.xlsx</a>
								<a class="file" href=""><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> abc.xlsx</a>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<div class="menu">
			<div class="back">
				<button class="btn btn-default" class="cancel">List</button>
			</div>
			<div class="update">
				<button class="btn btn-default" id="board_view_update">Update</button>
				<button class="btn btn-default" id="board_view_delete">Delete</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$('.cancel').click(function(){
	history.back();
});
$('#board_view_update').click(function(){
	location.href='/board/update';
});
</script>