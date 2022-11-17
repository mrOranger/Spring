package it.edoardo.springdataaccess.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {
	
	private JdbcTemplate connection;

	public UserService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}
	
	

}
