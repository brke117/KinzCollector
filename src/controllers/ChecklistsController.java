package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.UniversalMethods;
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/singleChecklistAdd.fxml"));
			Parent root = loader.load();
			
			SingleChecklistAddController controller = loader.getController();
			controller.setCurrentAccount(account);
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewChecklistsButtonOnAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/viewSingleChecklist.fxml"));
			Parent root = loader.load();
			
			ViewSingleChecklistController controller = loader.getController();
			controller.setCurrentAccount(account);
			
			Inventory inventory = setChecklistClothing(account.getUserID());
			controller.setMyInventory(inventory);
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Inventory setChecklistClothing(int id) {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		Inventory inventory = new Inventory();
		ResultSet resultAccHasClothing = null;
		ArrayList<Integer> clothingID = new ArrayList<>();
		try {
			Statement statement = connectDB.createStatement();
			resultAccHasClothing = statement.executeQuery("SELECT clothing_clothing_id FROM account_has_clothing WHERE account_user_id = " + id);
			
			while(resultAccHasClothing.next()) {
				clothingID.add(resultAccHasClothing.getInt(1));
			}
			
			for(int i=0; i<clothingID.size(); i++) {
				inventory.getClothingByClothingID(clothingID.get(i));
			}
			//System.out.println(clothingID.toString());
			//System.out.println(inventory.toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	public Inventory setChecklistFood(int id) {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		Inventory inventory = new Inventory();
		ResultSet resultAccHasFood = null;
		ArrayList<Integer> foodID = new ArrayList<>();
		try {
			Statement statement = connectDB.createStatement();
			resultAccHasFood = statement.executeQuery("SELECT food_food_id FROM account_has_food WHERE account_user_id = " + id);
			
			while(resultAccHasFood.next()) {
				foodID.add(resultAccHasFood.getInt(1));
			}
			
			for(int i=0; i<foodID.size(); i++) {
				inventory.getClothingByClothingID(foodID.get(i));
			}
			//System.out.println(foodID.toString());
			//System.out.println(inventory.toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	public void createNewChecklistButtonOnAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("/views/checklistsCreate.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(createNewChecklistButton.getScene().getWindow());
		stage.showAndWait();
	}
	
	public void backButtonOnAction(ActionEvent event) {
		UniversalMethods unimet = new UniversalMethods();
		unimet.switchScene(event, "home.fxml");
	}
	
	public void setCurrentAccount(Account account) {
		this.account = account;
	}
}
