package it.edoardo.springdataaccess.controller.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
