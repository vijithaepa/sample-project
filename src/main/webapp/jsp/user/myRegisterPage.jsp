<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="jsp/css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div id="left_column">
			<section id="logo"></section>
			<section id="menu">
			<ul>
				<li><a href="../home.html">Home</a></li>
				<li><a href="#">Galary</a></li>
				<li><a href="myLoginPage.html">My Page</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
			</section>
		</div>
		<div id="right_column">
			<section id="merqueu">Merqueu</section>
			<section id="main_display">
			
			<div id="registry_form">
				<label id="title">User Register Page</label>
				<div><label>Name :</label>
				<input type="text" class="text" /></div>
				<div><label>password :</label>
				<input type="password" class="text" /></div>
				<div><label>Re-type password :</label>
				<input type="password" class="text" /></div>
				<div><label>Age :</label>
				<input type="text" class="text" /></div>
				<div><label>Email :</label>
				<input type="text" class="text" /></div>
				<div><label>Phone No :</label>
				<input type="text" class="text" /></div>
				
				<div><label>Gender :</label>
				<input type="radio" id="gender" value="Male" class="radio">Male</input>
				<input type="radio" id="gender" value="Female" class="radio">Female</input></div>
				
				</br>
				<label>Newsletter subscription :</label>
				<input type="checkbox" id="newsletter" value="0" class="check">Daily</input>		
				<input type="checkbox" id="newsletter" value="1" class="check">Monthly</input>
				<input type="checkbox" id="newsletter" value="2" class="check">Annually</input>
					
				</br></br>		
				<label>Profession :</label>
				<select class="select">
					  <option value="-1">-- None --</option>
					  <option value="0">IT Engineer</option>
					  <option value="1">Doctor</option>
					  <option value="2">Accounts</option>
					  <option value="2">Manager</option>
					  <option value="2">Sales</option>
					  <option value="2">Other</option>
				</select>
				<div class="button"><input type="submit" value="Register"></input>
				<input type="reset" value="Reset"></input></div>
			</div>
			</section>
		</div>
	</div>
	<!-- 	<footer>This is the footer section</footer> -->
	<script type="text/javascript" src="jsp/js/jquery-1.9.1.js"></script>
</body>
</html>