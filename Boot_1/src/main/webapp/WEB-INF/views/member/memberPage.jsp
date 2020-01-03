<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp" />
</head>
<body>
	<c:import url="../template/nav.jsp" />
	
	<div class="container">
	  <h2>My Page</h2>
	  <form action="./memberUpdate" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="id">ID:</label>
	      <input type="text" class="form-control" value="${member.id}" id="id" readonly="readonly" name="id">
	    </div>
	    
	    <!-- <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" readonly="readonly" name="pw">
	    </div> -->
	    
	    <!-- <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	    </div> -->
	    
	    <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" value="${member.name}" id="name" readonly="readonly" name="name">
	    </div>
	    
	    <div class="form-group">
	      <label for="email">E-mail:</label>
	      <input type="email" class="form-control" value="${member.email}" id="email" readonly="readonly" name="email">
	    </div>
	    
	    <div class="form-group">
	      <label for="files">File:</label>
	      <img alt="" src="../upload/${member.memberFilesVO.fname}">
	      <!-- <input type="file" class="form-control" id="files" name="files"> -->
	    </div>
	    
	    <a class="btn btn-primary" href="./memberFileDown?fnum=${member.memberFilesVO.fnum}">FileDown</a>
	  </form>
	</div>
</body>
</html>