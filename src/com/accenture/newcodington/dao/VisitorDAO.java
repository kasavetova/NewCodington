package com.accenture.newcodington.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;
import com.accenture.newcodington.dao.Exceptions;
import com.accenture.newcodington.helper.CodingtonConnectToDB;
import com.accenture.newcodington.helper.DbQuery;

public class VisitorDAO {

	// LOGGER VISITORDAO
	private static Logger log = Logger.getLogger(VisitorDAO.class);

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DbQuery query;

	public VisitorDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		query = (DbQuery) context.getBean("SqlBean");
	}

	public boolean insertData(Visitor visitor) throws ClassNotFoundException,
			SQLException, Exception {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (resultSet.next())
			return false;

		statement = connection.prepareStatement(query.getInsertData());
		statement.setString(1, visitor.getUserName());
		statement.setString(2, visitor.getPassword());
		statement.setString(3, visitor.getFirstName());
		statement.setString(4, visitor.getLastName());
		statement.setString(5, visitor.getEmail());
		statement.setString(6, visitor.getPhoneNumber());
		statement.setString(7, visitor.getAddress());
		int rowsUpdated = statement.executeUpdate();
		CodingtonConnectToDB.closeConnection();

		if (rowsUpdated != 1) {
			log.info("Failed to insert new visitor to Database");
			return false;

		} else {
			log.info("Visitor details inserted into Database");
			return true;
		}

	}

	public Visitor searchUser(String username, String password)
			throws ClassNotFoundException, SQLException {
		connection = CodingtonConnectToDB.createConnection();
		Visitor visitor = new Visitor();
		statement = connection.prepareStatement(query.getSearchUser());
		statement.setString(1, username);
		statement.setString(2, password);
		resultSet = statement.executeQuery();

		boolean foundResult = resultSet.next();

		if (foundResult) {
			log.info("Retreived Visitor details from DATABASE for username :"
					+ username);

			visitor.setUserName(resultSet.getString(2));
			visitor.setVisitorId(resultSet.getInt(1));
			visitor.setFirstName(resultSet.getString(4));
			visitor.setLastName(resultSet.getString(5));
			visitor.setEmail(resultSet.getString(6));
			visitor.setPhoneNumber(resultSet.getString(7));
			visitor.setAddress(resultSet.getString(8));
		}

		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return visitor;
	}

	public boolean registerVisitorToEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {

		connection = CodingtonConnectToDB.createConnection();
		log.info("Mapping event with ID :" + eventid + " to visitor :"
				+ visitor.getUserName() + " in Database");
		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (!resultSet.next())
			return false;
		int id = resultSet.getInt(1);

		statement = connection.prepareStatement(query.getCheckUserRegistered());
		statement.setInt(1, id);
		statement.setInt(2, eventid);
		resultSet = statement.executeQuery();
		if (resultSet.next())
			return false;

		statement = connection.prepareStatement(query
				.getRegisterVisitorToEvent());
		statement.setInt(1, eventid);
		statement.setInt(2, id);
		int status = statement.executeUpdate();
		CodingtonConnectToDB.closeConnection();

		if (status != 1) {
			log.info("Failed to register " + visitor.getUserName()
					+ " to event id: " + eventid);
			return false;
		} else {
			log.info("Registered " + visitor.getUserName() + " to event id: "
					+ eventid);
			return true;
		}
	}

	public ArrayList<Event> registeredEvents(Visitor visitor)
			throws ClassNotFoundException, SQLException {
		connection = CodingtonConnectToDB.createConnection();

		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (!resultSet.next())
			return null;
		int id = resultSet.getInt(1);

		statement = connection.prepareStatement(query.getRegisteredEvents());
		statement.setInt(1, id);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();
		Event event = null;
		while (resultSet.next()) {
			log.info("Displaying all events of visitor from Database :"
					+ eventList);

			event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.seteventId(resultSet.getInt("eventid"));
			event.setName(resultSet.getString("name"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setPlace(resultSet.getString("places"));
			event.setsignupId(resultSet.getInt("signupid"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public Visitor updateVisitor(Visitor visitor)
			throws ClassNotFoundException, SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (resultSet.next())
			return null;

		statement = connection.prepareStatement(query.getUpdateVisitor());
		statement.setString(1, visitor.getFirstName());
		statement.setString(2, visitor.getLastName());
		statement.setString(3, visitor.getEmail());
		statement.setString(4, visitor.getPhoneNumber());
		statement.setString(5, visitor.getAddress());
		statement.setString(6, visitor.getUserName());
		int status = statement.executeUpdate();

		if (status != 1) {
			log.info("Failed to update visitor details in Database for Visitor ID :"
					+ visitor.getVisitorId());
			CodingtonConnectToDB.closeConnection();
			return null;
		} else {
			statement = connection.prepareStatement(query.getGetIDByUsername());
			statement.setString(1, visitor.getUserName());
			resultSet = statement.executeQuery();
			if (!resultSet.next())
				return null;
			visitor.setFirstName(resultSet.getString(4));
			visitor.setLastName(resultSet.getString(5));
			visitor.setEmail(resultSet.getString(6));
			visitor.setPhoneNumber(resultSet.getString(7));
			visitor.setAddress(resultSet.getString(8));

			log.info("Updated visitor details in Database for Visitor ID :"
					+ visitor.getVisitorId());
			CodingtonConnectToDB.closeConnection();
			return visitor;
		}
	}

	public boolean changePassword(Visitor visitor)
			throws ClassNotFoundException, SQLException {

		connection = CodingtonConnectToDB.createConnection();
		if (matchWithOldPwd(visitor, connection)) {
			log.info("Failed to update password for " + visitor.getUserName()
					+ " as new password matches current.");
			return false;
		} else {
			statement = connection.prepareStatement(query.getChangePassword());
			statement.setString(1, visitor.getPassword());
			statement.setString(2, visitor.getUserName());

			int status = statement.executeUpdate();
			CodingtonConnectToDB.closeConnection();

			if (status != 1) {
				log.info("Failed to update visitor password in Database for Visitor ID :"
						+ visitor.getVisitorId());
				return false;

			} else {
				log.info("Updated visitor password in Database for Visitor ID :"
						+ visitor.getVisitorId());
				return true;
			}
		}
	}

	private boolean matchWithOldPwd(Visitor visitor, Connection connection2)
			throws SQLException {
		String currentPWD = "";

		try {
			statement = connection.prepareStatement(query.getMatchWithOldPwd());
			statement.setString(1, visitor.getUserName());
			statement.setString(2, visitor.getPassword());

			resultSet = statement.executeQuery();
			if (resultSet.next())
				currentPWD = resultSet.getString("password");

			if (currentPWD.equals(visitor.getPassword())) {
				log.info("New password must be different from previous password, please choose a different password");
				return true;
			}

		} finally {
			if (statement != null)
				statement.close();
		}
		return false;
	}

	public boolean unregisterEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {

		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (!resultSet.next())
			return false;
		int id = resultSet.getInt(1);

		statement = connection.prepareStatement(query.getCheckUserRegistered());
		statement.setInt(1, id);
		statement.setInt(2, eventid);
		resultSet = statement.executeQuery();
		if (!resultSet.next())
			return false;

		statement = connection.prepareStatement(query.getUnregisterEvent());
		statement.setInt(1, id);
		statement.setInt(2, eventid);
		int status = statement.executeUpdate();
		CodingtonConnectToDB.closeConnection();

		if (status != 1) {
			log.info("failed to unregister user " + visitor.getUserName()
					+ " from event id: " + eventid);
			return false;
		} else {
			log.info("Unregisterd user " + visitor.getUserName()
					+ " from event id: " + eventid);
			return true;
		}
	}

	public boolean checkReisteredEvents(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getGetIDByUsername());
		statement.setString(1, visitor.getUserName());
		resultSet = statement.executeQuery();
		if (!resultSet.next())
			return false;
		int id = resultSet.getInt(1);

		statement = connection.prepareStatement(query.getCheckUserRegistered());
		statement.setInt(1, id);
		statement.setInt(2, eventid);
		resultSet = statement.executeQuery();
		if (resultSet.next())
			return true;
		return false;
	}
}