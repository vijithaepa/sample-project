<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<html:html>
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
					<li><html:link action="homePage.do">Home</html:link></li>
					<li><a href="#">Galary</a></li>
					<li><a href="#">My Page</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</section>
		</div>
		<div id="right_column">
			<section id="merqueu">Merqueu</section>
			<section id="main_display">
				<div id="login_form">
					<html:form action="/user/login.do" method="post">
						<label id="title">User Login</label>
						<div id="error">
							<html:errors property="errors.login" />
						</div>
						<label>User Name :</label>
						<html:text name="userForm" property="user.username" styleClass="text"/>
						<label>Password :</label>
						<html:password name="userForm" property="user.password" styleClass="text" />
						<div id="buttons">
							<html:submit styleClass="button">Login</html:submit>
							<html:reset styleClass="button">Reset</html:reset>
						</div>
						<a href="#">forgotten password ?</a>
						<a href="myRegisterPage.html">new user ?</a>
					</html:form>
				</div>
			</section>
		</div>
	</div>
	<!-- 	<footer>This is the footer section</footer> -->
	<script type="text/javascript" src="/digitaleye/jsp/js/jquery-1.9.1.js"></script>
</body>
</html:html>