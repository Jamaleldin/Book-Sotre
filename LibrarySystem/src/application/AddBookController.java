package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AddBookController implements Initializable {

	@FXML
	private JFXTextField ISBNTxt;

	@FXML
	private JFXTextField titleTxt;

	@FXML
	private JFXTextField authorNameTxt;

	@FXML
	private JFXTextField publisherTxt;

	@FXML
	private JFXDatePicker publicationDate;

	@FXML
	private JFXComboBox<String> categoryCbx;

	@FXML
	private JFXTextField priceTxt;

	@FXML
	private JFXButton addBookBtn;

	@FXML
	void addBook(ActionEvent event) {
		BooksModel book = new BooksModel();
		book.setISBN(Integer.valueOf(ISBNTxt.getText()));
		book.setTitle(titleTxt.getText());
		book.setAuthorName(authorNameTxt.getText());
		book.setPublisherName(publisherTxt.getText());
		book.setCategory(categoryCbx.getSelectionModel().getSelectedItem());
		book.setPrice(Double.valueOf(priceTxt.getText()));
		book.setPublicationYear("" + publicationDate.getValue().getYear());
		book.setNoCopies(50);
		book.setThreshold(10);
		Main.manager.insertBook(book);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String query = "SELECT * FROM books_categories;";
		Connection connection = Main.manager.getDBFunctions().createConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				categoryCbx.getItems().add(result.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Main.manager.getDBFunctions().closeConnection(connection);
	}

}
