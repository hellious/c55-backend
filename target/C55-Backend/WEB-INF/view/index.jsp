<!DOCTYPE HTML>
<!--
	Solid State by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Aspire Bank</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="/C55-Backend/assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<meta charset="utf-8">
<!-- jQuery (required) & jQuery UI + theme (optional) -->
<link href="/C55-Backend/assets/css/jquery-ui.min.css" rel="stylesheet">

</head>
<body>

	<!-- Page Wrapper -->
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<h1>
				<a href='<c:url value="/"/>'> Aspire Bank></a>
			</h1>
			<nav>
				<a href="#menu">Log In</a>
			</nav>
		</header>
		<!-- Menu-->
		<nav id="menu">
			<div class="inner">
				<h2>Menu</h2>
				<form:form action="login/admin" modelAttribute="login">
					<div class="container">
						<label><b>Account Type</b></label>
						<form:select path="custType">
							<form:option value="Customer" label="Customer" />
							<form:option value="Employee" label="Employee" />
							<form:option value="Manager" label="Manager" />
							<form:option value="Admin" label="Admin" />
						</form:select>
						<label><b>Username</b></label>
						<form:input path="uname" />
						<br /> <label><b>Password</b></label>
						<form:password path="pass" />
						<br /> <input type="submit" value="Login" />
					</div>
				</form:form>
				<a href="#" class="close">Close</a> <span class="psw"><a
					href="#">Forgot password?</a></span>
			</div>
		</nav>
		<a href="#" class="close">Close</a>
	</div>



	<!-- Banner -->
	<section id="banner">
		<div class="inner">
			<div class="logo">
				<span class="icon fa-diamond"></span>
			</div>
			<h2>Aspire Bank</h2>
			<p>We want you to aspire more</p>
		</div>
	</section>

	<!-- Wrapper -->
	<section id="wrapper">

		<!-- One -->
		<section id="one" class="wrapper spotlight style1">
			<div class="inner">
				<a href="#" class="image"><img src="/C55-Backend/assets/images/Banking.jpg"
					alt="" /></a>
				<div class="content">
					<h2 class="major">Banking</h2>
					<p>Banking wherever and whenever you need it. Account access at
						our network of financial centers, online or on the go</p>
				</div>
			</div>
		</section>

		<!-- Two -->
		<section id="two" class="wrapper alt spotlight style2">
			<div class="inner">
				<a href="#" class="image"><img src="/C55-Backend/assets/images/Research.jpg"
					alt="" /></a>
				<div class="content">
					<h2 class="major">Research</h2>
					<p>Through timely, in-depth analysis of companies, industries,
						markets, and world economies, Morgan Stanley has earned its
						reputation as a leader in the field of investment research.</p>
				</div>
			</div>
		</section>

		<!-- Three -->
		<section id="three" class="wrapper spotlight style3">
			<div class="inner">
				<a href="#" class="image"><img src="/C55-Backend/assets/images/Advising.jpg"
					alt="" /></a>
				<div class="content">
					<h2 class="major">Advising</h2>
					<p>We want your money to grow.Our Financial Advisors can help
						you reach that goal. For nearly 80 years, we have worked with
						individuals, families, businesses and institutions to deliver
						services and solutions that help build, preserve and manage
						wealth. We understand our clients aspirations, and we are as
						devoted to their goals as they are</p>
				</div>
			</div>
		</section>
	</section>

	<!-- Footer-->
	<section id="footer">
		<div class="inner">
			<h2 class="major">Get in touch</h2>
			<form method="post" action="#">
				<div class="field">
					<label for="name">Name</label> <input type="text" name="name"
						id="name" />
				</div>
				<div class="field">
					<label for="email">Email</label> <input type="email" name="email"
						id="email" />
				</div>
				<div class="field">
					<label for="message">Message</label>
					<textarea name="message" id="message" rows="4"></textarea>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send Message" /></li>
				</ul>
			</form>
			<ul class="contact">
				<li class="fa-home">Aspire Bank HQ<br /> 1234 E University
					Drive<br /> Tempe, AZ 85281
				</li>
				<li class="fa-phone">(480) 498-2496</li>
				<li class="fa-envelope"><a href="#">information@aspirebank.com</a></li>
				<li class="fa-twitter"><a href="#">twitter.com/aspirebank</a></li>
				<li class="fa-facebook"><a href="#">facebook.com/aspirebank</a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Aspire Bank. All rights reserved.</li>
			</ul>
		</div>
	</section>


	<!-- Scripts -->
	<script src="/C55-Backend/assets/js/skel.min.js"></script>
	<script src="/C55-Backend/assets/js/jquery.min.js"></script>
	<script src="/C55-Backend/assets/js/jquery.scrollex.min.js"></script>
	<script src="/C55-Backend/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="/C55-Backend/assets/js/main.js"></script>

</body>
</html>
