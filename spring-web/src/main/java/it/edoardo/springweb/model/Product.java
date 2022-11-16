package it.edoardo.springweb.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class Product extends Item{
	
	@JsonProperty(value = "name") private String name;
	@JsonProperty(value = "price") private double price;

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

	@Override
	public String toString() {
		return super.toString() + " name: " + name + ", price: " + price;
	}
}
