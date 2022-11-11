package it.edoardo.springweb.database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import it.edoardo.springweb.model.Order;
import it.edoardo.springweb.model.Product;
import it.edoardo.springweb.model.User;

@Component
public class Database {
	
	private List<User> users;
	private List<Product> products;
	private List<Order> orders;
	
	@PostConstruct
	public void init() {
		this.createUsers();
		this.creteProducts();
		this.createOrders();
	}
	
	private void createUsers() {
		this.users = new ArrayList<User>();
		this.users.add(new User("Mario", "Rossi"));
		this.users.add(new User("Maria", "Rossi"));
		this.users.add(new User("Federico", "Rossi"));
		this.users.add(new User("Federica", "Rossi"));
	}
	
	private void creteProducts() {
		this.products = new ArrayList<Product>();
		this.products.add(new Product("Ammoniaca"));
		this.products.add(new Product("Pane"));
		this.products.add(new Product("Candeggina"));
		this.products.add(new Product("Acqua"));
		this.products.add(new Product("Zucchine"));
		this.products.add(new Product("Pasta"));
	}
	
	private void createOrders() {
		this.orders = new ArrayList<Order>();
		this.orders.add(new Order(this.products.subList(2, 5), this.users.get(0)));
		this.orders.add(new Order(this.products.subList(1, 3), this.users.get(1)));
		this.orders.add(new Order(this.products.subList(3, 5), this.users.get(2)));
		this.orders.add(new Order(this.products.subList(0, 5), this.users.get(3)));
	}
	
	public JSONArray getUsers() {
		final JSONArray json = new JSONArray();
		this.users.stream().forEach((user) -> json.put(user.toJson()));
		return json;
	}
	
	public JSONObject getUser(int userId) {
		this.users.stream().filter((user) -> { 
			return user.getId() == userId; 
		}).findFirst().orElse(null);
		return null;
	}
	
	public JSONObject getProduct(int productId) {
		this.products.stream().filter((product) -> { 
			return product.getId() == productId; 
		}).findFirst().orElse(null);
		return null;
	}
	
	public JSONObject getOrder(int orderId) {
		this.orders.stream().filter((order) -> { 
			return order.getId() == orderId; 
		}).findFirst().orElse(null);
		return null;
	}

	public JSONArray getProducts() {
		final JSONArray json = new JSONArray();
		this.products.stream().forEach((product) -> json.put(product.toJson()));
		return json;		
	}

	public JSONArray getOrders() {
		final JSONArray json = new JSONArray();
		this.orders.stream().forEach((order) -> json.put(order.toJson()));
		return json;
	}

	@PreDestroy
	public void destroy() {
		this.users = null;
		this.products = null;
		this.orders = null;
	}
}
