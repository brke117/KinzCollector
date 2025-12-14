package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.UniversalMethods;
import database.ChecklistSystem;
import database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.*;
import objects.Account;
import objects.Database;
import objects.Inventory;

public class ChecklistsController {

	@FXML Button viewChecklistsButton;
	@FXML Button createNewChecklistButton;
	@FXML Button backButton;
	
	@FXML Button singleChecklistAdd;
	private Account account;
	
	public void singleChecklistAddOnAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SingleChecklistAdd.fxml"));
			
			//SingleChecklistAddController controller = loader.getController();
			SingleChecklistAddController controller = new SingleChecklistAddController();
			controller.setCurrentAccount(account);
			loader.setController(controller);
			
			Parent root = loader.load();
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewChecklistsButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		ViewSingleChecklistController controller = new ViewSingleChecklistController();

		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/ViewSingleChecklist.fxml", controller);
		
		Inventory inventory = new Inventory();
		ChecklistSystem checkSys = new ChecklistSystem();
		checkSys.setChecklistClothing(account.getUserID(), inventory);
		checkSys.setChecklistFood(account.getUserID(), inventory);
		checkSys.setChecklistItem(account.getUserID(), inventory);
		controller.setMyInventory(inventory);
		controller.loadGridPane();
	}
	
	public void createNewChecklistButtonOnAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("/views/ChecklistsCreate.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(createNewChecklistButton.getScene().getWindow());
		stage.showAndWait();
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		//unimet.switchScene(event, "Home.fxml");
		
		HomeController controller = new HomeController();
		controller.setCurrentAccount(account);
		unimet.switcherooScene(backButton.getScene().getWindow(), "/views/Home.fxml", controller);
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}
