<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="content">
   	<form:form id="member_join_form" commandName="user">
		<div class="panel panel-default">
	  		<div class="panel-heading">
	    		<h3 class="panel-title">Sign up</h3>
	  		</div>
		  	<div class="panel-body">
				  <c:set var="eruserId"><form:errors path="userId" /></c:set>
				  <div class="form-group <c:if test="${not empty eruserId}">has-error</c:if>">
				    <label for="userId"><spring:message code="join.userId"/></label>
				    <input type="text" class="form-control" name="userId" value="${user.userId}">
				    <c:if test="${not empty eruserId}"><span class="has-error-msg">${eruserId}</span></c:if>
				  </div>
				  <c:set var="erPassword"><form:errors path="password" /></c:set>
				  <div class="form-group <c:if test="${not empty erPassword}">has-error</c:if>">
				    <label for="password"><spring:message code="join.password"/></label>
				    <input type="password" class="form-control" name="password" value="${user.password}">
				    <c:if test="${not empty erPassword}"><span class="has-error-msg">${erPassword}</span></c:if>
				  </div>
				  <c:set var="erName"><form:errors path="userName" /></c:set>
				  <div class="form-group <c:if test="${not empty erName}">has-error</c:if>">
				    <label for="userName"><spring:message code="join.userName"/></label>
				    <input type="text" class="form-control" name="userName" value="${user.userName}">
				    <c:if test="${not empty erName}"><span class="has-error-msg">${erName}</span></c:if>
				  </div>
				  <c:set var="erEmail"><form:errors path="email" /></c:set>
				  <div class="form-group <c:if test="${not empty erEmail}">has-error</c:if>">
				    <label for="emailAddr"><spring:message code="join.email"/></label>
				    <input type="email" class="form-control" name="email" value="${user.email}">
				    <c:if test="${not empty erEmail}"><span class="has-error-msg">${erEmail}</span></c:if>
				  </div>
				  <c:set var="erGender"><form:errors path="gender" /></c:set>
				  <div class="form-group">
					  <label><spring:message code="join.gender"/></label>
					  <div class="radio">
					  	<label class="radio-inline">
						  <form:radiobutton path="gender" value="M" /> M
						</label>
						<label class="radio-inline">
						  <form:radiobutton path="gender" value="F" /> F
						</label>
					  </div>
					  <c:if test="${not empty erGender}"><span class="has-error-msg">${erGender}</span></c:if>
				  </div>
				  <c:set var="erInterests"><form:errors path="interests" /></c:set>
				  <div class="form-group">
					  <label><spring:message code="join.interests"/></label>
					  <div class="checkbox">
						  <label class="checkbox-inline">
						 	<form:checkbox path="interests" value="1" /> Java
						  </label>
						  <label class="checkbox-inline">
						 	<form:checkbox path="interests" value="2" /> JavaScript
						  </label>
						  <label class="checkbox-inline">
						 	<form:checkbox path="interests" value="3" /> Node.js
						  </label>
						  <label class="checkbox-inline">
						 	<form:checkbox path="interests" value="4" /> Python
						  </label>
					  <!-- 
					  	<c:forEach var="interest" items="${interests}">
					  		<label class="checkbox-inline">
							  <form:checkbox path="interests" value="${interest.id}" /> ${interest.name}
							</label>
					  	</c:forEach>
					   -->
					  </div>
					  <c:if test="${not empty erInterests}"><span class="has-error-msg">${erInterests}</span></c:if>
				  </div>
		  	</div>
		</div>
		<div class="text-right">
			<button class="btn btn-primary" id="submit">Submit</button>
			<button class="btn btn-default" id="cancel">Cancel</button>
		</div>
	</form:form>
</div>

<script type="text/javascript">
$("#submit").click(function(){
	var form = $("#member_join_form");
	form.attr("action", "/member/join");
	form.attr("method", "post");
	form.submit();
});
$("#cancel").click(function(){
	
});
</script>
