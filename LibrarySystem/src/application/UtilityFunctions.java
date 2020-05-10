package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;


public class UtilityFunctions {

		/**
		 * Function to validate password entered by user.
		 * @param newPass
		 * @param confPass
		 * @return true if password matches its confirmation password and false otherwise
		 */
		public boolean isMatchingPassword(String newPass,String confPass) {
			if (newPass.equals(confPass))
				return true;
			return false;
		}
		
		/**
		 * Function to create a selection check box to be inserted in books table
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
		 * @return
		 */
		public JFXButton getRemoveBtn() {
			JFXButton removeBtn = new JFXButton("x");
			removeBtn.setTextFill(Color.RED);
			removeBtn.setWrapText(true);
			removeBtn.setStyle("-fx-background-color: #ffffff00; "
								+ "-fx-border-readius: 15px;");
			return removeBtn;
		}
		
		/**
		 * Function to return books information to be inserted in a TableView
		 * @return
		 * @throws ParseException
		 */
		public ObservableList<Book> getBooks() throws ParseException {
	    	ObservableList<Book> books = FXCollections.observableArrayList();
	    	String myDate = "2014-10-29";
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date = sdf.parse(myDate);
			books.add(new Book(1, "GOT", "George R.R. Martin", "HBO", "Fiction", 102.0, date, getSelectionBox()));
	    	return books;
	    }
		
		public ObservableList<Book> getCartBooks() {
			ObservableList<Book> books = FXCollections.observableArrayList();
			books.add(new Book("GOT", 102.0, getRemoveBtn()));
	    	return books;
		}
}
