<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Báo mới nóng hổi</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
  </style>
</head>
<body>
  <!--Thêm đầu-->

  <div class="container" style="margin-top: 150px;">
    <center><img src="static/images/login1.png" width="100" height="100" style="margin: 0 20 0 0;"></center>
    <form action="loginadmin" method="post">
      <div class="form-group">
        <label >Name:</label>
        <input type="text" class="form-control" name="name" id="name">
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name="password" id="pwd">
      </div>
      <div>${error}</div>
      <button type="submit" class="form-control btn btn-success">Submit</button>
      
    </form>
  </div>
  
  <!--Thêm footer-->
</body>
</html>
