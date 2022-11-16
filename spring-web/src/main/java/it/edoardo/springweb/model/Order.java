package it.edoardo.springweb.model;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class Order extends Item{
	
	@JsonProperty(value = "products") private List<Product> products;
	@JsonProperty(value = "customer") private User customer;

	@JsonProperty(value = "products")
	public List<Product> getProducts() {
		return products;
	}
	
	@JsonProperty(value = "products")
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@JsonProperty(value = "customer")
	public User getCustomer() {
		return this.customer;
	}
	
	@JsonProperty(value = "customer")
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
}
