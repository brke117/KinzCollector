package controllers;

import application.UniversalMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ViewSingleChecklistController {

	@FXML private Button backButton;
	@FXML private ListView<String> checklistListView;
	ObservableList<String> selectedItems = FXCollections.observableArrayList(); 
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "checklists.fxml");
	}
	
	public void setChecklistItems(ObservableList<String> items) {
		checklistListView.setItems(items);
	}
	
	@FXML
	public void initialize() {
		//
	}
	
	
}
