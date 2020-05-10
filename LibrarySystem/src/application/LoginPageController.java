package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private JFXTextField mngNameTxt;

    @FXML
    private JFXPasswordField mngPassTxt;

    @FXML
    private JFXTextField newCustNameTxt;

    @FXML
    private JFXPasswordField newCustPassTxt;

    @FXML
    private JFXPasswordField newCustConfPassTxt;

    @FXML
    private JFXTextField custNameTxt;

    @FXML
    private JFXPasswordField custPassTxt;

    @FXML
    private JFXButton mngLoginBtn;

    @FXML
    private JFXButton custLoginBtn;

    @FXML
    private JFXButton custSignupBtn;
    
    @FXML
    private JFXTextField firstNameTxt;

    @FXML
    private JFXTextField lastNameTxt;

    @FXML
    private JFXTextField emailAddrTxt;

    @FXML
    private JFXTextField phoneNumTxt;

    @FXML
    private JFXTextField shippingAddrTxt;

    @FXML
    void enterCustomer(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerMainPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			//This line gets the previous stage info to change it with the new one
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void enterManager(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ManagerMainPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			//This line gets the previous stage info to change it with the new one
			Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root1));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}