package controllers;

import org.controlsfx.control.GridView;

import application.UniversalMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.TilePane;
import objects.Database;

public class ViewItemController {

	@FXML private Button backButton;
	@FXML private ListView<String> viewItemListView;
	private ObservableList<String> items = FXCollections.observableArrayList();
	@FXML private GridView<String> viewItemGridView;
	@FXML private TilePane viewItemTilePane;
	Database db = new Database();
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "home.fxml");
	}
	
	@FXML
	public void initialize() {
		//viewItemGridView.setItems(items);
		viewItemListView.setItems(items);
		db.getFullItemList(items);
		
	}
}