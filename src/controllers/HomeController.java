package controllers;

import java.io.IOException;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import objects.Account;

public class HomeController {

	@FXML Button checklistsMenuButton;
	@FXML Button viewItemMenuButton;
	@FXML Button settingsMenuButton;
	@FXML Button calculationsMenuButton;
	private Account account;
	
	public void checklistsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		ChecklistsController controller = new ChecklistsController();

		controller.setCurrentAccount(account);
		unimet.switcherooScene(checklistsMenuButton.getScene().getWindow(), "/views/Checklists.fxml", controller);
	}
	
	public void viewItemMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "ViewItem.fxml");
	}
	
	public void settingsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		SettingsController controller = new SettingsController();
		
		controller.setCurrentAccount(account);
		unimet.switchScene(event, "Settings.fxml");
	}
	
	public void calculationsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		CalculationsController controller = new CalculationsController();
		
		controller.setCurrentAccount(account);
		unimet.switcherooScene(calculationsMenuButton.getScene().getWindow(), "/views/ComingSoon.fxml", controller);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}
