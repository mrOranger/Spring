package it.edoardo.springweb.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springweb.database.Database;

@RestController @RequestMapping(path = "users/")
public class UserController {
	
	@Autowired private Database database;
	
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUsers() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("There are ").append(this.database.getUsers().size()).append(" users");
		this.database.getUsers().stream().forEach(strBuilder::append);
		return strBuilder.toString();
	}
	
	@GetMapping(path = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUser(@PathVariable("userId") String userId) {
		final int userIndex = Integer.parseInt(userId);
		if(userIndex > 0 && (userIndex < this.database.getUsers().size())) {
			return this.database.getUsers().get(userIndex).toString();
		}
		return "There is not any user with that id!";
	}
	
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addUser() {
		return null;
	}
	
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateUser() {
		return null;
	}
	
	@DeleteMapping(path = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUser(@PathVariable("userId") String userId) {
		return userId;
	}
}
