package com.accenture.newcodington.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * HELPER class to handle DATACONNECTIVITY with CODINGTONDB in MYSQL
 */
public class CodingtonConnectToDB {
	
	// New instance of Connection
	private static Connection connection = null;

	// Opening connection with MYSQL database
	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/festivaldatabase", "root", "abcd1234");
		return connection;
	}

	// Closing connection
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
