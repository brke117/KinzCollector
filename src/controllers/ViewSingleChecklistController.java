package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.UniversalMethods;
import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import objects.Account;
import objects.Database;
import objects.Inventory;

public class ViewSingleChecklistController {

	@FXML private Button backButton;
	@FXML private ListView<String> checklistListView;
	private Account account;
	
	
	//FROM SINGLE CHECKLIST ADD CODE... IGNORE FOR NOW!!!
	ObservableList<String> selectedItems = null;
	private Inventory inventory;
	Database db = new Database();
	ObservableList<String> inventoryItems = null;
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
		showItems();
	}
	//FROM SINGLE CHECKLIST ADD CODE... IGNORE FOR NOW!!!
	
	public void setMyInventory(Inventory inventory) {
	    this.inventory = inventory;
	    showItems();
	}
	
	private void showItems() {
		checklistListView.setItems(inventory.sendToList());
	}
	
	
	//ALL GOOD HERE... DONT TOUCH
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Checklists.fxml");
		
		ChecklistsController controller = new ChecklistsController();

		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Checklists.fxml", controller);
	}
}
