package it.edoardo.springorm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -1970433144207280641L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	@ManyToOne
	@JoinColumn(name = "customer")
	private User customer;
	
	@ManyToMany
	@JoinTable(
			name = "products_orders",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products;
	
	public Order() {
		this.products = new ArrayList<Product>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
