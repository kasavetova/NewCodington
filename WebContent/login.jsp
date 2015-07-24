<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Festival Event Registration System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div id="header">
		<h2>Festival Event Registration System</h2>
	</div>

	<div id="form-box">

		<h3>Portal Login Page</h3>

		<form method="post" action="login.htm">
			<div class="input-field">
				<label for="username">Visitor Name</label> <input type="text"
					name="username" id="username" placeholder="JohnSmith" />
			</div>

			<div class="input-field">
				<label for="password">Password</label> <input type="password"
					name="password" id="password" />
			</div>

			<div class="input-field">
				<input type="submit" value="Submit" />
			</div>
		</form>
		<div class="registration">
			<p>Not registered.</p><br>
			<a href="visitorRegistration.jsp">Register</a>
		</div>
		

	</div>
</body>
</html>