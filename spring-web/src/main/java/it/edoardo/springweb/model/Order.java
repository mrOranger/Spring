package it.edoardo.springweb.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import it.edoardo.springweb.model.interfaces.Jsonable;

public class Order extends Item implements Jsonable{
	
	private List<Item> products;
	private Item customer;
	
	private static int INCREMENTAL_ID = 0;
	
	public Order(List<Item> products, Item customer) {
		super(INCREMENTAL_ID++);
		this.products = products;
		this.customer = customer;
	}

	public List<Item> getProducts() {
		return products;
	}
	
	public void setProducts(List<Item> products) {
		this.products = products;
	}
	
	public User getCustomer() {
		return (User)this.customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Order ").append(super.toString()).append("\n");
		strBuilder.append("Made by: ").append(this.getCustomer().toString()).append("\n");
		this.getProducts().stream().forEach((product) -> 
				strBuilder.append("\t").
				append(product.toString()).append("\n"));
		strBuilder.append("Totale: ").
			append(this.getProducts().stream().
						mapToDouble((item) -> ((Product)item).getPrice()).
						sum()).
			append("\n");
		return strBuilder.toString();
	}

	@Override
	public JSONObject toJson() {
		final JSONObject json = super.toJson()
			.put("user", this.getCustomer().toJson())
			.put("products", new ArrayList<Product>());
		
		this.getProducts().stream().forEach((product) -> {
			json.append("products", product.toJson());
		});
		
		final double total = this.getProducts().stream().mapToDouble((item) -> ((Product)item).getPrice()).sum();
		json.put("total", total);
		return json;
	}
}
