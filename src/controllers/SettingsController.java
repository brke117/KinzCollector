package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import objects.Account;

public class SettingsController {

	@FXML Button accountSettingsButton;
	@FXML Button myPageButton;
	@FXML Button backButton;
	private Account account;
	
	public void accountSettingsButtonOnAction(ActionEvent event) {
		
	}
	
	public void myPageButtonOnAction(ActionEvent event) {
		
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Home.fxml");
		
		HomeController controller = new HomeController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Home.fxml", controller);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}