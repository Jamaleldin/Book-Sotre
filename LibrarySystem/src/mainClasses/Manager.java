package mainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager extends Customer {

	public Manager() {
		super();
	}

	@Override
	public boolean checkUser(String username, String password) {
		String selectQuery = "select count(*) from users where user_name = \"" + username + "\" && password = \""
				+ password + "\" && status = " + true + ";";
		int rowsCount = 0;
		try {
			Statement stat = getCustConnection().createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);

			while (rSet.next()) {
				rowsCount += rSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rowsCount == 1);
	}

	public void insertBook(String tblName, BooksModel newBook) {
		getDBFunctions().insertBook(tblName, newBook, getCustConnection());
	}

	public void modifyBook(String tblName, BooksModel book, int oldISBN) {
		getDBFunctions().updateBook(tblName, book, oldISBN, getCustConnection());
	}

	public void deleteBook(String tblName, BooksModel book) {
		getDBFunctions().deleteBook(tblName, book, getCustConnection());
	}

	public void promoteUser(String userName) {
		String query = "update users set status = 1 where user_name = \'" + userName + "\';";
		try {
			Statement stat = getCustConnection().createStatement();
			stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void confirmOrder(String userName, int ISBN) {
		String query = "delete from book_orders where user_name = \'" + userName + "\' and ISBN = " + ISBN + ";";
		try {
			Statement stat = getCustConnection().createStatement();
			stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
