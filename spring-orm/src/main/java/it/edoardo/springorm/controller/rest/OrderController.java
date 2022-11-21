package it.edoardo.springorm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	public List<Order> getOrders() {
		return null;
	}
	
	public Order getOrder(int id) {
		return null;
	}
	
	public List<User> getUsers(int id) {
		return null;
	}
	
	public List<Product> getProducts(int id) {
		return null;
	}
	
	public Product getProduct(int orderId, int productId) {
		return null;
	}

}
