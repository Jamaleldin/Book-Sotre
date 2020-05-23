package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartDataController implements Initializable {

	private UtilityFunctions utils = new UtilityFunctions();

	@FXML
	private JFXTextField totalPriceTxt;

	@FXML
	private JFXTextField creditCardNumTxt;

	@FXML
	private JFXDatePicker creditCardExpDate;

	@FXML
	private JFXButton orderBtn;

	@FXML
	private TableView<BooksModel> booksTable;

	@FXML
	private TableColumn<BooksModel, String> titleCol;

	@FXML
	private TableColumn<BooksModel, Double> priceCol;

	@FXML
	private TableColumn<BooksModel, JFXButton> removalCol;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Setting up the columns cell values
		titleCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("title"));
		priceCol.setCellValueFactory(new PropertyValueFactory<BooksModel, Double>("price"));
		removalCol.setCellValueFactory(new PropertyValueFactory<BooksModel, JFXButton>("removeBtn"));
		// Filling table with data
		booksTable.setItems(utils.getCartBooks());
	}

	@FXML
	void makeOrder(ActionEvent event) {

	}

}
