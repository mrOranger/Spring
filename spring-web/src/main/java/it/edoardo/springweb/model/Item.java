package it.edoardo.springweb.model;

public abstract class Item implements Comparable<Item>{
	
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
	public String toString() {
		return "id." + this.getId();
	}
}
