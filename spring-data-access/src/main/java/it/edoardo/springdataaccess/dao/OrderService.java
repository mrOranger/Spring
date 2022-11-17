package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.OrderDAO;
import it.edoardo.springdataaccess.model.Order;
import it.edoardo.springdataaccess.model.Product;
import it.edoardo.springdataaccess.model.User;

public class OrderService implements OrderDAO{
	
	private JdbcTemplate connection;
	
	private static final String INSERT_ORDER = "INSERT INTO orders VALUES (?)";
	private static final String INSERT_ORDER_PRODUCTS = "INSERT INTO orders_products VALUES (?, ?)";
	
	
	public OrderService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(Order order) {
		this.connection.update(INSERT_ORDER, order.getCustomer().getId());
		order.getProducts().forEach((product) -> this.connection.update(INSERT_ORDER_PRODUCTS, order.getId(), product.getId()));
	}

	@Override
	public void updateOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(int id, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrders() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int orderId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(int orderId, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProducts(int orderId, List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(int orderId, int productId, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProducts(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int orderId, int productId) {
		// TODO Auto-generated method stub
		
	}

}
