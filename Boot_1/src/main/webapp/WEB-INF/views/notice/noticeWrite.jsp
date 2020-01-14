<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Write</title>
<!-- include summernote css/js -->
<c:import url="../template/boot.jsp" />
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

</head>
<body>
	<c:import url="../template/nav.jsp" />

	<div class="container">
		<h2>Notice Write</h2>
		<form:form id="frm" action="./noticeWrite" modelAttribute="noticeVO" method="post" enctype="multipart/form-data">
			<div class="form-group">
     			<label for="id">title:</label>
     			<form:input path="title" class="form-control" id="title" placeholder="Enter title"/>
   				<form:errors path="title"/>
   			</div>
			<div class="form-group">
      			<label for="writer">writer:</label>
      			<form:input path="writer" class="form-control" id="writer" value="${member.id}"/>
    			<form:errors path="writer"/>
    		</div>
    		<div class="form-group">
      			<label for="contents">contents:</label>
      			<form:textarea path="contents" class="form-control" id="contents" placeholder="Enter Contents"/>
    			<form:errors path="contents"/>
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
	</div>
	<script type="text/javascript" src="../js/summernote.js" ></script>
	<script type="text/javascript" src="../js/fileCount.js"></script>
</body>
</html>