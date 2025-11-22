package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsController {

	@FXML Button accountSettingsButton;
	@FXML Button myPageButton;
	@FXML Button backButton;
	
	public void accountSettingsButtonOnAction(ActionEvent event) {
		
	}
	
	public void myPageButtonOnAction(ActionEvent event) {
		
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "home.fxml");
	}
}