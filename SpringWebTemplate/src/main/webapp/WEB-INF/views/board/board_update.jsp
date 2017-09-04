<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div id="content">

	<div class="page-header">
		<h1>
			Test <small>board</small>
		</h1>
	</div>
	<div class="board-update">
		<form class="form-horizontal" role="form" id="board_update_form">
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
								<p>asdf.doc</p>
								<button type="button" class="close delFile" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							</div>
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
			<div class="update">
				<button class="btn btn-default" id="board_update_submit">update</button>
				<button class="btn btn-default" class="cancel">Cancel</button>
			</div>
		</div>
	</div>
</div>
