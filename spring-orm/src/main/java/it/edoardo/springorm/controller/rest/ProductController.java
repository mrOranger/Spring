package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	public List<Product> getProducts() {
		return null;
	}
	
	public Product getProduct(int id) {
		return null;
	}
	
	public List<User> getUsers(int id) {
		return null;
	}
	
	public List<Order> getOrders(int id) {
		return null;
	}
	
	public User getUser(int productId, int userId) {
		return null;
	}
	
	public Order getOrder(int productId, int orderId) {
		return null;
	}

}
