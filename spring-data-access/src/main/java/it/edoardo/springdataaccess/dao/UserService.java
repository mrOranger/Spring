package it.edoardo.springdataaccess.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import it.edoardo.springdataaccess.dao.interfaces.UserDAO;
import it.edoardo.springdataaccess.dao.mapper.UserMapper;
import it.edoardo.springdataaccess.model.User;

public class UserService implements UserDAO {

	private JdbcTemplate connection;

	private static final String ADD_USER = "INSERT INTO users (id, first_name, last_name, date_of_birth, tax_code) VALUES(?, ?, ?, ?, ?)"
			+ "	ON DUPLICATE KEY UPDATE id = ?, first_name = ?, last_name = ?, date_of_birth = ?, tax_code = ?";
	private static final String GET_USERS = "SELECT id, first_name, last_name, date_of_birth, tax_code FROM users";
	private static final String GET_USER = "SELECT id, first_name, last_name, date_of_birth, tax_code FROM users WHERE id = ?";
	private static final String DELETE_USERS_REFERENCE = "DELETE FROM orders_products";
	private static final String DELETE_ORDERS_REFERENCE = "DELETE FROM orders";
	private static final String DELETE_USERS = "DELETE FROM users";
	private static final String DELETE_USER_REFERENCE = "DELETE FROM orders_products OP, orders O WHERE OP.order_id = O.id AND O.customer = ?";
	private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

	public UserService(DataSource dataSource) {
		this.connection = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUsers() throws DataAccessException {
		return this.connection.query(GET_USERS, new UserMapper());
	}

	@Override
	public User getUser(int id) throws EmptyResultDataAccessException {
		User user = null;
		try {
			user = this.connection.queryForObject(GET_USER, new UserMapper(), id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User user) throws DataAccessException {
		this.connection.update(ADD_USER, user.getId(), user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode(),
				user.getId(), user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode());
	}

	@Override
	public void updateUsers(List<User> users) throws DataAccessException {
		users.forEach((user) -> this.updateUser(user.getId(), user));
	}

	@Override
	public void updateUser(int id, User user) throws DataAccessException {
		this.connection.update(ADD_USER, id, user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode(),
				user.getFirstName(), user.getLastName(), user.getDateOfBirth().toString(), user.getTaxCode());
	}

	@Override
	public void deleteUsers() throws DataAccessException {
		this.connection.update(DELETE_USERS_REFERENCE);
		this.connection.update(DELETE_ORDERS_REFERENCE);
		this.connection.update(DELETE_USERS);
	}

	@Override
	public void deleteUser(int id) throws DataAccessException {
		this.connection.update(DELETE_USER_REFERENCE, id);
		this.connection.update(DELETE_USER, id);
	}
}
