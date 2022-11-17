package it.edoardo.springdataaccess.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class Product {
	
	@JsonProperty(value = "id") private int id;
	@JsonProperty(value = "name") private String name;
	@JsonProperty(value = "price") private double price;

	@JsonProperty(value = "id")
	public int getId() {
		return id;
	}
	
	@JsonProperty(value = "id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty(value = "name")
	public String getName() {
		return name;
	}
	
	@JsonProperty(value = "name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty(value = "price")
	public double getPrice() {
		return price;
	}
	
	@JsonProperty(value = "price")
	public void setPrice(double price) {
		this.price = price;
	}
}
