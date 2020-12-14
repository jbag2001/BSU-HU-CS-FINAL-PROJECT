public class Order {
	public int id;
	public String code;
	public int quantity;
	public String timestamp;
	
	public Order(int id, String code, int quantity) {
		this.id = id;
		this.code = code;
		this.quantity = quantity;
	}
	
	public Order(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}
	
	public Order(String code, int quantity, String timestamp) {
		this.code = code;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}
	
	public String toString() {
		return String.format("(%s, %s)", code, quantity);
	}
}