package objects;

public class Clothing {

	private int clothing_id;
	private int asset_id;
	private String name;
	private int price;
	private String type_prim;
	private String theme;
	private String location;
	private boolean deluxe;
	private boolean owned;
	
	public Clothing(int clothing_id, int asset_id, String name, int price, String type_prim, String theme, String location, boolean deluxe, boolean owned) {
		this.clothing_id = clothing_id;
		this.asset_id = asset_id;
		this.name = name;
		this.price = price;
		this.type_prim = type_prim;
		this.theme = theme;
		this.location = location;
		this.deluxe = deluxe;
		this.owned = owned;
	}
	
	public int getClothingID() {
		return clothing_id;
	}
	
	public void setClothingID(int clothing_id) {
		this.clothing_id = clothing_id;
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
	
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean getDeluxe() {
		return deluxe;
	}
	
	public void setDeluxe(boolean deluxe) {
		this.deluxe = deluxe;
	}
	
	public boolean getOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
}
