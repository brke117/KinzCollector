package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import objects.Account;

public class MyPageController {

	@FXML Button backButton;
	private Account account;
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Home.fxml");
		
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Settings.fxml", null);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
	
}
