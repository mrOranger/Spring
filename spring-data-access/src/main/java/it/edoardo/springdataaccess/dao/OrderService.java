package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.OrderDAO;
import it.edoardo.springdataaccess.dao.mapper.OrderMapper;
import it.edoardo.springdataaccess.dao.mapper.ProductMapper;
import it.edoardo.springdataaccess.dao.mapper.UserMapper;
import it.edoardo.springdataaccess.model.Order;
import it.edoardo.springdataaccess.model.Product;
import it.edoardo.springdataaccess.model.User;

public class OrderService implements OrderDAO{
	
	private JdbcTemplate connection;
	
	@Autowired private UserService userService;
	@Autowired private ProductService productService;
	
	private static final String GET_ORDERS = "SELECT DISTINCT O.id, C.id AS customer_id, C.first_name, C.last_name, C.date_of_birth, C.tax_code, P.id AS product_id, P.name AS product_name, P.price AS product_price"
			+ " FROM orders O, orders_products OP, products P, users C"
			+ " WHERE O.id = OP.order_id AND OP.product_id = P.id AND O.customer = C.id"
			+ " ORDER BY O.id";
	private static final String GET_ORDER = "SELECT DISTINCT O.id, C.id AS customer_id, C.first_name, C.last_name, C.date_of_birth, C.tax_code, P.id AS product_id, P.name AS product_name, P.price AS product_price"
			+ " FROM orders O, orders_products OP, products P, users C"
			+ " WHERE O.id = OP.order_id AND OP.product_id = P.id AND O.customer = C.id AND O.id = ?";
	private static final String ADD_ORDER = "INSERT INTO orders (id, customer) VALUES (?, ?)" +
			" ON DUPLICATE KEY UPDATE id = ?, customer = ?";
	private static final String ADD_ORDER_PRODUCT = "INSERT INTO orders_products VALUES (?, ?)"
			+ " ON DUPLICATE KEY UPDATE order_id = ?, product_id = ?";
	private static final String DELETE_ORDERS = "DELETE FROM orders";
	private static final String DELETE_ORDERS_REFERENCE = "DELETE FROM orders_products";
	private static final String DELETE_ORDER = DELETE_ORDERS + " WHERE id = ?";
	private static final String DELETE_ORDER_REFERENCE = DELETE_ORDERS_REFERENCE + " WHERE order_id = ?";
	
	private static final String GET_USER = "SELECT C.id AS customer_id, C.first_name, C.last_name, C.date_of_birth, C.tax_code FROM orders O, users C"
			+ "	WHERE  O.customer = C.id";
	private static final String GET_PRODUCTS = "SELECT P.id AS product_id, P.name AS product_name, P.price AS product_price"
			+ " FROM orders O, orders_products OP, products P, users C"
			+ " WHERE O.id = OP.order_id AND OP.product_id = P.id AND O.customer = C.id AND O.id = ?";
	private static final String GET_PRODUCT = GET_PRODUCTS + " AND P.id = ?";
	private static final String ADD_PRODUCT_ORDER = "INSERT INTO INSERT INTO orders_products VALUES (?, ?) "
			+ " ON DUPLICATE KEY UPDATE order_id = ?, product_id = ?";
	private static final String DELETE_PRODUCTS = "DELETE FROM orders O, orders_products OP WHERE O.id = OP.order_id AND O.id = ? ";
	private static final String DELETE_PRODUCT = DELETE_PRODUCTS + " AND OP.product_id = ?";
	
	
	
	public OrderService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Order> getOrders() throws DataAccessException {
		return this.connection.query(GET_ORDERS, new OrderMapper());
	}

	@Override
	public Order getOrder(int id) throws EmptyResultDataAccessException{
		return this.connection.queryForObject(GET_ORDER, new OrderMapper(), id);
	}

	@Override
	public void addOrder(Order order) throws DataAccessException {
		this.userService.addUser(order.getCustomer());
		order.getProducts().stream().forEach((product) -> this.productService.addProduct(product));
		this.connection.query(ADD_ORDER, new OrderMapper(), order.getId(), order.getCustomer().getId(), order.getId(), order.getCustomer().getId());
		order.getProducts().stream().forEach((product) -> this.connection.query(ADD_ORDER_PRODUCT, new OrderMapper(), order.getId(), product.getId(), order.getId(), product.getId()));
	}

	@Override
	public void updateOrders(List<Order> orders) throws DataAccessException {
		orders.stream().forEach((order) -> {
			this.addOrder(order);
		}); 
	}

	@Override
	public void updateOrder(int id, Order order) throws DataAccessException {
		this.userService.addUser(order.getCustomer());
		order.getProducts().stream().forEach((product) -> this.productService.addProduct(product));
		this.connection.query(ADD_ORDER, new OrderMapper(), id, order.getCustomer().getId(), id, order.getCustomer().getId());
		order.getProducts().stream().forEach((product) -> this.connection.query(ADD_ORDER_PRODUCT, new OrderMapper(), id, product.getId(), id, product.getId()));
	}

	@Override
	public void deleteOrders() throws DataAccessException {
		this.connection.update(DELETE_ORDERS_REFERENCE);
		this.connection.update(DELETE_ORDERS);
	}

	@Override
	public void deleteOrder(int id) throws DataAccessException {
		this.connection.update(DELETE_ORDER_REFERENCE, id);
		this.connection.update(DELETE_ORDER, id);
	}

	@Override
	public User getUser(int orderId) throws DataAccessException {
		return this.connection.queryForObject(GET_USER, new UserMapper());
	}

	@Override
	public List<Product> getProducts(int orderId) {
		return this.connection.query(GET_PRODUCTS, new ProductMapper(), orderId);
	}

	@Override
	public Product getProduct(int orderId, int productId) {
		return this.connection.queryForObject(GET_PRODUCT, new ProductMapper(), orderId, productId);
	}

	@Override
	public void addProduct(int orderId, Product product) {
		this.productService.addProduct(product);
		this.connection.update(ADD_PRODUCT_ORDER, orderId, product.getId());
	}

	@Override
	public void updateProducts(int orderId, List<Product> products) {
		products.stream().forEach((product) -> {
			this.productService.updateProduct(product.getId(), product);
			this.addProduct(orderId, product);
		});
	}

	@Override
	public void updateProduct(int orderId, int productId, Product product) {
		this.productService.addProduct(product);
		this.connection.update(ADD_PRODUCT_ORDER, orderId, productId);
	}

	@Override
	public void deleteProducts(int orderId) {
		this.connection.update(DELETE_PRODUCTS, orderId);
	}

	@Override
	public void deleteProduct(int orderId, int productId) {
		this.connection.update(DELETE_PRODUCT, orderId, productId);
	}

}
