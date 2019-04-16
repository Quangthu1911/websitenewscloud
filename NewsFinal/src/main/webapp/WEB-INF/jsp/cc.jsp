<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-horizontal" method="post" action="save-tasks" enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label col-md-3">title</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="title" value="${task.title}">		
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">image</label>
					<div class="col-md-7">
						<input type="file" class="form-control" name="image1">		
					</div>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="save">
				</div>
			</form>
			<p>hello tất cả các bạn</p>
</body>
</html>