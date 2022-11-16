package it.edoardo.springweb.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.database.ItemType;
import it.edoardo.springweb.model.Item;
import it.edoardo.springweb.model.Order;

@RestController 
@RequestMapping(path = "orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired private Database database;
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => GET 
	 * @return the list of the orders of the collection
	 */
	@GetMapping(path = "/")
	public List<Item> getOrders(HttpServletRequest request, HttpServletResponse response) {
		return database.getItems(ItemType.ORDER);
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => GET 
	 * @return the order with the corresponding id if present in the collection
	 */
	@GetMapping(path = "/{orderId}")
	public Item getOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("orderId") String orderId) {
		return database.getItem(Integer.parseInt(orderId), ItemType.ORDER);
	}
	
	/**
	 * Creates a new element in the collection
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => POST 
	 * @return the new collection
	 */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item addOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Order order) {
		return database.addItem(order, ItemType.ORDER);
	}
	
	/**
	 * Substitutes the collection with a new one
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => PUT 
	 * @return the new collection
	 */
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<? extends Item> updateOrders(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Order> orders) {
		return database.replaceCollection(orders, ItemType.ORDER);
	}
	
	/**
	 * Substitutes the order with the corresponding id if is in the collection,
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => PUT 
	 * @return the modified collection
	 */
	@PutMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item updateOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("orderId") String orderId, @RequestBody Order order) {
		return database.replaceElement(Integer.parseInt(orderId), order, ItemType.ORDER);
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => DELETE
	 * @return an empty collection
	 */
	@DeleteMapping(path = "/")
	public List<? extends Item> deleteOrders(HttpServletRequest request, HttpServletResponse response) {
		return database.deleteCollection(ItemType.ORDER);
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => DELETE
	 * @return the modified collection
	 */
	@DeleteMapping(path = "/{orderId}")
	public List<? extends Item> deleteOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("orderId") String orderId) {
		return database.deleteItem(Integer.parseInt(orderId), ItemType.ORDER);
	}
}