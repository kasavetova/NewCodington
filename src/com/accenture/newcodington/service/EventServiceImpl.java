package com.accenture.newcodington.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.newcodington.dao.EventsDAO;
import com.accenture.newcodington.dao.VisitorDAO;
import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;


/**
 * SERVICE class for the EVENT objects with DAO layer
 */
public class EventServiceImpl implements EventFacade {
	
	/**
	 * SERVICE CLASS for displaying all events from DAO
	 */
	public ArrayList<Event> getAllMuseumEvents() {

		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showMuseumEvents = new ArrayList<Event>();
		try {
			showMuseumEvents = dao.showMuseumEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showMuseumEvents;
	}


	public ArrayList<Event> getAllZooEvents() {
		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showZooEvents = new ArrayList<Event>();
		try {
			showZooEvents = dao.showZooEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showZooEvents;
	}
	
	public ArrayList<Event> getAllParkEvents() {
		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showParkEvents = new ArrayList<Event>();
		try {
			showParkEvents = dao.showParkEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showParkEvents;
	}
	public ArrayList<Event> getAllTheaterEvents() {
		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showTheaterEvents = new ArrayList<Event>();
		try {
			showTheaterEvents = dao.showTheaterEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showTheaterEvents;
	}
	public ArrayList<Event> getAllStadiumEvents() {
		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showStadiumEvents = new ArrayList<Event>();
		try {
			showStadiumEvents = dao.showStadiumEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showStadiumEvents;
	}
	
	public ArrayList<Event> getAllEvents() {
		EventsDAO dao = new EventsDAO();
		ArrayList<Event> showAllEvents = new ArrayList<Event>();
		try {
			showAllEvents = dao.showAllEvents();
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return showAllEvents;
	}
	
	public boolean checkEventsForVisitor(Visitor visitor, int eventid) {
		VisitorDAO dao = new VisitorDAO();
		boolean isRegistered = false;
		try {
			isRegistered = dao.checkReisteredEvents(visitor, eventid);
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		return isRegistered;
	}
}
