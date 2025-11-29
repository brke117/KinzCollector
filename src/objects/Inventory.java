package objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Inventory {

	private ArrayList<Clothing> clothing = new ArrayList<>();
	private ArrayList<Food> food = new ArrayList<>();
	private ArrayList<Item> item = new ArrayList<>();
	private Database db = new Database();
	
	public Inventory() {
		getClothing();
		getFood();
		getItem();
	}

	private void getFood() {
		ResultSet foodRS = db.getFood();
		try {
			while(foodRS.next()) {
				food.add(new Food(foodRS.getInt("food_id"), foodRS.getInt("asset_id"), foodRS.getString("name"), foodRS.getInt("price"), foodRS.getString("type_prim"), foodRS.getString("location"), foodRS.getInt("hunger_boost"), false));
				
				//int food_id, int asset_id, String name, int price, String type_prim, String location, int hunger_boost, boolean owned
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getItem() {
		// TODO Auto-generated method stub
		
	}

	private void getClothing() {
		// TODO Auto-generated method stub
		
	}
	
	
}
