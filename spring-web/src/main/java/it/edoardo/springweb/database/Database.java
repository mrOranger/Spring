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
				for(int i = 0; i < this.users.size(); i++) {
					this.users.remove(i);
				}
				items.stream().forEach(this.users::add);	
				return users;
			case PRODUCT:
				for(int i = 0; i < this.products.size(); i++) {
					this.products.remove(i);
				}
				items.stream().forEach(this.products::add);
				return products;
			default:
				for(int i = 0; i < this.orders.size(); i++) {
					this.orders.remove(i);
				}
				items.stream().forEach(this.orders::add);
				return orders;
		}
	}
	
	// TODO: refactoring
	public Item replaceElement(int itemIndex, Item item, ItemType type) {
		Item found;
		switch(type) {
			case USER:
				found = this.users.stream().filter((elem) -> elem.getId() == itemIndex).
					findFirst().orElse(null);
				if(found != null) {
					this.users = this.users.stream().map(currUser -> 
						(currUser.getId() == itemIndex) ? item : currUser
					).collect(Collectors.toList());
				} else {
					this.users.add(item);
				}
				break;
			case PRODUCT:
				found = this.products.stream().filter((elem) -> elem.getId() == itemIndex).
					findFirst().orElse(null);
				if(found != null) {
					this.products = this.products.stream().map(currProduct -> 
						(currProduct.getId() == itemIndex) ? item : currProduct
					).collect(Collectors.toList());
				} else {
					this.products.add(item);
				}
				break;
			default:
				found = this.orders.stream().filter((elem) -> elem.getId() == itemIndex).
					findFirst().orElse(null);
				if(found != null) {
					this.orders = this.orders.stream().map(currOrder -> 
						(currOrder.getId() == itemIndex) ? item : currOrder
					).collect(Collectors.toList());
				} else {
					this.orders.add(item);
				}
				break;
		}
		return item;
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
				Item foundUser = this.users.stream().filter((currUser) -> currUser.getId() == itemId)
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
				Item foundOrder = this.orders.stream().filter((currUser) -> currUser.getId() == itemId)
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
