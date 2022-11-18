package it.edoardo.springdataaccess.controller.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springdataaccess.dao.UserService;
import it.edoardo.springdataaccess.model.User;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired private UserService userService;
	
	@GetMapping(path = "/")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
	
	@GetMapping(path = "/{id}")
	public User getUser(@PathVariable(value = "id") int userId) {
		return this.userService.getUser(userId);	
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User postUser(@RequestBody User user) {
		try {
			this.userService.addUser(user);
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<User> putUsers(@RequestBody List<User> users) {
		try {
			this.userService.updateUsers(users);
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return users;
	}
	
	@PutMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User putUser(@PathVariable int userId, @RequestBody User user) {
		try {
			this.userService.updateUser(userId, user);
		} catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
}
