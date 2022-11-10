package it.edoardo.springweb.database;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
		this.users.add(new User("Mario", "Rossi"));
		this.users.add(new User("Maria", "Rossi"));
		this.users.add(new User("Federico", "Rossi"));
		this.users.add(new User("Federica", "Rossi"));
	}
	
	private void creteProducts() {
		this.products.add(new Product("Ammoniaca"));
		this.products.add(new Product("Pane"));
		this.products.add(new Product("Candeggina"));
		this.products.add(new Product("Acqua"));
		this.products.add(new Product("Zucchine"));
		this.products.add(new Product("Pasta"));
	}
	
	private void createOrders() {
		this.orders.add(new Order(this.products.subList(2, 5), this.users.get(0)));
		this.orders.add(new Order(this.products.subList(1, 3), this.users.get(1)));
		this.orders.add(new Order(this.products.subList(3, 5), this.users.get(2)));
		this.orders.add(new Order(this.products.subList(0, 5), this.users.get(3)));
		this.orders.add(new Order(this.products.subList(1, 4), this.users.get(4)));
	}
	
	public List<User> getUsers() {
		return users;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@PreDestroy
	public void destroy() {
		this.users = null;
		this.products = null;
		this.orders = null;
	}
}
