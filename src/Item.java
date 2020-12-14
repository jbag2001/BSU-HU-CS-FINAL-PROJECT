public class Item {
	public int id;
	public String code;
    public String description;
    public double price;
    public int inventory;
    
    public Item(int id, String code, String description, double price, int inventory) {
    	this.id = id;
    	this.code = code;
    	this.description = description;
    	this.price = price;
    	this.inventory = inventory;
    }
    
    public Item(String code, String description, double price, int inventory) {
    	this.code = code;
    	this.description = description;
    	this.price = price;
    	this.inventory = inventory;
    }
    
    public String toString() {
    	return String.format("(%s, %s, %s, %s)", code, description, price, inventory);
    }
}