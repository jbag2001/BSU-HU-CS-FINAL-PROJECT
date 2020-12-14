import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Project {
	public static Item CreateItem(String code, String description, double price, int inventory) throws SQLException {
		Item item = new Item(code, description, price, inventory);
		
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("insert into items (item_code, description, price, inventory) values ('%s', '%s', %s, %s);",
				item.code,
				item.description,
				item.price,
				item.inventory);
		sqlStatement.executeUpdate(sql);
		connection.close();

		return item; 
	}
	
	public static void UpdateInventory(String code, int inventory) throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("update items set items.inventory = %s where items.item_code = '%s';", inventory, code);
		sqlStatement.executeUpdate(sql);

		connection.close();
	}

	public static void DeleteItem(String code) throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("delete from items where item_code = '%s';", code);
		sqlStatement.executeUpdate(sql);
		
		connection.close();
	}
	
	public static List<Item> GetAllItems() throws SQLException { 
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = "select * from items";
		ResultSet resultSet = sqlStatement.executeQuery(sql);

		List<Item> items = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item(resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5));
			items.add(item);
		}
		
		resultSet.close();
		connection.close();
		
		return items;
	}
	
	public static List<Item> GetItem(String code) throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("select * from items where item_code = '%s';", code);
		ResultSet resultSet = sqlStatement.executeQuery(sql);

		List<Item> items = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item(resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5));
			items.add(item);
		}
		
		resultSet.close();
		connection.close();
		
		return items;
	}
	
	public static Order CreateOrder(String code, int quantity) throws SQLException {
		Order order = new Order(code, quantity);
		
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("insert into orders (item_code, quantity) values ('%s', %s);",
				order.code, 
				order.quantity);
		sqlStatement.executeUpdate(sql);
		connection.close();

		return order;
	}
	
	public static void DeleteOrder(String code) throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();
		
		String sql = String.format("delete from orders where order_code = '%s';", code);
		sqlStatement.executeUpdate(sql);
		
		connection.close();
	}

	public static List<Order> GetOrder(String code) throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = String.format("select * from orders where item_code = '%s';", code);
		ResultSet resultSet = sqlStatement.executeQuery(sql);

		List<Order> Orders = new ArrayList<Order>();

		while (resultSet.next()) {
			Orders.add(new Order(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			
		}
		resultSet.close();
		connection.close();
		
		return Orders;
	}
	
	public static List<Order> GetAllOrders() throws SQLException {
		Connection connection = MySqlDatabase.getDatabaseConnection();
		Statement sqlStatement = connection.createStatement();

		String sql = "select * from orders;";
		ResultSet resultSet = sqlStatement.executeQuery(sql);

		List<Order> Orders = new ArrayList<Order>();

		while (resultSet.next()) {
			Orders.add(new Order(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			
		}
		resultSet.close();
		connection.close();
		
		return Orders;

	}
	
	public static void _CreateItem(String code, String description, double price, int inventory) {
		try {
			Item item = CreateItem(code, description, price, inventory);
			System.out.println(item.toString());
		} catch (SQLException sqlException) {
			System.out.println("Failed to create item");
			System.out.println(sqlException.getMessage());
		}
	}
	
	public static void _UpdateInventory(String code, int inventory) {
		try {
			UpdateInventory(code, inventory);
			System.out.println();
		} catch (SQLException sqlException) {
			System.out.println("Failed to update inventory of item");
			System.out.println(sqlException.getMessage());
		}
	}

	public static void _DeleteItem(String code) {
		try {
			DeleteItem(code);
			System.out.println("Item deleted");
		} catch (SQLException sqlException) {
			System.out.println("Failed to delete item");
		}
	}
	
	public static void _GetItem(String code) {
		try {
			List<Item> items = GetItem(code);
			for (Item item : items) {
				System.out.println(item.toString());
			}
		} catch (SQLException sqlException) {
			System.out.println("Failed to get item");
			System.out.println(sqlException.getMessage());
		}
	}
	
	public static void _GetAllItems() {
		try {
			List<Item> items = GetAllItems();
			for (Item item : items) {
				System.out.println(item.toString());
			}
		} catch (SQLException sqlException) {
			System.out.println("Failed to get all items");
			System.out.println(sqlException.getMessage());
		}
	}
	
	public static void _CreateOrder(String code, int quantity) {
		try {
			Order order = CreateOrder(code, quantity);
			System.out.println(order.toString());
		} catch (SQLException sqlException) {
			System.out.println("Failed to create order");
			System.out.println(sqlException.getMessage());
		}
	}
	
	public static void _DeleteOrder(String code) {
		try {
			DeleteOrder(code);
			System.out.println("Order deleted");
		} catch (SQLException sqlException) {
			System.out.println("Failed to delete order");
		}
	}

	public static void _GetOrder(String code) {
		try {
			List<Order> orders = GetOrder(code);
			for (Order order : orders) {
				System.out.println(order.toString());
			}
		} catch (SQLException sqlException) {
			System.out.println("Failed to get order");
			System.out.println(sqlException.getMessage());
		}
	}
	
	public static void _GetAllOrders() {
		try {
			List<Order> orders = GetAllOrders();
			for (Order order : orders) {
				System.out.println(order.toString());
			}
		} catch (SQLException sqlException) {
			System.out.println("Failed to get orders");
			System.out.println(sqlException.getMessage());
		}
	}
	
	/**
	 * Main method used in the command line
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException{
		if (args[0].equals("CreateItem")) {
			String itemCode = args[1];
			String itemDescription = args[2];
			double price = Double.parseDouble(args[3]);
			_CreateItem(args[1], args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4]));
		}
		else if(args[0].equals("UpdateInventory")){
			_UpdateInventory(args[1], Integer.parseInt(args[2]));

		}
		else if(args[0].equals("DeleteItem")){
			_DeleteItem(args[1]);
		}
		else if(args[0].equals("GetItems")) {
			String code = args[1];
			if(code.equals("%")){
				_GetAllItems();
			}
			else {
				_GetItem(args[1]);
			}
		}
		else if(args[0].equals("CreateOrder")) {
			_CreateOrder(args[1], Integer.parseInt(args[2]));
		}
		else if(args[0].equals("DeleteOrder")) {
			_DeleteOrder(args[1]);
		}
		else if(args[0].equals("GetOrders")) {
			String code = args[1];
			if(code.equals("%")){
				_GetAllOrders();
			}
			else {
				_GetOrder(args[1]);
			}
		}
		else if(args[0].equals("GetOrderDetails")) {
			String itemCode = args[1];
			if(itemCode.equals("%")) {
				_GetAllOrders();
			}
			else {
				_GetOrder(args[1]);
			}
		}
		else {
			System.out.println("Error: Unknown Command");
		}


	}
}