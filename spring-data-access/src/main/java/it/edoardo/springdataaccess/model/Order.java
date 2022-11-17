package it.edoardo.springdataaccess.model;

import java.util.List;

public class Order {
	
	private User customer;
	private List<Product> products;
	
	public Order() {
		super();
	}

	public Order(User customer, List<Product> products) {
		super();
		this.customer = customer;
		this.products = products;
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
