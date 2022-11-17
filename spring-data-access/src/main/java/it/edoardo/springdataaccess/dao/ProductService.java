package it.edoardo.springdataaccess.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProductService {
	
	private JdbcTemplate connection;
	
	public ProductService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

}
