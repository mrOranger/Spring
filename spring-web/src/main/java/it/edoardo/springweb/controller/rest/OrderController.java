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
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => GET 
	 * @return the list of the orders of the collection
	 */
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
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => GET 
	 * @return the order with the corresponding id if present in the collection
	 */
	@GetMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder(@PathVariable("orderId") String orderId) {
		final int orderIndex = Integer.parseInt(orderId);
		if(orderIndex >= 0 && (orderIndex < this.database.getOrders().size())) {
			return this.database.getOrders().get(orderIndex).toString();
		}
		return "There is not any order with that id!";
	}
	
	/**
	 * Creates a new element in the collection
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => POST 
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder() {
		return null;
	}
	
	/**
	 * Substitutes the collection with a new one
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => PUT 
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrders() {
		return null;
	}
	
	/**
	 * Substitutes the order with the corresponding id if is in the collection,
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => PUT 
	 * @return the modified collection
	 */
	@PutMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder() {
		return null;
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => DELETE
	 * @return an empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrders() {
		return null;
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => DELETE
	 * @return the modified collection
	 */
	@DeleteMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder(@PathVariable("orderId") String orderId) {
		return orderId;
	}
}