package it.edoardo.springorm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity @Table(name = "orders") @Generated("jsonschema2pojo")
@JsonIgnoreProperties(value = "products")
public class Order implements Serializable {

	private static final long serialVersionUID = -1970433144207280641L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id") private int id;
	 
	@ManyToOne
	@JoinColumn(name = "customer")
	@JsonProperty(value = "customer") private User customer;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "products_orders",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	@JsonProperty(value = "products") private List<Product> products;
	
	public Order() {
		this.products = new ArrayList<Product>();
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
