<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
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
					<li><a href="myLoginPage.html">My Page</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</section>
		</div>
		<div id="right_column">
			<section id="merqueu">Merqueu</section>
			<section id="main_display">
				<html:form action="/user/register.do" method="post">
				<div id="register_error">
					<html:messages id="errors" />
					<html:errors property="user.username" />
					<html:errors property="user.password" />
				</div>

				<div id="registry_form">
					<label id="title">User Register Page</label>
					<div>
						<label>Name :</label> 
						<html:text property="user.fullName" name="userForm" styleClass="text"></html:text>
					</div>
					<div>
						<label>User Name :</label>
						<html:text property="user.username" name="userForm" styleClass="text"></html:text>
					</div>
					<div>
						<label>password :</label>
						<html:password property="user.password" name="userForm" styleClass="text"></html:password>
					</div>
					<div>
						<label>Re-type password :</label> 
						<html:password property="user.rePassword" name="userForm" styleClass="text"></html:password>
					</div>
					<div>
						<label>Age :</label> 
						<html:text property="user.age" name="userForm" styleClass="text"></html:text>
					</div>
					<div>
						<label>Email :</label> 
						<html:text property="user.email" name="userForm" styleClass="text"></html:text>
					</div>
					<div>
						<label>Phone No :</label> 
						<html:text property="user.phoneNo" name="userForm" styleClass="text"></html:text>
					</div>

					<div>
						<label>Gender :</label>
						<html:radio property="user.gender" name="userForm" value="Male" styleClass="radio"></html:radio>
						<html:radio property="user.gender" name="userForm" value="Female" styleClass="radio"></html:radio>
					</div>

					<label class="lbl">Newsletter subscription :</label>
					<html:checkbox property="user.newsletterFrequency" name="userForm" value="0" styleClass="check">Daily</html:checkbox>
					<html:checkbox property="user.newsletterFrequency" name="userForm" value="1" styleClass="check">Monthly</html:checkbox>
					<html:checkbox property="user.newsletterFrequency" name="userForm" value="2" styleClass="check">Annually</html:checkbox>

					<label class="lbl">Profession :</label> 
					<html:select property="user.profession" name="userForm" styleClass="select">
						<html:option value="-1">-- None --</html:option>
						<html:option value="0">IT Engineer</html:option>
						<html:option value="1">Doctor</html:option>
						<html:option value="2">Accounts</html:option>
						<html:option value="3">Manager</html:option>
						<html:option value="4">Sales</html:option>
						<html:option value="5">Other</html:option>
					</html:select>
					<div class="button">
						<html:submit>Register</html:submit>
						<html:reset>Reset</html:reset>
					</div>
				</div>
					</html:form>
			</section>
		</div>
	</div>
	<!-- 	<footer>This is the footer section</footer> -->
	<script type="text/javascript" src="/digitaleye/jsp/js/jquery-1.9.1.js"></script>
</body>
</html:html>