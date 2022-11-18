package it.edoardo.springdataaccess.controller.rest.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
