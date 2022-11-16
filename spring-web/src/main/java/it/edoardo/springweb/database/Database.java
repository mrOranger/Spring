package it.edoardo.springweb.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import it.edoardo.springweb.model.Item;

@Component
public class Database {
	
	private List<Item> users;
	private List<Item> products;
	private List<Item> orders;
	
	public Database(String database, String user, String password, String url, String port) {
		System.out.println(new StringBuilder().append("Connecting to ").append(database)
				.append(" with credentials ")
				.append(user).append(" ").append(password)
				.append(" in ")
				.append(url).append(":").append(port).toString());
	}
	
	@PostConstruct
	public void init() {
		this.users = new ArrayList<Item>();
		this.products = new ArrayList<Item>();
		this.orders = new ArrayList<Item>();
	}
	
	public List<Item> getItems(ItemType type) {
		switch(type) {
			case USER:
				return this.users;
			case PRODUCT:
				return this.products;
			default:
				return this.orders;
		}
	}
	
	public Item getItem(int itemId, ItemType type) {
		switch(type) {
			case USER:
				return getSingleItem(this.users, itemId);
			case PRODUCT:
				return getSingleItem(this.products, itemId);
			default:
				return getSingleItem(this.orders, itemId);
		}
	}
	
	private Item getSingleItem(List<? extends Item> collection, int itemId) {
		return collection.stream().filter((currItem) -> { 
			return currItem.getId() == itemId; 
		}).findFirst().orElse(null);
	}
	
	public Item addItem(Item item, ItemType type) {
		switch(type) {
			case USER:
				this.users.add(item);
			case PRODUCT:
				this.products.add(item);
			default:
				this.orders.add(item);
		}
		return item;
	}
	
	public List<? extends Item> replaceCollection(List<? extends Item> items, ItemType type) {
		switch(type) {
			case USER:
				return replaceSingleCollection(this.users, items);
			case PRODUCT:
				return replaceSingleCollection(this.products, items);
			default:
				return replaceSingleCollection(this.orders, items);
		}
	}
	
	private List<? extends Item> replaceSingleCollection(List<Item> oldCollection, List<? extends Item> newCollection) {
		for(int i = 0; i < oldCollection.size(); i++) {
			oldCollection.remove(i);
		}
		newCollection.stream().forEach((item) -> oldCollection.add(item));
		return oldCollection;
	}
	
	public Item replaceElement(int itemIndex, Item item, ItemType type) {
		switch(type) {
			case USER:
				replaceSingleElement(this.users, item, itemIndex);
				break;
			case PRODUCT:
				replaceSingleElement(this.products, item, itemIndex);
				break;
			default:
				replaceSingleElement(this.orders, item, itemIndex);
				break;
		}
		return item;
	}
	
	private void replaceSingleElement(List<Item> collection, Item item, int itemIndex) {
		Item found = collection.stream().filter((elem) -> elem.getId() == itemIndex).
				findFirst().orElse(null);
			if(found != null) {
				collection = collection.stream().map(currOrder -> 
					(currOrder.getId() == itemIndex) ? item : currOrder
				).collect(Collectors.toList());
			} else {
				collection.add(item);
			}
	}
	
	public List<? extends Item> deleteCollection(ItemType type) {
		switch(type) {
			case USER:
				this.users.removeAll(this.users);
				return users;
			case PRODUCT:
				this.products.removeAll(this.products);
				return products;
			default:
				this.orders.removeAll(this.orders);
				return orders;
		}		
	}
	
	public List<? extends Item> deleteItem(int itemId, ItemType type) {
		switch(type) {
			case USER:
				return deleteSingleItem(this.users, itemId);
			case PRODUCT:
				return deleteSingleItem(this.products, itemId);
			default:
				return deleteSingleItem(this.orders, itemId);
		}				
	}
	
	private List<? extends Item> deleteSingleItem(List<? extends Item> collection, int itemId) {
		Item foundItem = collection.stream().filter((currItem) -> currItem.getId() == itemId)
						.findFirst().get();
		if(foundItem != null) {
			collection.remove(foundItem);
		}
		return collection;
	}

	@PreDestroy
	public void destroy() {
		this.users = null;
		this.products = null;
		this.orders = null;
	}
}
