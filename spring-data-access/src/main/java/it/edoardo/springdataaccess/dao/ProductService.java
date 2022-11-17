package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.ProductDAO;
import it.edoardo.springdataaccess.model.Product;

public class ProductService implements ProductDAO{
	
	private JdbcTemplate connection;
	
	private static final String INSERT_PRODUCT = "INSERT INTO products VALUES(?, ?)";
	
	public ProductService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		this.connection.update(INSERT_PRODUCT, product.getName(), product.getPrice());
	}

	@Override
	public void updateProducts(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProducts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

}
