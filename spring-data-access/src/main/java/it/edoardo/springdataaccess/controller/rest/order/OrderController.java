package it.edoardo.springdataaccess.controller.rest.order;

import java.util.List;

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

import it.edoardo.springdataaccess.dao.OrderService;
import it.edoardo.springdataaccess.model.Order;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired private OrderService connection;
	
	@GetMapping(path = "/")
	public List<Order> getOrders() {
		return this.connection.getOrders();
	}
	
	@GetMapping(path = "/{id}/")
	public Order getOrder(@PathVariable(name = "id") int id) {
		return this.connection.getOrder(id);
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order postOrder(@RequestBody Order order) {
		this.connection.addOrder(order);
		return order;
	}
	
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> putOrders(@RequestBody List<Order> orders) {
		this.connection.updateOrders(orders);
		return orders;
	}
	
	@PutMapping(path = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order putOrder(@PathVariable(name = "id") int id, @RequestBody Order order) {
		this.connection.updateOrder(id, order);
		return order;
	}
	
	@DeleteMapping(path = "/")
	public List<Order> deleteOrders() {
		this.connection.deleteOrders();
		return null;
	}
	
	@DeleteMapping(path = "/{id}/")
	public Order deleteOrder(@PathVariable(name = "id") int id) {
		this.connection.deleteOrder(id);
		return null;
	}
}
