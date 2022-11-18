package it.edoardo.springdataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.edoardo.springdataaccess.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setFirstName(resultSet.getString("first_name"));
		user.setLastName(resultSet.getString("last_name"));
		user.setDateOfBirth(new java.sql.Date(resultSet.getDate("date_of_birth").getTime()).toLocalDate());
		user.setTaxCode(resultSet.getString("tax_code"));
		return user;
	}
	
}
