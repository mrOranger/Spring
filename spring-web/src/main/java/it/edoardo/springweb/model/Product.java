package it.edoardo.springweb.model;

import org.json.JSONObject;

import it.edoardo.springweb.model.interfaces.Jsonable;

public class Product extends Item implements Jsonable{
	
	private String name;
	private double price;
	
	private static int INCREMENTAL_ID = 0;

	public Product(String name) {
		super(INCREMENTAL_ID++);
		this.name = name;
		this.price = Math.random();
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

	@Override
	public String toString() {
		return super.toString() + " name: " + name + ", price: " + price;
	}
	
	@Override
	public JSONObject toJson() {
		return super.toJson()
			.put("name", this.getName())
			.put("price", this.getPrice());

	}
}
