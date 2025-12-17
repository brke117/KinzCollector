package controllers;

import java.util.ArrayList;
import java.util.List;

import application.UniversalMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import objects.Account;
import objects.Database;

public class ViewItemController {

	@FXML private Button backButton;
	@FXML private ListView<String> viewItemListView;
	private ObservableList<String> items = FXCollections.observableArrayList();
	Database db = new Database();
	private Account account;
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Home.fxml");
		
		HomeController controller = new HomeController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Home.fxml", controller);
	}
	
	@FXML
	public void initialize() {
		viewItemListView.setItems(items);
		db.getFullItemList(items);
	}
	
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}