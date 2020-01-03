<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login</title>

<c:import url="../template/boot.jsp"></c:import>

</head>
<body>

<c:import url="../template/nav.jsp"></c:import>


<h1>M e m b e r   L o g i n</h1>

<div class="container">
  <h2>L O G I N</h2>
  <form action="./memberLogin" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>

    
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  
  </form>
</div>




</body>
</html>