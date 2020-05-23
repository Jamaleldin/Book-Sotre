package mainClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Customer {

	private DatabaseFunctions DBFunctions;
	private Connection custConnection;
	private String username;
	private String password;
	private boolean status;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String address;
	private List<BooksModel> shoopingCart;

	public Customer() {
		setDBFunctions(new DatabaseFunctions());
		custConnection = null;
		//setCustConnection(getDBFunctions().createConnection("bookstore", "root", "root"));
		shoopingCart = new LinkedList<BooksModel>();
	}

	public Connection getCustConnection() {
		return custConnection;
	}

	public void setCustConnection(Connection custConnection) {
		this.custConnection = custConnection;
	}

	public DatabaseFunctions getDBFunctions() {
		return DBFunctions;
	}

	public void setDBFunctions(DatabaseFunctions dBFunctions) {
		DBFunctions = dBFunctions;
	}

	// setters and getters of private data
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private boolean userExist(String username) {
		Connection conn = DBFunctions.createConnection();
		String selectQuery = "select user_name from users where user_name = \"" + username + "\";";

		try {
			Statement stat = conn.createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);
			while (rSet.next()) {
				DBFunctions.closeConnection(conn);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean custSignUp(String username, String password, String firstname, String lastname, String email,
			String phone, String address) {

		Connection conn = DBFunctions.createConnection();
		if (userExist(username)) {
			System.out.println("cannot insert user exists before");
			return false;
		}

		String insertstat = "insert into users ( user_name , password , status , first_name , last_name , "
				+ "email , phone_number , shipping_address ) values ( \"" + username + "\",\"" + password + "\"," + false + ",\""
				+ firstname + "\",\"" + lastname + "\",\"" + email + "\",\"" + phone + "\",\"" + address + "\");";

		try {
			PreparedStatement stat = conn.prepareStatement(insertstat);
			stat.execute();
			System.out.println("new customer inserted");
			DBFunctions.closeConnection(conn);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void editData(String username, String password, String firstname, String lastname, String email,
			String phone, String address) {

		Connection conn = DBFunctions.createConnection();
		String updateStat = "update users set ";
		String temp = "";
		if (username.trim() != "") {
			temp += "user_name =\"" + username + "\",";
		}
		if (password.trim() != "") {
			temp += "password =\"" + password + "\",";
		}
		if (firstname.trim() != "") {
			temp += "first_name =\"" + firstname + "\",";
		}
		if (lastname.trim() != "") {
			temp += "last_name =\"" + lastname + "\",";
		}
		if (email.trim() != "") {
			temp += "email =\"" + email + "\",";
		}
		if (phone.trim() != "") {
			temp += "phone_number =\"" + phone + "\",";
		}
		if (address.trim() != "") {
			temp += "shipping_address =\"" + address + "\",";
		}

		temp = temp.substring(0, temp.length() - 1) + ";";
		updateStat += temp;
		try {
			PreparedStatement stat = conn.prepareStatement(updateStat);
			stat.executeUpdate();
			DBFunctions.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
    public boolean checkUser(String username, String password) {
		Connection conn =  DBFunctions.createConnection();
		String selectQuery = "select count(*) from users where user_name = \"" + username + "\" && password = \""
				+ password + "\" && status = " + false + ";";
		int rowsCount = 0;
		try {
			Statement stat = conn.createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);

			while (rSet.next()) {
				rowsCount += rSet.getInt(1);
				setUsername(username);
			}
			DBFunctions.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rowscount = " + rowsCount);
		return (rowsCount == 1);
	}

	public List<BooksModel> getSearchedBooks(int bookISBN, String title, String publisher, String pubYear,
			String category) {
		Connection conn = DBFunctions.createConnection();
		String selectQuery = "select * from books";
		String where = " where";
		String temp = "";
		if (bookISBN != 0) {
			temp += " ISBN = " + bookISBN + " &&";
		}
		if (title.trim() != "") {
			temp += " title = \"" + title + "\" &&";
		}
		if (publisher.trim() != "") {
			temp += " publisher = \"" + publisher + "\" &&";
		}
		if (pubYear.trim() != "") {
			temp += " publication_year = \"" + pubYear + "\" &&";
		}
		if (category.trim() != "") {
			temp += " category = \"" + category + "\" &&";
		}
		if (temp.trim() != "") {
			temp = temp.substring(0, temp.length() - 2) + ";";
			selectQuery += (where + temp);
		} else {
			selectQuery += ";";
		}
		List<BooksModel> searchedBooks = new LinkedList<BooksModel>();

		try {
			Statement stat = conn.createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);
			while (rSet.next()) {
				BooksModel bookTemp = new BooksModel();
				bookTemp.setISBN(rSet.getInt(1));
				bookTemp.setTitle(rSet.getString(2));
				bookTemp.setPublisherName(rSet.getString(3));
				bookTemp.setPublicationYear(rSet.getString(4));
				bookTemp.setPrice(rSet.getDouble(5));
				bookTemp.setCategory(rSet.getString(6));
				bookTemp.setNoCopies(rSet.getInt(7));
				bookTemp.setThreshold(rSet.getInt(8));
				searchedBooks.add(bookTemp);
			}
			DBFunctions.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchedBooks;

	}

	private BooksModel getBookFromCart(int bookISBN) {
		for (int i = 0; i < shoopingCart.size(); i++) {
			BooksModel tempBook = shoopingCart.get(i);
			if (tempBook.getISBN() == bookISBN) {
				return tempBook;
			}
		}
		return null;

	}

	public void addToCart(int bookISBN, int quantity) {
		Connection conn = DBFunctions.createConnection();
		String selectQuery = "select * from books where ISBN = \"" + bookISBN + "\";";
		Statement stat;
		BooksModel curBook = new BooksModel();
		try {
			stat = getCustConnection().createStatement();
			ResultSet rSet = stat.executeQuery(selectQuery);

			while (rSet.next()) {
				BooksModel temp = getBookFromCart(bookISBN);
				if (temp == null) {
					curBook.setISBN(bookISBN);
					curBook.setTitle(rSet.getString(2));
					curBook.setPublisherName(rSet.getString(3));
					curBook.setPublicationYear(rSet.getString(4));
					curBook.setPrice(rSet.getDouble(5));
					curBook.setCategory(rSet.getString(6));
					curBook.setNoCopies(rSet.getInt(7));
					curBook.setThreshold(rSet.getInt(8));
					curBook.setCartQuantity(quantity);
					shoopingCart.add(curBook);
				} else {
					temp.setCartQuantity(quantity);
				}
			}
			DBFunctions.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeFromCart(int bookISBN, int quantity) {
		for (int i = 0; i < shoopingCart.size(); i++) {
			BooksModel tempBook = shoopingCart.get(i);
			if (tempBook.getISBN() == bookISBN) {
				if (quantity > 0) {
					tempBook.setCartQuantity(quantity);
				} else if (quantity == 0) {
					shoopingCart.remove(i);
				} else {
					System.out.println("cart items cannot be negative");
				}
				break;
			}
		}
	}

	public void UserLogout() {

		try {
			shoopingCart.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
