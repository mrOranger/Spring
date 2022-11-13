package it.edoardo.springweb.database;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.edoardo.springweb.model.Item;

// TODO: inserire il logger per il database ed i controllers
@Component
public class Database {
	
	@Autowired private List<Item> users;
	@Autowired private List<Item> products;
	@Autowired private List<Item> orders;
	
	@PostConstruct
	public void init() {
	}
	
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
