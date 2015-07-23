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
	
	<%
		Visitor v = (Visitor) request.getAttribute("DATA");
	%>

	<h2 id="sub-heading">Festival Portal Page: Welcome <%= v.getFirstName() %> to your
		portal page.</h2>

	<div id="user-info">
		<p>
			Your personal information is below. To change your information, <a
				href="updatePage.htm">click here</a>
		</p>
		<p>
			Username:
			<%=v.getUserName()%></p>
		<p>
			Visitor ID:
			<%=v.getVisitorId()%></p>
		<p>
			Email:
			<%=v.getEmail()%></p>
		<p>
			Phone No:
			<%=v.getPhoneNumber()%></p>
			
			<% if(v.getAddress() == null) {
				v.setAddress("Not specified");
			} %>
			
		<p>
			Address:
			<%=v.getAddress()%></p>
	</div>

	<hr />

	<div id="registered-events">
		<table>
			<tr>
				<th>Confirmation #</th>
				<th>Event ID</th>
				<th>Event Name</th>
				<th>Description</th>
				<th>Places</th>
				<th>Duration</th>
				<th>Event Type</th>
				<th>Action</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>

	<hr />

	<div id="available-events">
		<table>
			<tr>
				<th>Event ID</th>
				<th>Event Name</th>
				<th>Description</th>
				<th>Places</th>
				<th>Duration</th>
				<th>Event Type</th>
				<th>Available Tickets</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>


</body>
</html>