package mainClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseFunctions {
	// Connection related functions
	/**
	 * Function to connect to the database and return the connection
	 * 
	 * @param dbName
	 * @param username
	 * @param password
	 * @return
	 **/
	public Connection createConnection(/*String dbName, String username, String password*/) {
		String jdbcURL = "jdbc:mysql://127.0.0.1:3306/" + /*dbName*/"bookstore" + "?autoReconnect=true&useSSL=false";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, "root", "root");
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
	 * 
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

	// Dealing with Database functions
	public void insertBook(String tblName, BooksModel newBook, Connection connection) {
		String insertBookQuery = "insert into " + tblName + " values (" + newBook.getISBN() + "," + "'"
				+ newBook.getPublisherName() + "'" + "," + newBook.getPublicationYear() + "," + newBook.getPrice() + ","
				+ "'" + newBook.getCategory() + "'" + "," + newBook.getNoCopies() + "," + newBook.getThreshold() + ");";
		try {
			Statement statement = connection.createStatement();
			statement.execute(insertBookQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(String tblName, BooksModel book, int oldISBN, Connection connection) {
		String updateBookQuery = "update " + tblName + "set ISBN = " + book.getISBN() + "," + "publisher = "
				+ book.getPublisherName() + "," + "title = " + book.getTitle() + "," + "publication_year = "
				+ book.getPublicationYear() + "," + "price = " + book.getPrice() + "," + "category = "
				+ book.getCategory() + "," + "no_copies = " + book.getNoCopies() + "," + "threshold_quantity = "
				+ book.getThreshold() + " where ISBN = " + oldISBN + ";";
		try {
			Statement statement = connection.createStatement();
			statement.execute(updateBookQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(String tblName, BooksModel book, Connection connection) {
		String deleteBookQuery = "delete from " + tblName + " where ISBN = " + book.getISBN();
		try {
			Statement statement = connection.createStatement();
			statement.execute(deleteBookQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
