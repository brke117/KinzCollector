package objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import javafx.collections.ObservableList;

public class Database {
	DatabaseConnection connect = new DatabaseConnection();
	Connection connectDB = connect.getConnection();
	
	public void getFullItemList(ObservableList<String> items) {
		String getAll = "SELECT name FROM clothing UNION SELECT name FROM food UNION SELECT name FROM item ORDER BY name";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet itemResult = statement.executeQuery(getAll);
			
			while(itemResult.next()) {
				items.add(itemResult.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getClothing(String name) {
		String getClothing = "SELECT * FROM clothing WHERE name = '" + name + "'";
		ResultSet resultClothing = null;
		try {
			Statement statement = connectDB.createStatement();
			resultClothing = statement.executeQuery(getClothing);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultClothing;
	}
	
	public ResultSet getClothingByClothingID(int clothing_id) {
		String getClothingByID = "SELECT * FROM clothing WHERE clothing_id = " + clothing_id;
		ResultSet resultClothing = null;
		try {
			Statement statement = connectDB.createStatement();
			resultClothing = statement.executeQuery(getClothingByID);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultClothing;
	}
	
	public ResultSet getFood(String name) {
		String getFood = "SELECT * FROM food WHERE name = '" + name + "'";
		ResultSet resultFood = null;
		try {
			Statement statement = connectDB.createStatement();
			resultFood = statement.executeQuery(getFood);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultFood;
	}
	
	public ResultSet getFoodByFoodID(int food_id) {
		String getFoodByID = "SELECT * FROM food WHERE food_id = '" + food_id;
		ResultSet resultFood = null;
		try {
			Statement statement = connectDB.createStatement();
			resultFood = statement.executeQuery(getFoodByID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultFood;
	}

	//REQUIRES EDITING
	public ResultSet getItem() {
		String getItem = "SELECT * FROM item";
		ResultSet resultItem = null;
		try {
			Statement statement = connectDB.createStatement();
			resultItem = statement.executeQuery(getItem);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultItem;
	}
	
	public int determineCategory(String name) {
		int category = 0;
		ResultSet resultCategory = null;
		try {
			Statement statement = connectDB.createStatement();
			resultCategory = statement.executeQuery("SELECT type_prim FROM clothing WHERE name = '" + name
													+ "' UNION SELECT type_prim FROM food WHERE name = '" + name
													+ "' UNION SELECT type_prim FROM item WHERE name = '" + name + "'");
			while(resultCategory.next()) {
				if(resultCategory.getString(1).equals("Clothing")) {
					category = 1;
				} else if(resultCategory.getString(1).equals("Ingredient") || resultCategory.getString(1).equals("Recipe Food")) {
					category = 2;
				} else {
					category = 3;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public int getUserID(String username, String password) {
		ResultSet resultID = null;
		int id = 0;
		try {
			Statement statement = connectDB.createStatement();
			String getID = "SELECT user_id FROM account WHERE username = '" + username + "' AND password = '" + password + "'";
			resultID = statement.executeQuery(getID);
			while(resultID.next()) {
				id = resultID.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void addAccountHasClothing(int id, String name) {
		ResultSet resultClothingID = null;
		String clothingID = "";
		
		try {
			Statement statement = connectDB.createStatement();
			resultClothingID = statement.executeQuery("SELECT clothing_id FROM clothing WHERE name = '" + name + "'");
			while(resultClothingID.next()) {
				clothingID = resultClothingID.getString(1);
			}
			statement.executeUpdate("INSERT INTO account_has_clothing(account_user_id, clothing_clothing_id) VALUES('" + id + "', '" + clothingID + "')");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAccountHasFood(int id, String name) {
		ResultSet resultFoodID = null;
		String foodID = "";
		
		try {
			Statement statement = connectDB.createStatement();
			resultFoodID = statement.executeQuery("SELECT food_id FROM food WHERE name = '" + name + "'");
			while(resultFoodID.next()) {
				foodID = resultFoodID.getString(1);
			}
			statement.executeUpdate("INSERT INTO account_has_food(account_user_id, food_food_id) VALUES('" + id + "', '" + foodID + "')");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAccountHasItem() {
		
	}
	
	/*
	public Inventory setChecklistClothing(int id) {
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
			System.out.println(clothingID.toString());
			System.out.println(inventory.toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inventory;
	}
	*/
}
