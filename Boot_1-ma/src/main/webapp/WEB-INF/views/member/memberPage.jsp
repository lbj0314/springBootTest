<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/boot.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />

<div class="container">
	<h1>ID :  ${member.id}</h1>
	<h1>Name : ${member.name}</h1>
	<h1>Email : ${member.email}</h1>
	<h1>Photo</h1>
	<img alt="" src="../upload/${member.memberFilesVO.fname}">
	<a class="btn btn-primary" href="./memberFileDown?fnum=${member.memberFilesVO.fnum}">FileDown</a>
</div>

</body>
</html>