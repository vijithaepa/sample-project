<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/digitaleye/jsp/css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="left_column">
			<section id="logo"></section>
			<section id="menu">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Galary</a></li>
					<li><html:link action="mypage.do">My Page</html:link></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</section>
		</div>
		<div id="right_column">
			<section id="merqueu">Merqueu</section>
			<section id="main_display">pics</section>
		</div>
<!-- 		<footer>This is the footer section</footer> -->
	</div>
	<script type="text/javascript" src="/digitaleye/jsp/js/jquery-1.9.1.js"></script>
</body>
</html>