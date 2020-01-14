<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
<c:import url="../template/summernote.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />
	<div class="container">
		<h1>${board} Write Form</h1>
		
		<c:import url="../template/boardWriteForm.jsp" />	
		
	
	</div>
	<script type="text/javascript" src="../js/summernote.js" ></script>
	<script type="text/javascript" src="../js/fileCount.js" ></script>

</body>
</html>