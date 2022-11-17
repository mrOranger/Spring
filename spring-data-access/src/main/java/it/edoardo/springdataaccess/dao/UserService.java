package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.UserDAO;
import it.edoardo.springdataaccess.model.User;

public class UserService implements UserDAO{
	
	private JdbcTemplate connection;
	
	private static final String INSERT_USER = "INSERT INTO users VALUES(?, ?, ?, ?)";

	public UserService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		this.connection.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode());
	}

	@Override
	public void updateUsers(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}
}
