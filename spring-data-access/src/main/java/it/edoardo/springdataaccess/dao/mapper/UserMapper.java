package it.edoardo.springdataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.edoardo.springdataaccess.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final User user = new User();
		user.setId(resultSet.getInt(rowNum));
		user.setFirstName(resultSet.getString(rowNum));
		user.setLastName(resultSet.getString(rowNum));
		user.setDateOfBirth(new java.sql.Date(resultSet.getDate(rowNum).getTime()).toLocalDate());
		user.setTaxCode(resultSet.getString(rowNum));
		return user;
	}
	
}
