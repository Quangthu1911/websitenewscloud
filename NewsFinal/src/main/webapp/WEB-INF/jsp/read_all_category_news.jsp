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

<div class="container" style="background: #ffff; margin-top: 30px; margin-bottom: 30px;">
 <center style="margin-bottom: 30px;"><h2><span class="label label-default">${name }</span></h2></center>
   <div class="blog-grids row mb-3">
   <c:forEach var="dt" items="${dtn }">
      <div class="row">
        <div class="col-md-5 blog-grid-left">
	        <a href="#">
	        <img class="img-fluid" width=100%" src="getPhoto/<c:out value='${dt.iddetailnews}'/>">
	        </a>
      	</div>
      	<div class="col-md-7 blog-grid-right">
	        <h5><a href="#">${dt.title }</a></h5>
	        <div class="sub-meta">
	          <span>${dt.quote }</span>
	        </div>
      	</div>
      </div>
      <hr  width="80%" size="10000px" align="center" /> 
   </c:forEach>
    </div>
</div>
</body>
</html>