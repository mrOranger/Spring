package it.edoardo.springweb.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "orders/")
public class OrderController {

	@RequestMapping(path = "/")
	public String test() {
		return "Order Controller";
	}
	
}
