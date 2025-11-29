package objects;

public class Item {

	private int item_id;
	private int asset_id;
	private String name;
	private int item_price;
	private String type_prim;
	private String dimensions;
	private String theme;
	private String location;
	private boolean deluxe;
	private String first_available;
	private boolean owned;
	
	public Item(int item_id, int asset_id, String name, int item_price, String type_prim, String dimensions, String theme, String location, boolean deluxe, String first_available, boolean owned) {
		this.item_id = item_id;
		this.asset_id = asset_id;
		this.name = name;
		this.item_price = item_price;
		this.type_prim = type_prim;
		this.dimensions = dimensions;
		this.theme = theme;
		this.location = location;
		this.deluxe = deluxe;
		this.first_available = first_available;
		this.owned = owned;
	}
	
	public int getItemID() {
		return item_id;
	}
	
	public void setItemID(int item_id) {
		this.item_id = item_id;
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
	
	public int getItemPrice() {
		return item_price;
	}
	
	public void setItemPrice(int item_price) {
		this.item_price = item_price;
	}
	
	public String getTypePrim() {
		return type_prim;
	}
	
	public void setTypePrim(String type_prim) {
		this.type_prim = type_prim;
	}
	
	public String getDimensions() {
		return dimensions;
	}
	
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
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
	
	public String getFirstAvailable() {
		return first_available;
	}
	
	public void setFirstAvailable(String first_available) {
		this.first_available = first_available;
	}
	
	public boolean getOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
}
