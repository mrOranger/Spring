package it.edoardo.springdataaccess.dao.interfaces;

import java.util.List;

import it.edoardo.springdataaccess.model.User;

public interface UserDAO {
	
	public abstract List<User> getUsers();
	public abstract User getUser(int id);
	public abstract void addUser(User user);
	public abstract void updateUsers(List<User> users);
	public abstract void updateUser(int id, User user);
	public abstract void deleteUsers();
	public abstract void deleteUser(int id);

}
