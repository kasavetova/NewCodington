package com.accenture.newcodington.helper;

public class DbQuery {
	// SQL queries for EVENTDAO
	public static String searchEvent = "";
	public static String updateEvent = "";
	public static String viewEvent = "";
	public static String deleteEvent = "";
	// SQL queries for VISITORDAO
	public static String insertData = "INSERT INTO visitor VALUES(?, ?, ?, ?, ?, ?, ?)";
	public static String searchUser = "SELECT * FROM visitor WHERE username = ? AND password = ?";	
	public static String registerVisitorToEvent = "INSERT INTO eventsignup VALUES(?, ?)";
	public static String registeredEvents = "SELECT * FROM event e JOIN eventsignup es ON e.eventid = es.eventid WHERE es.visitorid = ?";
	public static String updateVisitor = "UPDATE visitor SET firstname = ?, lastname = ?, email = ?, phonenumber = ?, address = ? WHERE username = ?";
	public static String changePassword = "UPDATE visitor SET password = ? WHERE username = ?";
	public static String matchWithOldPwd = "SELECT * FROM visitor WHERE username = ? AND password = ?";
	public static String unregisterEvent = "DELETE FROM eventsignup WHERE visitorid = ? AND eventid = ?";	
	public static String getIDByUsername = "SELECT * FROM visitor WHERE username = ?";
}
