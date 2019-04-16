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
        .sidebar {
            position: fixed;
            top: 0;
            bottom: 0;
            right: auto;
            left: 0;
            width: 180px;
            display: block;
            z-index: 1;
            background-color: #5a6268;
            font-weight: 200;
            background-size: cover;
            background-position: center center;
        }
        .sidebar .sidebar-wrapper {
            position: relative;
            max-height: calc(100vh - 75px);
            min-height: 100%;
            overflow: auto;
            width: 180px;
            z-index: 4;
            padding-bottom: 100px;
        }
        .sidebar .nav {
            margin-top: 20px;
            float: none;
        }
        .sidebar .nav p{
            color:white;
        }

        .sidebar .logo {
            padding: 10px 15px;
            border-bottom: 1px solid rgba(255, 255, 255, 0.2);
        }
        .sidebar .logo .simple-text {
            text-transform: uppercase;
            padding: 5px 0px;
            display: block;
            font-size: 18px;
            color: #FFFFFF;
            text-align: center;
            font-weight: 400;
            line-height: 30px;
        }

        .main-panel {
            width: 100%;
        }
        .navbar-default {
            background-color: rgba(255, 255, 255, 0.96);
            border-bottom: 1px solid rgba(0, 0, 0, 0.1);
        }
        .container-fluid{
            margin-left: 200px;
        }
    </style>
</head>
<body>
<div class="content1">
	<div class="sidebar">
	    <div class="sidebar-wrapper">
	        <div class="logo">
	            <a href="#" class="simple-text">
	                ADMIN
	            </a>
	        </div>
	
	        <ul class="nav">
	        <li>
	                <a href="/">
	                    <p>Trang chủ</p>
	                </a>
	            </li>
	            <li>
	                <a href="userManagement">
	                    <p>Quản lí đăng nhập</p>
	                </a>
	            </li>
	            <li>
	                <a href="groupNews">
	                    <p>Quản lí nhóm tin</p>
	                </a>
	            </li>
	            <li>
	                <a href="newManagement">
	                    <p>Quản lí bản tin</p>
	                </a>
	            </li>
	            
	        </ul>
	    </div>
	</div>
	<div class="main-panel">
	    <nav class="navbar navbar-default navbar-fixed">
	        <div class="container-fluid">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	            </div>
	            <div class="collapse navbar-collapse">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a href="#">
	                            <p>Account</p>
	                        </a>
	                    </li>
	
	                    <li>
	                        <a href="logout">
	                            <p>Log out</p>
	                        </a>
	                    </li>
	                    <li class="separator hidden-lg hidden-md"></li>
	                </ul>
	            </div>
	        </div>
	    </nav>
	
	    <div class="content">
	        <div class="container-fluid">
	<c:choose>
		 <c:when test="${mode=='MODE_USER'}">
			<div class="container text-center"  id="taskDiv">
			<h3>Bảng dữ liệu</h3><hr>
			<div class="table-responsive">
				<table class="table table-striped table-bordered text-left">
					<thead >
						<tr>
							<th style="text-align: center">Tên tài khoản</th>
							<th style="text-align: center">Mật khẩu</th>
							<th style="text-align: center">Thêm</th>
							<th style="text-align: center">Xóa</th>
							<th style="text-align: center">Sửa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="task" items="${users}">
							<tr style="text-align: center">
								<td >${task.name}</td>
								<td>${task.password}</td>
							    <td><a href="update-tasks?id=${task.id}"><span class="glyphicon glyphicon-plus"></span></a></td>
								<td><a href="delete-tasks?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								<td><a href="update-tasks?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
		 </c:when>
		 <c:when test="${mode=='MODE_GROUPNEWS'}">
			<div class="container text-center">
			<h3>Bảng dữ liệu </h3>
				<div class="table-responsive">
				<table class="table table-striped table-bordered text-left">
					<thead >
						<tr>
							<th style="text-align: center">Mã nhóm</th>
							<th style="text-align: center">Tên nhóm</th>
							<th style="text-align: center">Thêm</th>
							<th style="text-align: center">Xóa</th>
							<th style="text-align: center">Sửa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="task" items="${groupNews}">
							<tr style="text-align: center">
								<td >${task.idcategory}</td>
								<td>${task.name}</td>
							    <td><a href="update-tasks?id=${task.idcategory}"><span class="glyphicon glyphicon-plus"></span></a></td>
								<td><a href="delete-tasks?id=${task.idcategory}"><span class="glyphicon glyphicon-trash"></span></a></td>
								<td><a href="update-tasks?id=${task.idcategory}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
		 </c:when>
		  <c:when test="${mode=='MODE_NEWS'}">
			<div class="container text-center">
			<h3>Bảng dữ liệu </h3>
				<div class="table-responsive">
				<table class="table table-striped table-bordered text-left">
					<thead >
						<tr>
							<th style="text-align: center">Mã tin</th>
							<th style="text-align: center">Mã nhóm</th>
							<th style="text-align: center">Tiêu đề</th>
							<th style="text-align: center">Trích dấn</th>
							<th style="text-align: center">Lời dẫn</th>
							<th style="text-align: center">Nội dung</th>
							<th style="text-align: center">Lượt truy cập</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="task" items="${newManagement}">
							<tr style="text-align: center">
								<td >${task.iddetailnews}</td>
								<td>${task.idcategory}</td>
								<td>${task.title}</td>
								<td>${task.quote}</td>
								<td>${task.content1}</td>
								<td class="contentNews">${task.content}</td>
								
								<td>${task.countseen}</td>
							    <td><a href="update-tasks?id=${task.iddetailnews}"><span class="glyphicon glyphicon-plus"></span></a></td>
								<td><a href="delete-tasks?id=${task.iddetailnews}"><span class="glyphicon glyphicon-trash"></span></a></td>
								<td><a href="update-tasks?id=${task.iddetailnews}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
		 </c:when>
	</c:choose>
	        </div>
	    </div>
	</div>
	
</div>
<script src="static/js/jquery.flexisel.js"></script>
	<!-- //password-script -->
	<!--/ start-smoth-scrolling -->
	<script src="static/js/move-top.js"></script>
	<script src="static/js/easing.js"></script>
	
	
</body>
</html>