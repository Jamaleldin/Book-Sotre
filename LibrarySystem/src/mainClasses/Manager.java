package mainClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager extends Customer {

	private DatabaseFunctions DBFunctions = new DatabaseFunctions();
	private Connection custConnection = null;
	public Manager() {
	  custConnection = DBFunctions.createConnection("bookstore", "root", "hazem");
	}
	
	@Override
	public boolean checkUser(String username, String password) {
		String selectQuery = "select count(*) from users where user_name = \"" + username +  "\" && password = \"" + password 
				+ "\" && status = " + true + ";";
		int rowsCount = 0; 
		try {
			Statement stat = custConnection.createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);
			
			while (rSet.next()) {
				rowsCount += rSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rowscount = "+ rowsCount);
		return (rowsCount == 1);
	}

	
}



