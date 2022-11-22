package it.edoardo.springorm.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity @Table(name = "products") @Generated("jsonschema2pojo")
public class Product implements Serializable, Comparable<Product> {

	private static final long serialVersionUID = 3529457983597142947L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id") private int id;
	
	@Column(name = "name") 
	@JsonProperty(value = "name") private String name;
	
	@Column(name = "price") 
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

	@Override
	public int compareTo(Product o) {
		return this.getId() - o.getId();
	}

	@Override
	public boolean equals(Object obj) {
		return ((Product)obj).getId() == this.getId();
	}
	
	
}
