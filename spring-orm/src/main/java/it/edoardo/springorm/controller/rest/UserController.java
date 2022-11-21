package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	public List<User> getUsers() {
		return null;
	}
	
	public User getUser(int id) {
		return null;
	}
	
	public List<Product> getProducts(int id) {
		return null;
	}
	
	public List<Order> getOrders(int id) {
		return null;
	}
	
	public Order getOrder(int userId, int orderId) {
		return null;
	}
	
	public Product getProduct(int userId, int productId) {
		return null;
	}

}
