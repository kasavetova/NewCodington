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
		Statement selStatement = connection.createStatement();
		statement = connection.prepareStatement(query.getInsertQuery());
		resultSet = selStatement.executeQuery(query.getValidateVisitor());
		boolean userFound = false;
		while (resultSet.next()) {
			if (resultSet.getString("username").equals(visitor.getUserName())) {
				userFound = true;
				log.info("Vistor with USERNAME already exists in Database");
				break;
			}
		}
		if (userFound == false) {
			statement.setString(1, visitor.getUserName());
			statement.setString(2, visitor.getPassword());
			statement.setString(3, visitor.getFirstName());
			statement.setString(4, visitor.getLastName());
			statement.setString(5, visitor.getEmail());
			statement.setString(6, visitor.getPhoneNumber());
			statement.setString(7, visitor.getAddress());
			int status = statement.executeUpdate();
			if (status <= 0)
				throw new Exceptions("Records not updated properly",new Exception());
			log.info("Visitor details inserted into Database");
			CodingtonConnectToDB.closeConnection();
			return true;
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return false;
	}
	public Visitor searchUser(String username, String password)
			throws ClassNotFoundException, SQLException {
		connection = CodingtonConnectToDB.createConnection();
		Visitor visitor = new Visitor();
		statement = connection.prepareStatement(query.getSearchQuery());
		statement.setString(1, username);
		statement.setString(2, password);
		resultSet = statement.executeQuery();
		log.info("Retreived Visitor details from DATABASE for username :"+ username);
		while (resultSet.next()) {
			visitor.setUserName(resultSet.getString("username"));
			//visitor.setPassword(resultSet.getString("password"));
			visitor.setVisitorId(resultSet.getInt("visitorid"));
			visitor.setFirstName(resultSet.getString("firstname"));
			visitor.setLastName(resultSet.getString("lastname"));
			visitor.setEmail(resultSet.getString("email"));
			visitor.setPhoneNumber(resultSet.getString("phonenumber"));
			visitor.setAddress(resultSet.getString("address"));
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return visitor;
	}

	public void registerVisitorToEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {

		connection = CodingtonConnectToDB.createConnection();
		log.info("Mapping event with ID :" + eventid + " to visitor :"
				+ visitor.getFirstName() + " in Database");
		statement = connection.prepareStatement(query.getRegisterQuery());
		statement.setInt(1, eventid);
		statement.setInt(2, visitor.getVisitorId());
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new Exceptions("Records not updated properly",new Exception());
		CodingtonConnectToDB.closeConnection();

	}

	public ArrayList<Event> registeredEvents(Visitor visitor)
			throws ClassNotFoundException, SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getStatusQuery());
		statement.setInt(1, visitor.getVisitorId());
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();
		log.info("Displaying all events of visitor from Database :" + eventList);
		while (resultSet.next()) {
			Event event = new Event();
			event.setEventName(resultSet.getString("eventname"));
			event.seteventId(resultSet.getInt("eventId"));
			event.setName(resultSet.getString("name"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventType"));
			event.setPlace(resultSet.getString("places"));
			event.setsignupId(resultSet.getInt("signupid"));
			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

	public int updateVisitor(Visitor visitor) throws ClassNotFoundException,
			SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getUpdateQuery());
		statement.setString(1, visitor.getFirstName());
		statement.setString(2, visitor.getLastName());
		statement.setString(3, visitor.getUserName());
		//statement.setString(4, visitor.getPassword());
		statement.setString(4, visitor.getEmail());
		statement.setString(5, visitor.getPhoneNumber());
		statement.setString(6, visitor.getAddress());
		statement.setInt(7, visitor.getVisitorId());

		int status = statement.executeUpdate();
		log.info("Updating visitor details in Database for Visitor ID :"
				+ visitor.getVisitorId());
		CodingtonConnectToDB.closeConnection();
		return status;
	}
	
	public int changePassword(Visitor visitor) throws ClassNotFoundException, SQLException {
		int status = -1;
		
		try{
			connection = CodingtonConnectToDB.createConnection();
			
		 if(connection!=null){			
			if(visitor!=null){
				
				if(matchWithOldPwd(visitor, connection)){
					status = -10;
				}else{
					statement = connection.prepareStatement(query.getChangePWDQuery());
					statement.setString(1, visitor.getPassword());
					statement.setInt(2, visitor.getVisitorId());
			
					status = statement.executeUpdate();
					
					log.info("Updating visitor details in Database for Visitor ID :" + visitor.getVisitorId());
				}	
			}else{
				log.error("Visitor details are invalid");
			}
		 }else{
			 throw new SQLException("Connection Error, could not establish connection with database");
		 }
		}finally{
			if(statement!=null)
				statement.close();
			if(connection!=null)
				CodingtonConnectToDB.closeConnection();
		}			
		return status;
	}

	private boolean matchWithOldPwd(Visitor visitor, Connection connection2) throws SQLException{
		String currentPWD = "";				
			
		try{
			statement = connection.prepareStatement(query.getVerifyPWDQuery());								
			statement.setInt(1, visitor.getVisitorId());
	
			resultSet = statement.executeQuery();
			if(resultSet.next())
				currentPWD = resultSet.getString("password");
			
			if(currentPWD.equalsIgnoreCase(visitor.getPassword())){
				log.info("New password must be different from previous password, please choose a different password");
				return true;
			}
			
		}finally{
			if(statement!=null)
				statement.close();			
		}			
		return false;	
	}


	public void unregisterEvent(Visitor visitor, int eventid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(query.getDeleteEventQuery());
		statement.setInt(1, eventid);
		statement.setInt(2, visitor.getVisitorId());
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new Exceptions("Records not updated properly",
					new Exception());
		log.info("unregistering event in Database for the visitor :"
				+ visitor.getFirstName());
		CodingtonConnectToDB.closeConnection();
	}

}