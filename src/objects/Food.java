package objects;

public class Food {

	private int food_id;
	private int asset_id;
	private String name;
	private int price;
	private String type_prim;
	private String location;
	private int hunger_boost;
	private boolean owned;
	
	public Food(int food_id, int asset_id, String name, int price, String type_prim, String location, int hunger_boost, boolean owned) {
		this.food_id = food_id;
		this.asset_id = asset_id;
		this.name = name;
		this.price = price;
		this.type_prim = type_prim;
		this.location = location;
		this.hunger_boost = hunger_boost;
		this.owned = owned;
	}
	
	//getters and setters
	public int getFoodID() {
		return food_id;
	}
	
	public void setFoodID(int food_id) {
		this.food_id = food_id;
	}
	
	public int getAssetID() {
		return asset_id;
	}
	
	public void setAssetID(int asset_id) {
		this.asset_id = asset_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTypePrim() {
		return type_prim;
	}
	
	public void setTypePrim(String type_prim) {
		this.type_prim = type_prim;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getHungerBoost() {
		return hunger_boost;
	}
	
	public void setHungerBoost(int hunger_boost) {
		this.hunger_boost = hunger_boost;
	}
	
	public boolean getOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
}
