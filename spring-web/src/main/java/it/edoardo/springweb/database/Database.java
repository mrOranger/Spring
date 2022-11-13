package it.edoardo.springweb.database;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.edoardo.springweb.model.Item;
import it.edoardo.springweb.model.Order;
import it.edoardo.springweb.model.Product;
import it.edoardo.springweb.model.User;

@Component
public class Database {
	
	@Autowired private List<Item> users;
	@Autowired private List<Item> products;
	@Autowired private List<Item> orders;
	
	@PostConstruct
	public void init() {
	}
	
//	private void createUsers() {
//		this.users = new ArrayList<Item>();
//		this.users.add(new User("Mario", "Rossi"));
//		this.users.add(new User("Maria", "Rossi"));
//		this.users.add(new User("Federico", "Rossi"));
//		this.users.add(new User("Federica", "Rossi"));
//	}
//	
//	private void creteProducts() {
//		this.products = new ArrayList<Item>();
//		this.products.add(new Product("Ammoniaca"));
//		this.products.add(new Product("Pane"));
//		this.products.add(new Product("Candeggina"));
//		this.products.add(new Product("Acqua"));
//		this.products.add(new Product("Zucchine"));
//		this.products.add(new Product("Pasta"));
//	}
//	
//	private void createOrders() {
//		this.orders = new ArrayList<Item>();
//		this.orders.add(new Order(this.products.subList(2, 5), this.users.get(0)));
//		this.orders.add(new Order(this.products.subList(1, 3), this.users.get(1)));
//		this.orders.add(new Order(this.products.subList(3, 5), this.users.get(2)));
//		this.orders.add(new Order(this.products.subList(0, 5), this.users.get(3)));
//	}
	
	public List<Item> getUsers() {
		return this.users;
	}

	public Item getUser(int userId) {
		return this.users.stream().filter((currUser) -> { 
			return currUser.getId() == userId; 
		}).findFirst().orElse(null);
	}
	
	public List<Item> getProducts() {
		return this.products;
	}
	
	public Item getProduct(int productId) {
		return this.products.stream().filter((product) -> { 
			return product.getId() == productId; 
		}).findFirst().orElse(null);
	}

	public List<Item> getOrders() {
		return this.orders;
	}
	
	public Item getOrder(int orderId) {
		return this.orders.stream().filter((order) -> { 
			return order.getId() == orderId; 
		}).findFirst().orElse(null);
	}

	@PreDestroy
	public void destroy() {
		this.users = null;
		this.products = null;
		this.orders = null;
	}
}
