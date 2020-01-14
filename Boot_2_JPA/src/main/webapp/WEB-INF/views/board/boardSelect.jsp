<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
<h1>${ board } Select Page</h1>
	<div class="container">
	<table class="table">
			
			<tr>
			<th>NUM</th>
			<th width="60%">TITLE</th>
			<th>WRITER</th>
			<th>DATE</th>
			<th>HIT</th>
			</tr>
		
			<tr>
					<td>${ vo.num } </td>
					<td>${ vo.title }</td>
					<td>${ vo.writer}</td>
					<td>${ vo.regDate }</td>
					<td>${ vo.hit } </td>
				</tr>
			
	</table>
	<div class="form-group">
		<textarea rows="20" cols="160">${ vo.contents }</textarea>
	</div>
	<div>
	<c:forEach items="${vo.noticeFilesVOs}" var="file">
			<img alt="${file.oname}" src="../resources/upload/${board}/${file.fname}">
			<a href="./fileDown?fnum=${file.fnum}">${file.oname}</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
	</div>
		<div>

			<a href="./${board}Update?num=${vo.num }" class="btn btn-success">Update</a>
			<a href="./${board}Delete?num=${vo.num }" class="btn btn-danger">Delete</a>
			<a href="./${board}Reply?num=${vo.num }" class="btn btn-info">Ref</a>
			<a href="./${board}List" class="btn btn-primary">List</a>
		</div>
	</div>
</body>
</html>