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
<div class="contents">
	<div>
		<a href="./${board}Write" class="btn btn-danger">Write</a>
	
	</div>

	<!-- search -->
		<div>
			<form id="frm" action="./${board}List" method="get">
			<input type="hidden" id="curPage" value="1" name="curPage">
			<select name="kind">
				<option id="kt" value="kt">title</option>
				<option id="kc" value="kc">contents</option>
				<option id="kw" value="kw">writer</option>
			</select>
			<%-- <input type="text" id="search" name="search" value="${pager.search}"> --%>
			<button class="btn btn-info">SEARCH</button>
			</form>
		</div>

	<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		
		<c:forEach items="${list.pageList.content}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<div>
		<c:if test="${pager.curBlock > 1}">
			<a href="./${board}List?curPage=${pager.startNum-1}">[이전]</a>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./${board}List?curPage=${i}">${i}</a>
		</c:forEach>
		<c:if test="${pager.curBlock < pager.totalBlock}">
			<a href="./${board}List?curPage=${pager.startNum-1}">[다음]</a>
		</c:if>
	
	</div>

</div>

</body>
</html>