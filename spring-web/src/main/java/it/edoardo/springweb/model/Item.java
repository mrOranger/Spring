package it.edoardo.springweb.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public abstract class Item implements Comparable<Item>{
	
	@JsonProperty(value = "id") protected int id;

	@JsonProperty(value = "id") 
	public int getId() {
		return id;
	}

	@JsonProperty(value = "id") 
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Item o) {
		return this.getId() - o.getId();
	}

	@Override
	public String toString() {
		return "id." + this.getId();
	}
}
