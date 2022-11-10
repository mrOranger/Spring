package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "users/")
public class UserController {
	
	@GetMapping(path = "/", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUser() {
		return null;
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
	
	@DeleteMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUser() {
		return null;
	}
}
