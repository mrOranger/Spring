package it.edoardo.springdataaccess.model;

import java.util.List;

public class Order {
	
	private int id;
	private User customer;
	private List<Product> products;
	
	public Order() {
		super();
	}

	public Order(int id, User customer, List<Product> products) {
		super();
		this.id = id;
		this.customer = customer;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
