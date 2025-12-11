package objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

	private ArrayList<Clothing> clothing = new ArrayList<>();
	private ArrayList<Food> food = new ArrayList<>();
	private ArrayList<Item> item = new ArrayList<>();
	private Database db = new Database();
	
	public Inventory() {
		getClothing("");
		getFood("");
		//getItem();
	}

	
	public void getFood(String name) {
		ResultSet foodRS = db.getFood(name);
		try {
			while(foodRS.next()) {
				food.add(new Food(foodRS.getInt("food_id"), foodRS.getInt("asset_id"), foodRS.getString("name"), foodRS.getInt("price"), foodRS.getString("type_prim"), foodRS.getString("location"), foodRS.getInt("hunger_boost"), false));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getFoodByFoodID(int food_id) {
		ResultSet foodRS = db.getFoodByFoodID(food_id);
		try {
			while(foodRS.next()) {
				food.add(new Food(foodRS.getInt("food_id"), foodRS.getInt("asset_id"), foodRS.getString("name"), foodRS.getInt("price"), foodRS.getString("type_prim"), foodRS.getString("location"), foodRS.getInt("hunger_boost"), false));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void getItem() {
		ResultSet itemRS = db.getItem();
		try {
			while(itemRS.next()) {
				item.add(new Item(itemRS.getInt("item_id"), itemRS.getInt("asset_id"), itemRS.getString("name"), itemRS.getInt("item_price"), itemRS.getString("type_prim"), itemRS.getString("dimensions"), itemRS.getString("theme"), itemRS.getString("location"), itemRS.getBoolean("deluxe"), itemRS.getString("first_available"), false));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	*/

	//THESE ARE FOR SINGLECHECKLISTADDCONTROLLER... CAN'T GO INTO CONSTRUCTOR UNLESS I MAKE A VARIABLE???
	public void getClothing(String name) {
		ResultSet clothingRS = db.getClothing(name);
		try {
			while(clothingRS.next()) {
				clothing.add(new Clothing(clothingRS.getInt("clothing_id"), clothingRS.getInt("asset_id"), clothingRS.getString("name"), clothingRS.getInt("price"), clothingRS.getString("type_prim"), clothingRS.getString("theme"), clothingRS.getString("location"), clothingRS.getBoolean("deluxe"), false));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getClothingByClothingID(int clothing_id) {
		ResultSet resultClothing = db.getClothingByClothingID(clothing_id);
		try {
			while(resultClothing.next()) {
				clothing.add(new Clothing(resultClothing.getInt("clothing_id"), resultClothing.getInt("asset_id"), resultClothing.getString("name"), resultClothing.getInt("price"), resultClothing.getString("type_prim"), resultClothing.getString("theme"), resultClothing.getString("location"), resultClothing.getBoolean("deluxe"), false));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<String> sendToList() {
		ObservableList<String> list = FXCollections.observableArrayList();
		for(int i=0; i<clothing.size(); i++) {
			list.add(clothing.get(i).getName());		//grabs the "String name" element from the clothing object at index i.
		}
		//for(int i=0; i<food.size(); i++) {
			//
		//}
		//for(int i=0; i<item.size(); i++) {
			//
		//}
		return list;
	}
	
	// /*
	@Override
	public String toString() {
		String str = "CLOTHING ITEMS: \n" + clothing.toString();
		return str;
	}
	// */
}