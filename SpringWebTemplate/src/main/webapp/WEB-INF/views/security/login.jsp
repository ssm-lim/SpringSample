<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 

<script type="text/javascript">
	$(document).ready(function(){
		$('#goLogin').click(function(){
			$('#loginForm').submit();
		});
	});
</script>
<div>
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="loginModalLabel">Sign in</h4>
      </div>
      <div class="modal-body">
      
		<form id="loginForm" method="POST" action="/auth/login/process">
			<div class="form-group">
				<input type="text" class="form-control" id="loginUserId" name="username" placeholder="UserId" />
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password" />
			</div>
		</form>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default">Close</button>
        <button type="button" class="btn btn-primary" id="goLogin">Sign in</button>
      </div>
    </div>
  </div>
</div>