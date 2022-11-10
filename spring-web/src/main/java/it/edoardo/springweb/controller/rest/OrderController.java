package it.edoardo.springweb.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "orders/")
public class OrderController {

	@RequestMapping(path = "/", 
			method = RequestMethod.GET, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.POST, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.PUT, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder() {
		return null;
	}
	
	@RequestMapping(path = "/", 
			method = RequestMethod.DELETE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder() {
		return null;
	}
}
