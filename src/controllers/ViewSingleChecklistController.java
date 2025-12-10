package controllers;

import application.UniversalMethods;
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
	ObservableList<String> selectedItems = null;
	private Inventory inventory;
	Database db = new Database();
	
	//FOR REOPENING FILES
	ObservableList<String> inventoryItems = null;
	private Account account;
	
	/*
	public void setChecklist(int id) {
		db.setChecklistClothing(id);
	}
	*/
	
	public void getChecklist() {
		//setChecklist(account.getUserID());
		setMyInventory(inventory);
	}

	//THIS WAS FOR ITEMS JUST CHOSEN WITH SINGLECHECKLISTADD...
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
		showItems();
	}
	
	public void setMyInventory(Inventory inventory) {
		//setChecklist(account.getUserID());
		//System.out.println(inventory.toString());
		
		//System.out.println("Controller instance: " + this);
	    //System.out.println("Setting inventory: " + inventory);
	    this.inventory = inventory;
	    showItems();
	}
	
	private void showItems() {
		checklistListView.setItems(inventory.sendToList());
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "checklists.fxml");
	}
}
