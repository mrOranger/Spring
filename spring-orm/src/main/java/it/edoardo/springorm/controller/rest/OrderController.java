package it.edoardo.springorm.controller.rest;

import java.util.List;

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
	
	public List<Order> getOrders() {
		return this.repository.findAll();
	}
	
	public Order gerOrder(int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public List<Order> getOrdersByUser(int id) {
		return this.repository.findAllByCustomer(id);
	}
	
	public List<Order> getOrdersByProduct(int id) {
		return this.repository.findAllByProduct(id);
	}
	
	public Order getOrderByProduct(int product, int order) {
		return this.repository.findByProduct(product, order).orElse(null);
	}
	
	public Order postOrder(Order order) {
		this.repository.save(order);
		return order;
	}
	
	public Order postProductInOrder(int order, Product product) {
		final Order currOrder = this.repository.getReferenceById(order);
		currOrder.getProducts().add(product);
		this.repository.save(currOrder);
		return currOrder;
	}
	
	public List<Order> putOrders(List<Order> orders) {
		orders.stream().forEach((order) -> this.putOrder(order.getId(), order));
		return orders;
	}
	
	public Order putOrder(int id, Order order) {
		if(this.repository.findById(id).isPresent())  {
			final Order orderToUpdate = this.repository.getReferenceById(id);
			orderToUpdate.setId(id);
			orderToUpdate.setCustomer(order.getCustomer());
			orderToUpdate.setProducts(order.getProducts());
			return this.repository.save(orderToUpdate);
		}
		return this.repository.save(order);
	}
	
	public Order putProductInOrder(int orderId, int prodId, Product product) {
		final Order currOrder = this.repository.getReferenceById(orderId);
		if(currOrder.getProducts().contains(product)) {
			currOrder.getProducts().set(currOrder.getProducts().indexOf(product), product);
		} else {
			currOrder.getProducts().add(product);
		}
		return currOrder;
	}
	
	public void deleteOrders() {
		this.repository.deleteAll();
	}
	
	public void deleteOrder(int id) {
		this.repository.deleteById(id);
	}

	public void deleteProductsFromOrders() {
		this.repository.deleteAllProductsFromOrders();
	}
	
	public void deleteProductsFromOrder(int id) {
		this.repository.deleteAllProductsFromOrder(id);
	}
	
	public void deleteProductFromOrder(int order, int product) {
		this.repository.deleteProductFromOrder(order, product);
	}
}
