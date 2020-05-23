package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import mainClasses.DatabaseFunctions;

public class UtilityFunctions {
	private DatabaseFunctions DBFunctions = new DatabaseFunctions();
	/**
	 * Function to validate password entered by user.
	 * 
	 * @param newPass
	 * @param confPass
	 * @return true if password matches its confirmation password and false
	 *         otherwise
	 */
	public boolean isMatchingPassword(String newPass, String confPass) {
		if (newPass.equals(confPass))
			return true;
		return false;
	}

	/**
	 * Function to create a selection check box to be inserted in books table
	 * 
	 * @return
	 */
	public JFXCheckBox getSelectionBox() {
		JFXCheckBox selectionBox = new JFXCheckBox("");
		selectionBox.setUnCheckedColor(Color.GREY);
		selectionBox.setCheckedColor(Color.GREEN);
		selectionBox.setSelected(false);
		return selectionBox;
	}

	/**
	 * Function to create a button to allow the user to remove a book from cart
	 * 
	 * @return
	 */
	public JFXButton getRemoveBtn() {
		JFXButton removeBtn = new JFXButton("x");
		removeBtn.setTextFill(Color.RED);
		removeBtn.setWrapText(true);
		removeBtn.setStyle("-fx-background-color: #ffffff00; " + "-fx-border-readius: 15px;");
		return removeBtn;
	}

	/**
	 * Function to return books information to be inserted in a TableView
	 * 
	 * @return
	 * @throws ParseException
	 * @throws SQLException
	 */
	public ObservableList<BooksModel> getBooks() throws ParseException, SQLException {
		Connection connection = DBFunctions.createConnection();
		String selectQuery = "SELECT * FROM books NATURAL JOIN book_author;";
		Statement stat = connection.createStatement();
		ResultSet rSet = stat.executeQuery(selectQuery);
		ObservableList<BooksModel> books = FXCollections.observableArrayList();
		while (rSet.next()) {
			BooksModel bookTemp = new BooksModel(rSet.getInt(1),rSet.getString(2)
					,rSet.getString(9),rSet.getString(3),rSet.getString(6)
					,rSet.getDouble(5),rSet.getString(4),getSelectionBox());
			books.add(bookTemp);
		}
		DBFunctions.closeConnection(connection);
		return books;
	}

	public ObservableList<BooksModel> getCartBooks() {
		ObservableList<BooksModel> books = FXCollections.observableArrayList();
		books.add(new BooksModel("GOT", 102.0, getRemoveBtn()));
		return books;
	}
}
