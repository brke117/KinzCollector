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
		String getFoodByID = "SELECT * FROM food WHERE food_id = " + food_id;
		ResultSet resultFood = null;
		try {
			Statement statement = connectDB.createStatement();
			resultFood = statement.executeQuery(getFoodByID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultFood;
	}

	public ResultSet getItem(String name) {
		String getItem = "SELECT * FROM item WHERE name = '" + name + "'";
		ResultSet resultItem = null;
		try {
			Statement statement = connectDB.createStatement();
			resultItem = statement.executeQuery(getItem);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultItem;
	}
	
	public ResultSet getItemByItemID(int item_id) {
		String getItemByID = "SELECT * FROM item WHERE item_id = " + item_id;
		ResultSet resultItem = null;
		try {
			Statement statement = connectDB.createStatement();
			resultItem = statement.executeQuery(getItemByID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultItem;
	}
	
	//WORK IN PROGRESS... NOT IMPLEMENTED YET!!!
	public int getAssetIDByName(String name) {
		int category = determineCategory(name);
		
		if(category == 1) {
			String getAssetIDByName = "SELECT asset_id FROM clothing WHERE name = '" + name + "'";
			ResultSet resultItem = null;
			try {
				Statement statement = connectDB.createStatement();
				resultItem = statement.executeQuery(getAssetIDByName);
				
				while(resultItem.next()) {
					return resultItem.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if(category == 2) {
			String getAssetIDByName = "SELECT asset_id FROM food WHERE name = '" + name + "'";
			ResultSet resultItem = null;
			try {
				Statement statement = connectDB.createStatement();
				resultItem = statement.executeQuery(getAssetIDByName);
				
				while(resultItem.next()) {
					return resultItem.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(category == 3) {
			String getAssetIDByName = "SELECT asset_id FROM item WHERE name = '" + name + "'";
			ResultSet resultItem = null;
			try {
				Statement statement = connectDB.createStatement();
				resultItem = statement.executeQuery(getAssetIDByName);
				
				while(resultItem.next()) {
					return resultItem.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
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
				} else if(resultCategory.getString(1).equals("Ingredient") || resultCategory.getString(1).equals("Recipe Food") || resultCategory.getString(1).equals("Pet-Specific Food")) {
					category = 2;
				} else if(resultCategory.getString(1).equals("TYPE")) {
					category = 3;
				} else {
					System.out.println("This should NOT be happening...");
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
	
	public void addAccountHasItem(int id, String name) {
		ResultSet resultItemID = null;
		String itemID = "";
		
		try {
			Statement statement = connectDB.createStatement();
			resultItemID = statement.executeQuery("SELECT item_id FROM item WHERE name = '" + name + "'");
			while(resultItemID.next()) {
				itemID = resultItemID.getString(1);
			}
			statement.executeUpdate("INSERT INTO account_has_item(account_user_id, item_item_id) VALUES('" + id + "', '" + itemID + "')");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getOwned(int user_id, int category, int type_id) {
		ResultSet resultOwned = null;
		boolean owned = false;
		
		if(category == 1) {
			try {
				Statement statement = connectDB.createStatement();
				resultOwned = statement.executeQuery("SELECT clothing_owned FROM account_has_clothing WHERE account_user_id = " + user_id + " AND clothing_clothing_id = " + type_id);
				while(resultOwned.next()) {
					owned = resultOwned.getBoolean(1);
				}
				return owned;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void updateClothingOwned(int user_id, int clothing_id) {
		ResultSet resultOwned = null;
		boolean owned = false;
		
		try {
			Statement statement = connectDB.createStatement();
			resultOwned = statement.executeQuery("SELECT clothing_owned FROM account_has_clothing WHERE account_user_id = " + user_id + " AND clothing_clothing_id = " + clothing_id);
			while(resultOwned.next()) {
				owned = resultOwned.getBoolean(1);
			}
			
			if(owned == false) {
				statement.execute("UPDATE account_has_clothing SET clothing_owned = '1' WHERE account_user_id = " + user_id + " AND clothing_clothing_id = " + clothing_id);
			} else if(owned == true) {
				statement.execute("UPDATE account_has_clothing SET clothing_owned = '0' WHERE account_user_id = " + user_id + " AND clothing_clothing_id = " + clothing_id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFoodOwned(int user_id, int food_id) {
		ResultSet resultOwned = null;
		boolean owned = false;
		
		try {
			Statement statement = connectDB.createStatement();
			resultOwned = statement.executeQuery("SELECT food_owned FROM account_has_food WHERE account_user_id = " + user_id + " AND food_food_id = " + food_id);
			while(resultOwned.next()) {
				owned = resultOwned.getBoolean(1);
			}
			
			if(owned == false) {
				statement.execute("UPDATE account_has_food SET food_owned = '1' WHERE account_user_id = " + user_id + " AND food_food_id = " + food_id);
			} else if(owned == true) {
				statement.execute("UPDATE account_has_food SET food_owned = '0' WHERE account_user_id = " + user_id + " AND food_food_id = " + food_id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateItemOwned(int user_id, int item_id) {
		ResultSet resultOwned = null;
		boolean owned = false;
		
		try {
			Statement statement = connectDB.createStatement();
			resultOwned = statement.executeQuery("SELECT item_owned FROM account_has_item WHERE account_user_id = " + user_id + " AND item_item_id = " + item_id);
			while(resultOwned.next()) {
				owned = resultOwned.getBoolean(1);
			}
			
			if(owned == false) {
				statement.execute("UPDATE account_has_item SET item_owned = '1' WHERE account_user_id = " + user_id + " AND item_item_id = " + item_id);
			} else if(owned == true) {
				statement.execute("UPDATE account_has_item SET item_owned = '0' WHERE account_user_id = " + user_id + " AND item_item_id = " + item_id);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
