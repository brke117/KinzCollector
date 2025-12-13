package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import objects.*;

public class ChecklistSystem {
	private ArrayList<Object> checklists = new ArrayList<>();

	public void createChecklist(String checklistName) {

	}
	

	public Inventory setChecklistClothing(int id, Inventory inventory) {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	public Inventory setChecklistFood(int id, Inventory inventory) {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		ResultSet resultAccHasFood = null;
		ArrayList<Integer> foodID = new ArrayList<>();
		try {
			Statement statement = connectDB.createStatement();
			resultAccHasFood = statement.executeQuery("SELECT food_food_id FROM account_has_food WHERE account_user_id = " + id);
			
			while(resultAccHasFood.next()) {
				foodID.add(resultAccHasFood.getInt(1));
			}
			
			for(int i=0; i<foodID.size(); i++) {
				inventory.getFoodByFoodID(foodID.get(i));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
	public Inventory setChecklistItem(int id, Inventory inventory) {
		DatabaseConnection connect = new DatabaseConnection();
		Connection connectDB = connect.getConnection();
		
		ResultSet resultAccHasItem = null;
		ArrayList<Integer> itemID = new ArrayList<>();
		try {
			Statement statement = connectDB.createStatement();
			resultAccHasItem = statement.executeQuery("SELECT item_item_id FROM account_has_item WHERE account_user_id = " + id);
			
			while(resultAccHasItem.next()) {
				itemID.add(resultAccHasItem.getInt(1));
			}
			
			for(int i=0; i<itemID.size(); i++) {
				inventory.getFoodByFoodID(itemID.get(i));
			}
			//System.out.println(itemID.toString());
			System.out.println(inventory.toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	
}
