<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.accenture.newcodington.entity.Event"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" type="text/css" href="css/codington.css">
</head>
<body topmargin="2">

<table class="main" align="center">
	<tr>
		<td align="right">Login to <a href="#">Festival Event
		Registration System</a></td>
	</tr>
	<tr>
		<td>
		<table border="2" class="sub1">
			<tr>
				<td align="Center">
				<div id="header">&nbsp;
				<div align="center"><img
					src="/NewCodingtonAdminPortal/images/Banner.PNG"></img></div>
				</div>
				<!-- header end --> <br />
				<table align="center">
					<tr>
						<!--content begin -->
						<td colspan="2" align="center">
						<div id="content"><img
							src="/NewCodingtonAdminPortal/images/info.PNG"></img></div>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table>
					<tr>
						<td class="style1">New Codington
						<ul>
							<li><a href="mainpage.html">Home</a></li>
							<li>History</li>
							<li>Event Information</li>
						</ul>
						</td>
						<td><br />
						</td>
						<td><br />
						</td>
						<td><br />
						</td>
						<td><br />
						</td>
						<td rowspan="3">
						<%
							String placeName = (String) session.getAttribute("PLACENAME");
						%>
						<table>
							<tr>
								<td style="font-weight: bold">Events mapped for Place <b><%=placeName%></b></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td>
								<%
									ArrayList<Event> eventList = new ArrayList<Event>();
									eventList = (ArrayList<Event>) session.getAttribute("EVENTLIST");
								%>
								<table border="2">
									<tr>
										<th>Event Name</th>
										<th>Description</th>
										<th>Duration</th>
										<th>Event Type</th>
										<th>Schedule</th>
										<th>Ticket price</th>
									</tr>
									<%
										for (Event event : eventList) {
									%>
									<tr>
										<td align="center"><%=event.getEventName()%></td>
										<td align="center"><%=event.getDescription()%></td>
										<td align="center"><%=event.getDuration()%></td>
										<td align="center"><%=event.getEventType()%></td>
										<td align="center"><%=event.getSchedule()%></td>
										<td align="center"><%=event.getTicketPrice()%></td>
									</tr>
									<%
										}
									%>
								</table>

								</td>
							</tr>

						</table>
						</td>
					</tr>
					<tr>
						<td class="style2">Explore North Town
						<ul>
							<li><a href="museum.jsp">Museum</a></li>
							<li><a href="theater.jsp">Theater</a></li>
							<li><a href="stadium.jsp">Stadium</a></li>
						</ul>
						</td>
					</tr>
					<tr>
						<td class="style3">Explore South Town
						<ul>
							<li><a href="zoo.jsp">Zoo</a></li>
							<li><a href="park.jsp">Park</a></li>
						</ul>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>