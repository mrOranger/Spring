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

@RestController @RequestMapping(path = "orders/")
public class OrderController {
	
	@Autowired private Database database;
	
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrders() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("There are ").
			append(this.database.getOrders().size()).
			append(" orders").
			append("\n");
		this.database.getOrders().stream().forEach(strBuilder::append);
		return strBuilder.toString();
	}
	
	@GetMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder(@PathVariable("orderId") String orderId) {
		final int orderIndex = Integer.parseInt(orderId);
		if(orderIndex >= 0 && (orderIndex < this.database.getOrders().size())) {
			return this.database.getOrders().get(orderIndex).toString();
		}
		return "There is not any order with that id!";
	}
	
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder() {
		return null;
	}
	
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder() {
		return null;
	}
	
	@DeleteMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder(@PathVariable("orderId") String orderId) {
		return orderId;
	}
}