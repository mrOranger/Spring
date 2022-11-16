package it.edoardo.springweb.database;

import java.util.ArrayList;
import java.util.List;

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
				return this.users.stream().filter((currUser) -> { 
					return currUser.getId() == itemId; 
				}).findFirst().orElse(null);
			case PRODUCT:
				return this.products.stream().filter((currProduct) -> { 
					return currProduct.getId() == itemId; 
				}).findFirst().orElse(null);
			default:
				return this.orders.stream().filter((currOrder) -> { 
					return currOrder.getId() == itemId; 
				}).findFirst().orElse(null);
		}
	}
	
	public List<Item> addItem(Item item, ItemType type) {
		switch(type) {
			case USER:
				this.users.add(item);
				return this.users;
			case PRODUCT:
				this.products.add(item);
				return this.products;
			default:
				this.orders.add(item);
				return this.orders;
		}
	}
	
	public List<Item> replaceCollection(List<Item> items, ItemType type) {
		switch(type) {
			case USER:
				this.users = items;
				return users;
			case PRODUCT:
				this.products = items;
				return products;
			default:
				this.orders = items;
				return orders;
		}
	}
	
	public List<Item> replaceElement(Item item, ItemType type) {
		switch(type) {
			case USER:
				this.users.stream().map((currUser) -> {
					if(currUser.getId() == item.getId()) {
						return item;
					}
					return currUser;
				});
				return users;
			case PRODUCT:
				this.products.stream().map((currProduct) -> {
					if(currProduct.getId() == item.getId()) {
						return item;
					}
					return currProduct;
				});
				return products;
			default:
				this.users.stream().map((currOrder) -> {
					if(currOrder.getId() == item.getId()) {
						return item;
					}
					return currOrder;
				});
				return orders;
		}
	}
	
	public List<Item> deleteCollection(ItemType type) {
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
	
	public List<Item> deleteItem(int itemId, ItemType type) {
		switch(type) {
			case USER:
				Item foundUser = this.products.stream().filter((currUser) -> currUser.getId() == itemId)
								.findFirst().get();
				if(foundUser != null) {
					this.users.remove(foundUser);
				}
				return this.users;
			case PRODUCT:
				Item foundProduct = this.products.stream().filter((currUser) -> currUser.getId() == itemId)
								.findFirst().get();
				if(foundProduct != null) {
					this.products.remove(foundProduct);
				}
				return this.products;
			default:
				Item foundOrder = this.products.stream().filter((currUser) -> currUser.getId() == itemId)
							.findFirst().get();
				if(foundOrder != null) {
					this.users.remove(foundOrder);
				}
				return this.orders;
		}				
	}

	@PreDestroy
	public void destroy() {
		this.users = null;
		this.products = null;
		this.orders = null;
	}
}
