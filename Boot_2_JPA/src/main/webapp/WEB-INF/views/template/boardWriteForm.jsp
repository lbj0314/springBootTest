<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
		<form:form modelAttribute="boardVO" id="frm" enctype="multipart/form-data">
			<div class="form-group">
		      <label for="writer">Writer:</label>
		      <form:input  class="form-control" path="writer"/>
		      <form:errors path="writer"></form:errors>
		    </div>
		    
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <form:input placeholder="Enter title" class="form-control" path="title"/>
		      <form:errors path="title" cssClass="error"></form:errors>
		    </div>
			
			<div class="form-group">
		      <label for="contents">Contents:</label>
			<form:textarea cssClass="form-control" path="contents" id="contents"/>
			<form:errors cssClass="" path="contents"></form:errors>
			</div>
			
			 <div class="row" >
		    	<input type="button"  class="btn btn-info col-sm-3" id="add" value="ADD FILE">
		    	<div id="files" class="col-sm-12"></div>
		    </div>
		    <div class="row"></div>
		     <div class="row" style="margin-top: 50px;">
		    <input type="button" id="write" class="btn btn-danger col-sm-3" value="Write">
		   	</div> 
		</form:form>