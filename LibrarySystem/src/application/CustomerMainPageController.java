package application;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CustomerMainPageController implements Initializable {

	private UtilityFunctions utils = new UtilityFunctions();

	@FXML
	private JFXButton cartBtn;

	@FXML
	private JFXButton profileBtn;

	@FXML
	private JFXButton orderBtn;

	@FXML
	private JFXButton logoutBtn;

	@FXML
	private JFXToggleButton ISBNToggle;

	@FXML
	private JFXToggleButton titleToggle;

	@FXML
	private JFXToggleButton categoryToggle;

	@FXML
	private JFXToggleButton authorToggle;

	@FXML
	private JFXToggleButton publisherToggle;

	@FXML
	private JFXComboBox<Integer> ISBNCbx;

	@FXML
	private JFXComboBox<String> titleCbx;

	@FXML
	private JFXComboBox<String> categoryCbx;

	@FXML
	private JFXComboBox<String> authorCbx;

	@FXML
	private JFXComboBox<String> publisherCbx;

	@FXML
	private TableView<BooksModel> booksTable;

	@FXML
	private TableColumn<BooksModel, JFXCheckBox> selectCol;

	@FXML
	private TableColumn<BooksModel, Integer> ISBNCol;

	@FXML
	private TableColumn<BooksModel, String> titleCol;

	@FXML
	private TableColumn<BooksModel, String> authorCol;

	@FXML
	private TableColumn<BooksModel, String> publisherCol;

	@FXML
	private TableColumn<BooksModel, String> pubYearCol;

	@FXML
	private TableColumn<BooksModel, Double> priceCol;

	@FXML
	private TableColumn<BooksModel, String> categoryCol;

	@FXML
	private JFXButton searchBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Setting up the columns cell values
		selectCol.setCellValueFactory(new PropertyValueFactory<BooksModel, JFXCheckBox>("selectChbx"));
		ISBNCol.setCellValueFactory(new PropertyValueFactory<BooksModel, Integer>("ISBN"));
		titleCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("title"));
		authorCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("authorName"));
		publisherCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("publisherName"));
		pubYearCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("publicationYear"));
		priceCol.setCellValueFactory(new PropertyValueFactory<BooksModel, Double>("price"));
		categoryCol.setCellValueFactory(new PropertyValueFactory<BooksModel, String>("category"));
		// Filling table with data
		try {
			booksTable.setItems(utils.getBooks());
		} catch (ParseException | SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void createOrder(ActionEvent event) {

	}

	@FXML
	void enableAuthorSearch(ActionEvent event) {
		if (authorToggle.isSelected())
			authorCbx.setDisable(false);
		else
			authorCbx.setDisable(true);
	}

	@FXML
	void enableCategorySearch(ActionEvent event) {
		if (categoryToggle.isSelected())
			categoryCbx.setDisable(false);
		else
			categoryCbx.setDisable(true);
	}

	@FXML
	void enableISBNSearch(ActionEvent event) {
		if (ISBNToggle.isSelected())
			ISBNCbx.setDisable(false);
		else
			ISBNCbx.setDisable(true);
	}

	@FXML
	void enablePublisherSearch(ActionEvent event) {
		if (publisherToggle.isSelected())
			publisherCbx.setDisable(false);
		else
			publisherCbx.setDisable(true);
	}

	@FXML
	void enableTitleSearch(ActionEvent event) {
		if (titleToggle.isSelected())
			titleCbx.setDisable(false);
		else
			titleCbx.setDisable(true);
	}

	@FXML
	void logout(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			// This line gets the previous stage info to change it with the new one
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void search(ActionEvent event) {
		
	}

	@FXML
	void showCart(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CartData.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void showProfile(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/UserProfile.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
