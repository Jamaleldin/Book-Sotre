package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class UserProfileController {

	private UtilityFunctions utils = new UtilityFunctions();
	private boolean dataChanged = false;
	private boolean passwordChanged = false;
	@FXML
	private JFXTextField usernameTxt;

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
	private JFXPasswordField oldPassTxt;

	@FXML
	private JFXPasswordField newPassTxt;

	@FXML
	private JFXPasswordField confirmNewPassTxt;

	@FXML
	private JFXButton editDataBtn;

	@FXML
	private JFXButton changePassBtn;

	@FXML
	private JFXButton saveBtn;

	@FXML
	void enableChangePass(ActionEvent event) {
		oldPassTxt.setVisible(true);
		newPassTxt.setEditable(true);
		confirmNewPassTxt.setVisible(true);
		saveBtn.setDisable(false);
		changePassBtn.setDisable(true);
		passwordChanged = true;
	}

	@FXML
	void enableEditData(ActionEvent event) {
		usernameTxt.setEditable(true);
		firstNameTxt.setEditable(true);
		lastNameTxt.setEditable(true);
		emailAddrTxt.setEditable(true);
		phoneNumTxt.setEditable(true);
		shippingAddrTxt.setEditable(true);
		saveBtn.setDisable(false);
		editDataBtn.setDisable(true);
		dataChanged = true;
	}

	@FXML
	void saveData(ActionEvent event) {
		saveBtn.setDisable(true);
		// Personal Data Components
		if (dataChanged) {
			editDataBtn.setDisable(false);
			usernameTxt.setEditable(false);
			firstNameTxt.setEditable(false);
			lastNameTxt.setEditable(false);
			emailAddrTxt.setEditable(false);
			phoneNumTxt.setEditable(false);
			shippingAddrTxt.setEditable(false);
			dataChanged = false;
		}
		// Password components
		if (passwordChanged) {
			changePassBtn.setDisable(false);
			if (utils.isMatchingPassword(newPassTxt.getText(), confirmNewPassTxt.getText())) {
				oldPassTxt.setVisible(false);
				newPassTxt.setEditable(false);
				confirmNewPassTxt.setVisible(false);
			}
			passwordChanged = true;
		}
	}

}
