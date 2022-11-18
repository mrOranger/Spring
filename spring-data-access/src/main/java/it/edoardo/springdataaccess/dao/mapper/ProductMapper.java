package it.edoardo.springdataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.edoardo.springdataaccess.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Product product = new Product();
		product.setId(resultSet.getInt("id"));
		product.setName(resultSet.getString("name"));
		product.setPrice(resultSet.getDouble("price"));
		return product;
	}

}
