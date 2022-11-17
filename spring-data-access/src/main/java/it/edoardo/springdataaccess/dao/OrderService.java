package it.edoardo.springdataaccess.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderService {
	
	private JdbcTemplate connection;
	
	public OrderService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

}
