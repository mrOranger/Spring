package it.edoardo.springorm.model;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 3529457983597142947L;
	
	private int id;
	private String name;
	private double price;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
