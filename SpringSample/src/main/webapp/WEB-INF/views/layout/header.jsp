<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	  
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="/">Test</a>
	    </div>
	    
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#" data-toggle="modal" data-target="#loginModal">Sign in</a></li>
	            <li><a href="/member/join">Sign up</a></li>
	            <li><a href="/board">Board</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="/logout">Sign out</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	    
	  </div>
	
	</nav>
</div>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginModalLabel">Sign in</h4>
      </div>
      <div class="modal-body">
      
<form>
	<div class="form-group">
		<input type="text" class="form-control" id="loginUserId" placeholder="UserId">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" id="loginPassword" placeholder="Password">
	</div>
</form>
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Sign in</button>
      </div>
    </div>
  </div>
</div>