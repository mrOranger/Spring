package it.edoardo.springdataaccess.model;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class Order {
	
	@JsonProperty(value = "id") private int id;
	@JsonProperty(value = "customer") private User customer;
	@JsonProperty(value = "products") private List<Product> products;
	
	public Order() {
		super();
	}

	public Order(int id, User customer, List<Product> products) {
		super();
		this.id = id;
		this.customer = customer;
		this.products = products;
	}

	@JsonProperty(value = "id")
	public int getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty(value = "customer")
	public User getCustomer() {
		return customer;
	}
	
	@JsonProperty(value = "customer")
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	@JsonProperty(value = "products")
	public List<Product> getProducts() {
		return products;
	}
	
	@JsonProperty(value = "products")
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
