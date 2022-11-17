package it.edoardo.springdataaccess.dao.interfaces;

import java.util.List;

import it.edoardo.springdataaccess.model.Order;
import it.edoardo.springdataaccess.model.Product;
import it.edoardo.springdataaccess.model.User;

public interface OrderDAO {
	
	public abstract List<Order> getOrders();
	public abstract Order getOrder(int id);
	public abstract void addOrder(Order order);
	public abstract void updateOrders(List<Order> orders);
	public abstract void updateOrder(int id, Order order);
	public abstract void deleteOrders();
	public abstract void deleteOrder(int id);
	
	public abstract User getUser(int orderId);
	
	public abstract List<Product> getProducts(int orderId);
	public abstract Product getProduct(int orderId, int productId);
	public abstract void addProduct(int orderId, Product product);
	public abstract void updateProducts(int orderId, List<Product> products);
	public abstract void updateProduct(int orderId, int productId, Product product);
	public abstract void deleteProducts(int orderId);
	public abstract void deleteProduct(int orderId, int productId);

}
