<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content">

	<div class="page-header">
		<h1>Test <small>board</small></h1>
	</div>
	<div class="board-list">
		<table id="board_list_table" class="table table-hover">
			<thead>
				<tr>
					<td class="id"></td>
					<td class="title">Title</td>
					<td class="date">Date</td>
					<td class="writer">Writer</td>
					<td class="viewing">Viewing</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="id">1234</td>
					<td class="title"><a href="/board/view">제목제목</a></td>
					<td class="date">2015/11/05</td>
					<td class="writer">글쓴이</td>
					<td class="viewing">123</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<div class="menu">
			<div class="write">
				<a class="btn btn-default" href="/board/write" role="button">Write</a>
			</div>
			<div class="search text-left">
				<form id="board_list_search_form" class="form-inline input-sm">
				  <div class="form-group">
				    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
				  </div>
				  <div class="form-group">
				    <select class="form-control">
					  <option>1</option>
					  <option>2</option>
					  <option>3</option>
					  <option>4</option>
					  <option>5</option>
					</select>
				  </div>
				  <button class="btn btn-default">Find</button>
				</form>
			</div>
		</div>
	</div>
</div>
