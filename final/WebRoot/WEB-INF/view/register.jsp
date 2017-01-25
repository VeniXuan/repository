<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>Register</title>
<link href="<%=basePath %>res/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=basePath %>res/js/jquery.min.js"></script>
<script src="<%=basePath %>res/myjs/addUser.js"></script>
<script src="<%=basePath %>res/js/jquery.ui.custom.js"></script> 
<script src="<%=basePath %>res/js/bootstrap.min.js"></script> 
<script src="<%=basePath %>res/js/jquery.uniform.js"></script> 
<script src="<%=basePath %>res/js/select2.min.js"></script> 
<script src="<%=basePath %>res/js/jquery.dataTables.min.js"></script> 


<!-- Custom Theme files -->
<!--theme-style-->
<link href="<%=basePath %>res/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sport Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath %>res/css/bootstrap-responsive.min.css" />
<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->

</head>
<body> 
<!--header-->
	<div class="line">
	
	</div>
	<div class="header">
		<div class="logo">
			<a href="index.html"><img src="<%=basePath %>res/images/logo.jpg" width="70%"  alt="NEU HAHAHA" ></a>
		</div>
		<div  class="header-top">
			<div class="header-grid">
				<ul class="header-in">
						<li ><a href="/final/manager/account.html">My Account   </a> </li>
						<li>	
							<select class="in-drop">
							  <option value="Dollars" class="in-of">Dollars</option>
							  <option value="Euro" class="in-of">Euro</option>
							  <option value="RMB" class="in-of">RMB</option>
							</select>
						</li>					
					</ul>
					<div class="search-box">
					    <div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search"> </span>
							</form>
						</div>
				    </div>
					<!-- search-scripts -->
					<script src="<%=basePath %>res/myjs/classie.js"></script>
					<script src="<%=basePath %>res/myjs/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					<div class="online">
					<a href="single.html">SHOP ONLINE</a>
					</div>
					<div class="clearfix"> </div>
			</div>
			<div class="header-bottom">
				<div class="h_menu4"><!-- start h_menu4 -->
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="product.html">Home Page</a></li>
					<li><a href="product.html">Digital</a></li>					
					<li><a href="product.html">Furniture & Daily use</a></li>
					<li><a href="product.html">Shoes & clothes</a></li>
					<li><a href="product.html">Others</a></li>
					<li><a href="product.html">More <i> </i></a>
						<ul>
							<li><a href="contact.html">Contact</a></li>
							<li><a href="/final/manager/account.html">Account</a></li>
<li><a href="register.html">Register</a></li>						</ul>
					</li>
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div><!-- end h_menu4 -->
					<ul class="header-bottom-in">
						<li ><select class="drop">
							  <option value="Dollars" class="in-of">Get Active</option>
							  <option value="Euro" class="in-of">Get Active1</option>
							  <option value="Yen" class="in-of">Get Active2</option>
							</select> </li>
						<li ><select class="drop">
							  <option value="Dollars" class="in-of">Community</option>
							  <option value="Euro" class="in-of">Community1</option>
							  <option value="Yen" class="in-of">Community2</option>
							</select></li>			
					</ul>
			<div class="clearfix"> </div>
		</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!---->	
<div class="container">
		<div class="register">
		<h2>REGISTER</h2>		
		<div class=" register-top">
			
				<div> 	
				<span>Name<input type="text" id="NA"> </span>
				
			</div>
			<div> 	
				<span>Gender</span>
				<input type="text" id="GD"> 
			</div>
			<div> 	
				<span>Email</span>
				<input type="text" id="EM"> 
			</div>
			<div> 
				<span >Password</span>
				<input type="password" id="PW">
			</div>	
			<div> 
				<span >Mobile</span>
				<input type="text" id="MB">
			</div>		
	<!--  	<input type="submit"  id="reg" value="Submit">  -->
	 	<div >	<a  id="reg" href="#">Confirm</a> 	</div>	
			
		</div>		
	</div>
	</div>

	<!---->
<!--footer-->
	<div class="footer">
		<div class="col-md-3 footer-left">
			<h4>Sports</h4>
			<div class="run-top">
				<ul class="run-grid">
					<li><a href="#">Home Page</a></li>
					<li><a href="#">Digital</a></li>
					<li><a href="#">Furniture & Daily Use</a></li>
					<li><a href="#">Shoes & Clothes</a></li>
					<li><a href="#">Others</a></li>
				
				</ul>
				<ul class="run-grid">
					<li><a href="#">STYLE</a></li>
					<li><a href="#">SPECIAL</a></li>
					<li><a href="#">BRAND EVENTS</a></li>
				</ul>
			<div class="clearfix"> </div>
			</div>
		</div>
		<div class="col-md-3 footer-left left-footer">
			<h4>Latest</h4>
			<div class="run-top top-run">
				<ul class="run-grid">
					<li><a href="#">News & Events</a></li>
					<li><a href="#">Community</a></li>
					<li><a href="#">Videos</a></li>
					<li><a href="#">Shopping</a></li>
					<li><a href="#">Sponsorships</a></li>
					<li><a href="#">More Categories</a></li>
				</ul>
				<ul class="run-grid">
					<li><a href="#">Clubs and Training Service</a></li>
					<li><a href="#">Event Map</a></li>
					<li><a href="#">Challenge the world</a></li>
				</ul>
			<div class="clearfix"> </div>
			</div>
		</div>
		<div class="col-md-2 footer-left left-footer">
			<h4>Your Account</h4>
				<ul class="run-grid-in">
					<li><a href="/final/manager/account.html">Login</a></li>
					<li><a href="#">My Account</a></li>
					<li><a href="#">My Events</a></li>
				</ul>
		</div>
		<div class="col-md-4 footer-left left-footer">
			<ul class="social-in">
				<li><a href="http://www.google.com"><i> </i></a></li>
				<li><a href="http://www.youtube.com"><i class="youtube"> </i></a></li>
				<li><a href="http://www.facebook.com"><i class="facebook"> </i></a></li>
				<li><a href="http://www.twitter.com"><i class="twitter"> </i></a></li>
			</ul>
			<div class="letter">
				<h5>NEWSLETTER</h5>
				<span>in the next article</span>
				<h6>NRL: five things we learned this weekend</h6>
				<p>In support of suburban games; Warriors rip</p>
				<a href="register.html" class="sign">SIGN UP AND GET MORE</a>
				<p class="footer-class">Copyright &copy; 2015.Company God Chen All rights reserved.</p>
			</div>
			
		</div>
		<div class="clearfix"> </div>
	</div>
</body>
</html>