package controllers;

import application.UniversalMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Inventory;
import database.ChecklistSystem;

public class ChecklistsCreateController {

	@FXML Button changeIconButton;
	@FXML Button cancelButton;
	@FXML Button createChecklistButton;
	@FXML TextField checklistNameTextField;
	@FXML Label newChecklistMessage;
	
	Inventory inventory = new Inventory();
	
	public void changeIconButtonOnAction(ActionEvent event) {
		
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	public void createChecklistButtonOnAction(ActionEvent event) {
		ChecklistSystem checkSys = new ChecklistSystem();
		//String name = checklistNameTextField.getText();
		checkSys.createChecklist(checklistNameTextField.getText());
		//checkSys.getChecklist(checklistNameTextField.getText());
		//ArrayList<Object> name = new ArrayList<>();
	}
}
