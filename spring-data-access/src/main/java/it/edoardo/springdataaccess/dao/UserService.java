package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.UserDAO;
import it.edoardo.springdataaccess.dao.mapper.UserMapper;
import it.edoardo.springdataaccess.model.User;

public class UserService implements UserDAO{
	
	private JdbcTemplate connection;
	
	private static final String ADD_USER = "INSERT INTO users VALUES(?, ?, ?, ?)";
	private static final String GET_USERS = "SELECT * FROM users";
	private static final String GET_USER = "SELECT (id, first_name, last_name, date_of_birth, tax_code) FROM users WHERE id = ?";
	private static final String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, date_of_birth = ?, tax_code = ? WHERE id = ?";
	private static final String DELETE_USERS = "DELETE FROM users";
	private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

	public UserService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUsers() {
		return this.connection.query(GET_USERS, new UserMapper());
	}

	@Override
	public User getUser(int id) {
		return this.connection.queryForObject(GET_USER, User.class, id);
	}

	@Override
	public void addUser(User user) {
		this.connection.update(ADD_USER, user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode());
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
