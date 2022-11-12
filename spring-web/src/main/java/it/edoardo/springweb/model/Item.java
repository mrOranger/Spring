package it.edoardo.springweb.model;

import org.json.JSONObject;

import it.edoardo.springweb.model.interfaces.Jsonable;

public abstract class Item implements Comparable<Item>, Jsonable{
	
	protected int id;
	
	public Item(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Item o) {
		return this.getId() - o.getId();
	}

	@Override
	public JSONObject toJson() {
		final JSONObject json = new JSONObject();
		json.put("id", this.getId());
		return json;
	}

	@Override
	public String toString() {
		return "id." + this.getId();
	}
}
