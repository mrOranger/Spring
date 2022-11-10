package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "orders/")
public class OrderController {
	
	@GetMapping(path = "/", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder() {
		return null;
	}
	
	@PostMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder() {
		return null;
	}
	
	@PutMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder() {
		return null;
	}
	
	@DeleteMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder() {
		return null;
	}
}
