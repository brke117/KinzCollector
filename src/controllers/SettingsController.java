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
	@FXML Button logOutButton;
	private Account account;
	
	public void accountSettingsButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		AccountSettingsController controller = new AccountSettingsController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/ComingSoon.fxml", controller);
	}
	
	public void myPageButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		MyPageController controller = new MyPageController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/ComingSoon.fxml", controller);
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Home.fxml");
		
		HomeController controller = new HomeController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Home.fxml", controller);
	}
	
	public void logOutButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Main.fxml", null);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}