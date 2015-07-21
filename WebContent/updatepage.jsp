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
		<h2>Festival Registration System</h2>
	</div>

	<div id="form-box">
		<h3>Update your Details</h3>
		<form action="" method="post">
			<div class="input-field">
				<label for="firstName">First Name:</label>
				<input type="text" name="firstName" value="">
				<label for="lastName">Last Name:</label><br> <input type="text" name="lastName" value="">
			</div>
			<div class="input-field">
				<label for="username">Username:</label>
				<input type="text" name="username" value="<-- get value from the database-- >" readonly>
			</div>
			<div class="input-field">
				<label for="email">Email:</label>
				<input type="text" name="email" value="">
			</div>
			<div class="input-field">
				<label for="password">Password:</label> 
				<input type="password" name="password" value="">
					<label for="confirmPassword">Confirm Password:</label>
					<input type="password" name="confirmPassword" value="">
			</div>
			<div class="input-field">
				<label for="phoneNumber">Phone Number:</label>
				<input type="text" name="phoneNumber" value="">
			</div>
			<div class="input-field">
				<label for="comments">Address:</label>
				<textarea rows="3" cols="20" name="comments"></textarea>
			</div>
			<div class=input-field>
				<input type="button" value="Cancel"> <input type="button"
					value="Update">
			</div>
		</form>
	</div>

</body>
</html>