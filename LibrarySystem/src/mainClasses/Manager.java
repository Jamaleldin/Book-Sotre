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
}
