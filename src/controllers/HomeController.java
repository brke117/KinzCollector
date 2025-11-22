package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

	@FXML Button checklistsMenuButton;
	@FXML Button viewItemMenuButton;
	@FXML Button settingsMenuButton;
	@FXML Button calculationsMenuButton;
	 
	
	public void checklistsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "checklists.fxml");
	}
	
	public void viewItemMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "viewItem.fxml");
	}
	
	public void settingsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "settings.fxml");
	}
	
	public void calculationsMenuButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "calculations.fxml");
	}
}
