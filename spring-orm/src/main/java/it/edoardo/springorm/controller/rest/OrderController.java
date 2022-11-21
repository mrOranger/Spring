package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springorm.model.Order;
import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.model.User;
import it.edoardo.springorm.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired private OrderRepository repository;
	
	/**
	 * 
	 * @return the list of the order submitted in the database
	 */
	@GetMapping(path = "/")
	public List<Order> getOrders() {
		return Lists.newArrayList(this.repository.findAll().iterator());
	}
	
	/**
	 * 
	 * @param id of the order to retrieve
	 * @return the order identified with the id
	 */
	@GetMapping(path = "/{id}/")
	public Order getOrder(@PathVariable(value = "id") int id) {
		return this.repository.findById(id).get();
	}
	
	/**
	 * 
	 * @param id of the order to retrieve
	 * @return the user who made the order identified by id
	 */
	@GetMapping(path = "/{id}/users/")
	public User getUser(@PathVariable(value = "id") int id) {
		return null;
	}
	
	/**
	 * 
	 * @param id of the order
	 * @return the list of the products inside the order identified by id
	 */
	@GetMapping(path = "/{id}/products/")
	public List<Product> getProducts(@PathVariable(value = "id") int id) {
		return null;
	}
	
	/**
	 * 
	 * @param orderId of the order to retrieve
	 * @param productId of the product to retrieve
	 * @return the product identified by productId, inside the order identified by orderId
	 */
	@GetMapping(path = "/{orderId}/products/{productId}/")
	public Product getProduct(@PathVariable(value = "orderId") int orderId, @PathVariable(value = "productId") int productId) {
		return null;
	}
	
	/**
	 * 
	 * @param order to add in the database
	 * @return the new order insert in the database
	 */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order postUser(@RequestBody Order order) {
		return this.repository.save(order);
	}

}
