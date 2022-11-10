package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "products/")
public class ProductController {
	
	@RequestMapping(path = "/", 
			method = RequestMethod.GET, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProduct() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.POST, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String addProduct() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.PUT, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProduct() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.DELETE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deletProduct() {
		return null;
	}
}
