<%@page import="com.accenture.newcodington.entity.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Festival Portal Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="header">
		<h1>Festival Event Registration System</h1>
	</div>

	<div id="nav">
		<ul>
			<li><a href="">Logout</a></li>
			<li><a href="">Event Catalog</a></li>
			<li><a href="">About</a></li>
		</ul>
	</div>

	<h2 id="sub-heading">Festival Portal Page: Welcome @user to your
		portal page.</h2>
		
	<% Visitor v = (Visitor) request.getAttribute("DATA"); %>

	<div id="user-info">
		<p>
			Your personal information is below. To change your information, <a
				href="updatepage.jsp">click here</a>
		</p>
		<p>Username: <%= v.getUserName() %></p>
		<p>Visitor ID: <%= v.getVisitorId() %></p>
		<p>Email: <%= v.getEmail() %></p>
		<p>Phone No: <%= v.getPhoneNumber() %></p>
		<p>Address: <%= v.getAddress() %></p>
	</div>


</body>
</html>