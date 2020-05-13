package mainClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import application.Book;


public class DatabaseFunctions {
	
	//Connection related functions
	/**
	 * Function to connect to the database and return the connection
	 * @param dbName
	 * @param username
	 * @param password
	 * @return
	 **/
	public Connection createConnection(String dbName, String username, String password) {
		String jdbcURL = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?autoReconnect=true&useSSL=false";
		Connection connection = null;
        try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("ERROR CREATING CONNECTION:");
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * Function to apply the changes made by the executed statements to the databse
	 * then closes the connection
	 * @param connection
	 **/
	public void closeConnection(Connection connection) {
		try {
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			System.out.println("ERROR CLOSING CONNECTION:");
			e.printStackTrace();
		}
    }
	
	
	
	//Dealing with Database functions
	public void insertBook(String tblName, Book newBook) {
		/* Insert the data */
	}
	
	public void updateBook(String tblName, Book book) {
		/* Update the data */
	}
	
	public void deleteBook(String tblName, Book book) {
		/* Delete the data */
	}

}
