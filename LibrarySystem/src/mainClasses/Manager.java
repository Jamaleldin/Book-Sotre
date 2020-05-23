package mainClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.BooksModel;

public class Manager extends Customer {

	public Manager() {
		super();
	}

	@Override
	public boolean checkUser(String username, String password) {
		Connection conn = getDBFunctions().createConnection();
		String selectQuery = "select count(*) from users where user_name = \"" + username + "\" && password = \""
				+ password + "\" && status = " + true + ";";
		int rowsCount = 0;
		try {
			Statement stat = conn.createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);

			while (rSet.next()) {
				rowsCount += rSet.getInt(1);
			}
			getDBFunctions().closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rowsCount == 1);
	}

	public void insertBook(BooksModel newBook) {
		Connection conn = getDBFunctions().createConnection();
		getDBFunctions().insertBook(newBook, conn);
		getDBFunctions().closeConnection(conn);
	}

	public void modifyBook(String tblName, BooksModel book, int oldISBN) {
		Connection conn = getDBFunctions().createConnection();
		getDBFunctions().updateBook(tblName, book, oldISBN, conn);
		getDBFunctions().closeConnection(conn);
	}

	public void deleteBook(String tblName, BooksModel book) {
		Connection conn = getDBFunctions().createConnection();
		getDBFunctions().deleteBook(tblName, book, conn);
		getDBFunctions().closeConnection(conn);
	}

	public void promoteUser(String userName) {
		Connection conn = getDBFunctions().createConnection();
		String query = "update users set status = 1 where user_name = \'" + userName + "\';";
		try {
			Statement stat = conn.createStatement();
			stat.executeQuery(query);
			getDBFunctions().closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void confirmOrder(String userName, int ISBN) {
		Connection conn = getDBFunctions().createConnection();
		String query = "delete from book_orders where user_name = \'" + userName + "\' and ISBN = " + ISBN + ";";
		try {
			Statement stat = conn.createStatement();
			stat.executeQuery(query);
			getDBFunctions().closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
