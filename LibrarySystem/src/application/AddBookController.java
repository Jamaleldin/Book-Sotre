package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddBookController {

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
	private JFXComboBox<?> categoryCbx;

	@FXML
	private JFXTextField priceTxt;

	@FXML
	private JFXButton addBookBtn;

	@FXML
	void addBook(ActionEvent event) {

	}

}
