package controllers;

import java.io.IOException;

import application.UniversalMethods;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import objects.Database;
import objects.Inventory;

public class SingleChecklistAddController {

	@FXML private Button backButton;
	@FXML private ListView<String> addItemListView;
	@FXML private Button addToChecklistButton;
	private ObservableList<String> items = FXCollections.observableArrayList();
	private ObservableList<String> selectedItems = FXCollections.observableArrayList();
	Database db = new Database();
	Inventory inventory = new Inventory();
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "checklists.fxml");
	}
	
	@FXML
	public void initialize() {
		addItemListView.setItems(items);
		db.getFullItemList(items);
		addItemListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //hold CTRL to select multi... CHANGE LATER
	}
	
	public void addToChecklistButtonOnAction(ActionEvent event) {
		selectedItems.addAll(addItemListView.getSelectionModel().getSelectedItems());
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/viewSingleChecklist.fxml"));
			Parent root = loader.load();
		
			ViewSingleChecklistController viewSingleCL = loader.getController();
			viewSingleCL.setChecklistItems(FXCollections.observableArrayList(selectedItems));
		
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}