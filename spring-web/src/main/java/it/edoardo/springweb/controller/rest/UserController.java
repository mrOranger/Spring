package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "users/")
public class UserController {
	
	@GetMapping(path = "/", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUsers() {
		return null;
	}
	
	@GetMapping(path = "/{userId}", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUser(@PathVariable("userId") String userId) {
		return userId;
	}
	
	@PostMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String addUser() {
		return null;
	}
	
	@PutMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateUser() {
		return null;
	}
	
	@DeleteMapping(path = "/{userId}",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUser(@PathVariable("userId") String userId) {
		return userId;
	}
}
