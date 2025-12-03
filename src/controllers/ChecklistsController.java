package controllers;

import java.io.IOException;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.*;

public class ChecklistsController {

	@FXML Button viewChecklistsButton;
	@FXML Button createNewChecklistButton;
	@FXML Button backButton;
	
	@FXML Button singleChecklistAdd;
	
	public void singleChecklistAddOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "singleChecklistAdd.fxml");
	}
	
	public void viewChecklistsButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "viewSingleChecklist.fxml");
	}
	
	public void createNewChecklistButtonOnAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("/views/checklistsCreate.fxml")); // /views/checklistsCreate.fxml
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(createNewChecklistButton.getScene().getWindow());
		stage.showAndWait();
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "home.fxml");
	}
}
