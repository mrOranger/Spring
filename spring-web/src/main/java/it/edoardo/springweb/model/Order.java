package it.edoardo.springweb.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<Product> products;
	private String id;
	private User customer;
	
	public Order(User customer) {
		this.id = LocalTime.now().toString();
		this.products = new ArrayList<Product>();
		this.customer = customer;
	}

	public Order(List<Product> products, String id, User customer) {
		this.products = products;
		this.id = id;
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Order id.").append(this.getId()).append("\n");
		strBuilder.append("Made by: ").append(this.getCustomer().toString()).append("\n");
		this.getProducts().stream().forEach((product) -> 
				strBuilder.append("\t").
				append(product.toString()).append("\n"));
		strBuilder.append("Totale: ").
			append(this.getProducts().stream().
						mapToDouble(Product::getPrice).
						sum()).
			append("\n");
		return strBuilder.toString();
	}
}
