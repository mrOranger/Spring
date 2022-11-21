package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springorm.model.Order;
import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.model.User;
import it.edoardo.springorm.repository.UserRepository;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired private UserRepository repository;
	
	/**
	 * @return all the submitted users
	 */
	@GetMapping(path = "/")
	public List<User> getUsers() {
		return Lists.newArrayList(repository.findAll().iterator());
	}
	
	/**
	 * 
	 * @param id of the user
	 * @return the user identified by that id
	 */
	@GetMapping(path = "/{id}/")
	public User getUser(@PathVariable(name = "id") int id) {
		return this.repository.findById(id).get();
	}
	
	/**
	 * 
	 * @param id of the user 
	 * @return the products ordered by the user with that id
	 */
	@GetMapping(path = "/{id}/products/")
	public List<Product> getProducts(@PathVariable(name = "id")int id) {
		return null;
	}
	
	/**
	 * 
	 * @param id of the user
	 * @return all the orders made by the user with that id
	 */
	@GetMapping(path = "/{id}/orders/")
	public List<Order> getOrders(@PathVariable(name = "id") int id) {
		return null;
	}
	
	/**
	 * @param userId of the user
	 * @param productId of the product
	 * @return the product identified with that id, ordered by the user with userId
	 */
	@GetMapping(path = "/{userId}/products/{productId}")
	public Product getProduct(@PathVariable(name = "userId") int userId, @PathVariable(name = "productId") int productId) {
		return null;
	}

}
