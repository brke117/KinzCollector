package controllers;

import java.io.IOException;
import java.sql.SQLException;

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
import objects.Account;
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
	private Account account;
	
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
	
	public void addToChecklistButtonOnAction(ActionEvent event) throws SQLException {
		selectedItems.addAll(addItemListView.getSelectionModel().getSelectedItems());
		
		//put selectedItems values into inventory
		for(int i=0; i<selectedItems.size(); i++) {
			if(db.determineCategory(selectedItems.get(i)) == 1) {
				inventory.getClothing(selectedItems.get(i));
				db.addAccountHasClothing(account.getUserID(), selectedItems.get(i));
			} else if(db.determineCategory(selectedItems.get(i)) == 2) {
				inventory.getFood(selectedItems.get(i));
				db.addAccountHasFood(account.getUserID(), selectedItems.get(i));
			} else if(db.determineCategory(selectedItems.get(i)) == 3){
				//inventory.getItem(selectedItems.get(i));
				//db.addAccountHasItem(account.getUserID(), selectedItems.get(i));
			} else {
				System.out.println("This SHOULD NOT BE HAPPENING!");
			}
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ViewSingleChecklist.fxml"));
			Parent root = loader.load();
			
			ViewSingleChecklistController controller = loader.getController();
			controller.setCurrentAccount(account);
			controller.setInventory(inventory);	//remove this longterm
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}