package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "products/")
public class ProductController {
	
	@GetMapping(path = "/", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProducts() {
		return null;
	}
	
	@GetMapping(path = "/{productId}", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProduct(@PathVariable("productId") String productId) {
		return productId;
	}
	
	@PostMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String addProduct() {
		return null;
	}
	
	@PutMapping(path = "/",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProduct() {
		return null;
	}
	
	@DeleteMapping(path = "/{productId}",  
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduct(@PathVariable("productId") String productId) {
		return productId;
	}
}
