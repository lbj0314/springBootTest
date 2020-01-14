<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp" />
</head>
<body>
<c:import url="./template/nav.jsp" />

<div class="container">
	
	<form action="./">
		<select name="lang">
			<option>ko</option>
			<option>en</option>
		</select>
		<button>Change</button>		
	</form>
	

	
	<div class="container">
		<img alt="iu1.jpg" src="./images/iu1.jpg">
	</div>
</div>
</body>
</html>