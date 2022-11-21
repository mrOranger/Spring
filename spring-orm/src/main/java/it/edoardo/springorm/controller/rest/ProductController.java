package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springorm.model.Order;
import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.model.User;
import it.edoardo.springorm.repository.ProductRepository;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired private ProductRepository repository;
	
	/**
	 * 
	 * @return he submitted products in the database
	 */
	@GetMapping(path = "/")
	public List<Product> getProducts() {
		return null;
	}
	
	/**
	 * 
	 * @param id of the product to find
	 * @return the product identified by id
	 */
	@GetMapping(path = "/{id}/")
	public Product getProduct(@PathVariable(name = "id") int id) {
		return null;
	}
	
	/**
	 * 
	 * @param id of the product
	 * @return the list of the user who ordered the product identified by id
	 */
	@GetMapping(path = "/{id}/users/")
	public List<User> getUsers(@PathVariable(value = "id") int id) {
		return null;
	}
	
	/**
	 * 
	 * @param id of the product
	 * @return the list of the orders containing the product identified by id
	 */
	@GetMapping(path = "/{id}/orders/")
	public List<Order> getOrders(@PathVariable(name = "id") int id) {
		return null;
	}
	
	/**
	 * 
	 * @param productId of the product to find
	 * @param userId of the user who ordered the product
	 * @return the user identified with id, who ordered the product identified by id
	 */
	@GetMapping(path = "/{productId}/users/{userId}/")
	public User getUser(@PathVariable(value = "productId") int productId, @PathVariable(value = "userId") int userId) {
		return null;
	}
	
	/**
	 * 
	 * @param productId of the product to find
	 * @param orderId of the order containing the product
	 * @return the order identified by orderId, which contains the product identified by productId
	 */
	@GetMapping(path = "/{productId}/orders/{orderId}/")
	public Order getOrder(int productId, int orderId) {
		return null;
	}
}
