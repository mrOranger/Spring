package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.ProductDAO;
import it.edoardo.springdataaccess.dao.mapper.ProductMapper;
import it.edoardo.springdataaccess.model.Product;

public class ProductService implements ProductDAO{
	
	private JdbcTemplate connection;
	
	private static final String GET_PRODUCTS = "SELECT id, name, price FROM products";
	private static final String GET_PRODUCT = "SELECT id, name, price FROM products WHERE id = ?";
	private static final String ADD_PRODUCT = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)"
			+ " ON DUPLICATE KEY UPDATE id = ?, name = ?, price = ?";
	private static final String DELETE_PRODUCTS = "DELETE FROM products";
	private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";
	
	
	public ProductService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> getProducts() throws DataAccessException {
		return this.connection.query(GET_PRODUCTS, new ProductMapper());
	}

	@Override
	public Product getProduct(int id) throws EmptyResultDataAccessException {
		return this.connection.queryForObject(GET_PRODUCT, new ProductMapper(), id);
	}

	@Override
	public void addProduct(Product product) throws DataAccessException {
		this.connection.update(ADD_PRODUCT, product.getId(), product.getName(), product.getPrice(),
				product.getId(), product.getName(), product.getPrice());
	}

	@Override
	public void updateProducts(List<Product> products) throws DataAccessException {
		products.forEach((product) -> this.updateProduct(product.getId(), product));
	}

	@Override
	public void updateProduct(int id, Product product) throws DataAccessException {
		this.connection.update(ADD_PRODUCT, id, product.getName(), product.getPrice(),
				product.getId(), product.getName(), product.getPrice());
	}

	@Override
	public void deleteProducts() throws DataAccessException {
		this.connection.update(DELETE_PRODUCTS);
	}

	@Override
	public void deleteProduct(int id) throws DataAccessException {
		this.connection.update(DELETE_PRODUCT, id);
	}
}
