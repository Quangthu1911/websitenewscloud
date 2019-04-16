<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<html lang="zxx">

<head>
	<title>HTTNEWS</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<meta name="keywords" content="BAOMOI,HTTNEWS" />

	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<link href="static/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link rel="static/stylesheet" href="css/jquery.desoslide.css">
	<link href="static/css/style.css" rel='stylesheet' type='text/css' />
	<link href="static/css/fontawesome-all.css" rel="stylesheet">
</head>

<body>
	<!--Header-->

	<header>
		<div class="top-bar_sub_w3layouts container-fluid">
			<div class="row">
				<div class="col-md-4 logo text-left">
					<a class="navbar-brand" href="index.html">
						<i class="fab fa-linode"></i> HTTNews</a>
				</div>
				<div class="col-md-4 top-forms text-center mt-lg-3 mt-md-1 mt-0">
					<span>Welcome back!</span>
					<span class="mx-lg-4 mx-md-2  mx-1">
						<a href="login">
							<i class="fas fa-lock"></i>Đăng nhập</a>
					</span>
					<span>
						<a href="register.html">
							<i class="far fa-user"></i> Đăng kí</a>
					</span>
				</div>
				<div class="col-md-4 log-icons text-right">

					<ul class="social_list1 mt-3">

						<li>
							<a href="#" class="facebook1 mx-2" >
								<i class="fab fa-facebook-f"></i>

							</a>
						</li>
						<li>
							<a href="#" class="twitter2">
								<i class="fab fa-twitter"></i>

							</a>
						</li>
						<li>
							<a href="#" class="dribble3 mx-2">
								<i class="fab fa-dribbble"></i>
							</a>
						</li>
						<li>
							<a href="#" class="pin">
								<i class="fab fa-pinterest-p"></i>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

			<div class="header_top" id="home">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<button class="navbar-toggler navbar-toggler-right mx-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
				   </button>


					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
						<c:forEach var="ct" items="${ctg }">
							<li class="nav-item ">
							
								<a class="nav-link" href="1?id=${ct.idcategory }">${ct.name }</a>
									<!-- <span class="sr-only">(current)</span> -->
								</a>
							</li>
							</c:forEach>
						</ul>
							<form action="#" method="post" class="form-inline my-2 my-lg-0 header-search">
								<input class="form-control mr-sm-2" type="search" placeholder="Search here..." name="Search" required="">
								<button class="btn btn1 my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
							</form>
					</div>
				</nav>
			</div>
	</header>
	<section>
		<div class="modal fade" id="exampleModal"   aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="embed-responsive embed-responsive-21by9">
							<iframe src="https://player.vimeo.com/video/145787219"></iframe>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--/main-->
	<section class="main-content-w3layouts-agileits">
		<div class="container">
			<div class=""container style="background: #ffff; margin-top: 30px; margin-bottom: 30px;">
   <h3><span class="label label-default active" style="border:solid 1px black;background:black;color:white">${namecategory}</span></h3>
   <h6 style="color: #D2D2D2; margin: 20px 0 20px 0;">Ngày ${readdetailnews.create_time}</h6>
   <center>
     <h3>${readdetailnews.title}</h3>
   </center>
   <h4 style="font-weight: bold; margin: 20px 0 20px 0;"></h4>
   <p>
   		${readdetailnews.content}
  </p>
  <div class="thumbnail"">
    <a href="#">
      <img style="height:400px;width:800px; margin-left: 200px;" class="img-fluid" src="getPhoto/<c:out value='${readdetailnews.iddetailnews}'/>">
    </a>
  </div>

</div>
		</div>
	</section>
	<section>
	<div class="blog-girds-sec container">
	<h5>Bạn có thể quan tâm</h5><br>
						<div class="row">
						<c:forEach var="task" items="${listTemp}">
							<div class="col-md-3 blog-grid-top">
								<div class="b-grid-top">
									<div class="blog_info_left_grid">
										<a href="readDetail1?id1=${task.iddetailnews}">
											<img style="height:270px;width:350px;" class="img-fluid" src="getPhoto/<c:out value='${task.iddetailnews}'/>">
										</a>
									</div>
									<h3>
										<a href="readDetail1?id1=${task.iddetailnews}">${task.title} </a>
									</h3>
									<p>${task.content1}.</p>
								</div>
								
							</div>
							</c:forEach>
							
					</div>
	</section>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-4 footer-grid-agileits-w3ls text-left">
					<h3>About US</h3>
					<p>Nhóm Hiếu Thư Thịnh</p>
					
				</div>
				<div class="col-lg-6  footer-grid-agileits-w3ls text-left">

						<div class="footer-cpy text-center">
				<div class="footer-social">
					<div class="copyrighttop">
						<ul>
							<li class="mx-3">
								<a class="facebook" href="#">
									<i class="fab fa-facebook-f"></i>
									<span>Facebook</span>
								</a>
							</li>
							<li>
								<a class="facebook" href="#">
									<i class="fab fa-twitter"></i>
									<span>Twitter</span>
								</a>
							</li>
							<li class="mx-3">
								<a class="facebook" href="#">
									<i class="fab fa-google-plus-g"></i>
									<span>Google+</span>
								</a>
							</li>
						</ul>

					</div>
				</div>
			</div>
				</div>
				<!-- subscribe -->
				
			</div>
			<!-- footer -->
		

			<!-- //footer -->
		</div>
	</footer>
	<!---->
	<!-- js -->
	<script src="js/jquery-2.2.3.min.js"></script>
	<!-- //js -->
	<!-- desoslide-JavaScript -->
	<script src="js/jquery.desoslide.js"></script>
	<script>
		$('#demo1_thumbs').desoSlide({
			main: {
				container: '#demo1_main_image',
				cssClass: 'img-responsive'
			},
			effect: 'sideFade',
			caption: true
		});
	</script>

	<!-- requried-jsfiles-for owl -->
	<script>
		$(window).load(function () {
			$("#flexiselDemo1").flexisel({
				visibleItems: 3,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: {
					portrait: {
						changePoint: 480,
						visibleItems: 1
					},
					landscape: {
						changePoint: 640,
						visibleItems: 2
					},
					tablet: {
						changePoint: 768,
						visibleItems: 3
					}
				}
			});

		});
	</script>
	<script>
		$(window).load(function () {
			$("#flexiselDemo2").flexisel({
				visibleItems: 3,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
				responsiveBreakpoints: {
					portrait: {
						changePoint: 480,
						visibleItems: 1
					},
					landscape: {
						changePoint: 640,
						visibleItems: 2
					},
					tablet: {
						changePoint: 768,
						visibleItems: 3
					}
				}
			});

		});
	</script>
	<script src="static/js/jquery.flexisel.js"></script>
	<!-- //password-script -->
	<!--/ start-smoth-scrolling -->
	<script src="static/js/move-top.js"></script>
	<script src="static/js/easing.js"></script>
	<script>
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 900);
			});
		});
	</script>
	<!--// end-smoth-scrolling -->

	<script>
		$(document).ready(function () {
			
									var defaults = {
							  			containerID: 'toTop', // fading element id
										containerHoverID: 'toTopHover', // fading element hover id
										scrollSpeed: 1200,
										easingType: 'linear' 
							 		};
									

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<a href="#home" class="scroll" id="toTop" style="display: block;">
		<span id="toTopHover" style="opacity: 1;"> </span>
	</a>

	<!-- //Custom-JavaScript-File-Links -->
	<script src="js/bootstrap.js"></script>


</body>

</html>