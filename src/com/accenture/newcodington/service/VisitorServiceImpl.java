package com.accenture.newcodington.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;

import com.accenture.newcodington.dao.EventsDAO;
import com.accenture.newcodington.dao.VisitorDAO;
import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;

/**
 * SERVICE class for the EVENT objects with DAO layer
 */
public class VisitorServiceImpl implements VisitorFacade {
	// LOGGER VISITORDAO
	private static Logger log = Logger.getLogger(VisitorServiceImpl.class);

	/**
	 * SERVICE CLASS for displaying all events from DAO
	 */
	@Override
	public Boolean createVisitor(Visitor v) {
		VisitorDAO dao = new VisitorDAO();
		Boolean isCreated = false;
		try {
			isCreated = dao.insertData(v);
			return isCreated;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Visitor searchVisitor(String username, String password) {
		VisitorDAO visitorDAO = new VisitorDAO();
		try {
			Visitor visitorReturned = visitorDAO.searchUser(username,
					password);
			return visitorReturned;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}

	//NOT YET DONE
	@Override
	public Object registerVisitorForEvent(Visitor v, int eventID) {
		VisitorDAO visitorDAO = new VisitorDAO();
		EventsDAO eventDAO = new EventsDAO();
		Boolean isCreated = false;
		try {
			visitorDAO.registerVisitorToEvent(v, eventID);
			//eventDAO.updateEventNominations(v, eventID);
			return isCreated;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Visitor updateVisitorDetails(String username) {
		VisitorDAO visitorDAO = new VisitorDAO();
		Visitor visitor = new Visitor();
		visitor.setUserName(username);
		EventsDAO eventDAO = new EventsDAO();
		try {
			visitorDAO.updateVisitor(visitor);
			return visitor;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ArrayList<Event> showRegisteredEvents(Visitor visitor) {
		try {
			VisitorDAO visitorDAO = new VisitorDAO();
			ArrayList<Event> events = new ArrayList<Event>();
			events = visitorDAO.registeredEvents(visitor);
			return events;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}
	/*@Override
	public Object unregisterVisitor(Visitor v, int eventID) {
		VisitorDAO visitorDAO = new VisitorDAO();
		EventsDAO eventDAO = new EventsDAO();
		Boolean isCreated = false;
		try {
			visitorDAO.registerVisitorToEvent(v, eventID);
			//eventDAO.updateEventNominations(v, eventID);
			return isCreated;
		} catch (SQLException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		} catch (Exception e) {
			log.info("Exception is: " + e.getMessage());
			return null;
		}
	}*/
}
