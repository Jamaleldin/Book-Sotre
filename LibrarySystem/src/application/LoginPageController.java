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
import mainClasses.Customer;
import mainClasses.Manager;

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
		String customerName = custNameTxt.getText();
		String customerPassword = custPassTxt.getText();
		Main.customer = new Customer();
		if (Main.customer.checkUser(customerName, customerPassword)) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerMainPage.fxml"));
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
	}

	@FXML
	void enterManager(ActionEvent event) {
		String managerName = mngNameTxt.getText();
		String managerPassword = mngPassTxt.getText();
		Main.manager = new Manager();
		if (Main.manager.checkUser(managerName, managerPassword)) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ManagerMainPage.fxml"));
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
	}

	@FXML
	void enterNewCustomer(ActionEvent event) {
		Main.customer = new Customer();
		if (!newCustConfPassTxt.getText().isEmpty() && !newCustPassTxt.getText().isEmpty()) {
			if (!newCustConfPassTxt.getText().isEmpty()
					&& newCustConfPassTxt.getText().equals(newCustPassTxt.getText())) {
				if (!firstNameTxt.getText().isEmpty() && !lastNameTxt.getText().isEmpty()) {
					if (!emailAddrTxt.getText().isEmpty() && !phoneNumTxt.getText().isEmpty()) {
						if (!shippingAddrTxt.getText().isEmpty()) {
							Main.customer.custSignUp(newCustNameTxt.getText(), newCustPassTxt.getText(),
									firstNameTxt.getText(), lastNameTxt.getText(), emailAddrTxt.getText(),
									phoneNumTxt.getText(), shippingAddrTxt.getText());
							try {
								FXMLLoader fxmlLoader = new FXMLLoader(
										getClass().getResource("/views/CustomerMainPage.fxml"));
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
					}
				}
			}
		}
	}

}