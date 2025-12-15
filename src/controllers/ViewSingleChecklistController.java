package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.GridView;

import application.UniversalMethods;
import database.ChecklistSystem;
import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import objects.Account;
import objects.Database;
import objects.Inventory;

public class ViewSingleChecklistController {

	@FXML private Button backButton;
	@FXML private ListView<String> checklistListView;
	private Account account;
	
	@FXML private GridPane clGridPane;
	ObservableList<String> inventoryItems = null;
	
	
	//FROM SINGLE CHECKLIST ADD CODE... IGNORE FOR NOW!!!
	ObservableList<String> selectedItems = null;
	private Inventory inventory;
	Database db = new Database();
	//ObservableList<String> inventoryItems = null;
	
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
	
	
	//THE CHECKBOXENING...
	private List<CheckBox> checkBoxes = new ArrayList<>();
	
	
	public void loadGridPane() {
		int c = 0;
		int r = 0;
		clGridPane.setPadding(new Insets(20));
		
		inventoryItems = inventory.sendToList();
		//System.out.println(inventoryItems.toString());
		//System.out.println("ITEMS IN LIST: " + inventoryItems.size());
		
		for(int i=0; i<inventoryItems.size(); i++) {
			//CheckBox checkBox = new CheckBox(inventoryItems.get(i));
			//checkBox.setWrapText(true);
			checkBoxes.add(new CheckBox(inventoryItems.get(i)));
			
			//System.out.print("COLUMN: " + c + " ROW: " + r + "\n");
			if(c==3) {
				c = 0;
				r++;
			}
			//clGridPane.add(checkBox, c, r);
			clGridPane.add(checkBoxes.get(i), c, r);
			c++;
		}
		getListeners();
		getOwnedStatus();
	}
	
	public void getListeners() {
		for(int i=0; i<checkBoxes.size(); i++) {
			int index = i;
			checkBoxes.get(i).setOnAction(event -> updateItemStatus(checkBoxes.get(index).getText(), checkBoxes.get(index)));
		}
	}
	
	public void getOwnedStatus() {
		for(int i=0; i<checkBoxes.size(); i++) {
			int category = db.determineCategory(checkBoxes.get(i).getText());
			boolean owned = db.getOwned(account.getUserID(), category, inventory.getTypeID(checkBoxes.get(i).getText()));
			
			//System.out.println("IS CHECKBOX OWNED?: " + owned);
			checkBoxes.get(i).setSelected(owned);
		}
	}
	
	public void updateItemStatus(String name, CheckBox checkBox) {
		int category = db.determineCategory(name);
		
		if(category == 1) {
			db.updateClothingOwned(account.getUserID(), inventory.getTypeID(name));
		} else if(category == 2) {
			db.updateFoodOwned(account.getUserID(), inventory.getTypeID(name));
		} else {
			db.updateItemOwned(account.getUserID(), inventory.getTypeID(name));
		}
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
