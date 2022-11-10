package it.edoardo.springweb.model;

public class Product {
	
	private int id;
	private String name;
	private double price;
	
	private static int INCREMENTAL_ID = 0;

	public Product(String name) {
		this.name = name;
		this.price = Math.random();
		this.id = INCREMENTAL_ID++;
	}
	
	public Product(String name, double price) {
		this.id = INCREMENTAL_ID++;
		this.name = name;
		this.price = price;
	}
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

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

	@Override
	public String toString() {
		return "id: " + id + " name: " + name + ", price: " + price + '\n';
	}
}
