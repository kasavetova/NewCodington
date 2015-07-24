package com.accenture.newcodington.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;
import com.accenture.newcodington.helper.CodingtonConnectToDB;

public class EventsDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	private static String museumEventsQry = "select e.eventname,e.description,e.duration,e.eventtype,e.schedule,e.ticketprice from event e,place p,museum m "
			+ "where e.placeid=p.placeid "
			+ "and e.placeid='P002' "
			+ "and m.museumid=e.placemap " + "and m.museumid='M001'";

	private static String zooEventsQry = "select e.eventname,e.description,e.duration,e.eventtype,e.schedule,e.ticketprice from event e,place p,zoo z "
			+ "where e.placeid=p.placeid "
			+ "and z.zooid=e.placemap"
			+ " and z.zooid='Z001'";

	private static String parkEventsQry = "select e.eventname,e.description,e.duration,e.eventtype,e.schedule,e.ticketprice from event e,place p,park pr "
			+ "where e.placeid=p.placeid "
			+ "and pr.parkid=e.placemap "
			+ "and pr.parkid='PR01'";

	private static String theaterEventsQry = "select e.eventname,e.description,e.duration,e.eventtype,e.schedule,e.ticketprice from event e,place p,theater t"
			+ " where e.placeid=p.placeid "
			+ " and t.theaterid=e.placemap "
			+ " and t.theaterid='T001'";

	private static String stadiumEventsQry = "select e.eventname,e.description,e.duration,e.eventtype,e.schedule,e.ticketprice from event e,place p,stadium s "
			+ " where e.placeid=p.placeid "
			+ " and s.stadiumid=e.placemap "
			+ " and s.stadiumid='S001';";

	private static String allEventsQry = "select * from event";

	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,
			SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(museumEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();

			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));

			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,
			SQLException {

		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(zooEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,
			SQLException {

		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(parkEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,
			SQLException {

		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(theaterEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,
			SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(stadiumEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public ArrayList<Event> showAllEvents() throws ClassNotFoundException,
			SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(allEventsQry);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();
			event.seteventId(resultSet.getInt("eventid"));
			event.setEventName(resultSet.getString("name"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setPlace(resultSet.getString("places"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSeatsSavailable(resultSet.getInt("seatsavailable"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

}