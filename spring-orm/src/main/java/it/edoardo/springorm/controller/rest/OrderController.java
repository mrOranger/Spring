package it.edoardo.springorm.controller.rest;

import java.util.List;

import javax.transaction.Transactional;

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

import it.edoardo.springorm.model.Order;
import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired private OrderRepository repository;
	
	@GetMapping(path = "/") @Transactional
	public List<Order> getOrders() {
		return this.repository.findAll();
	}
	
	@GetMapping(path = "/{id}/") @Transactional
	public Order gerOrder(@PathVariable(value = "id") int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/users/{id}/") @Transactional
	public List<Order> getOrdersByUser(@PathVariable(value = "id") int id) {
		return this.repository.findAllByCustomer(id);
	}
	
	@GetMapping(path = "/products/{id}/") @Transactional
	public List<Order> getOrdersByProduct(@PathVariable(value = "id") int id) {
		return this.repository.findAllByProduct(id);
	}
	
	@GetMapping(path = "/{order}/products/{product}/") @Transactional
	public Order getOrderByProduct(@PathVariable(value = "product") int product, @PathVariable(value = "order") int order) {
		return this.repository.findByProduct(product, order).orElse(null);
	}
	
	@PostMapping(path = "/") @Transactional
	public Order postOrder(@RequestBody Order order) {
		this.repository.save(order);
		this.repository.flush();
		return order;
	}
	
	@PostMapping(path = "/{order}/products/{product}/") @Transactional
	public Order postProductInOrder(@PathVariable(value = "order") int order, @PathVariable(value = "product") int product) {
		this.repository.saveProductInOrder(order, product);
		return this.repository.findById(order).orElse(null);
	}
	
	@PutMapping(path = "/") @Transactional
	public List<Order> putOrders(@RequestBody List<Order> orders) {
		orders.stream().forEach((order) -> this.putOrder(order.getId(), order));
		this.repository.flush();
		return orders;
	}
	
	@PutMapping(path = "/{id}/") @Transactional
	public Order putOrder(@PathVariable(value = "id") int id, @RequestBody Order order) {
		if(this.repository.findById(id).isPresent())  {
			final Order orderToUpdate = this.repository.findById(id).get();
			orderToUpdate.setId(id);
			orderToUpdate.setCustomer(order.getCustomer());
			orderToUpdate.setProducts(order.getProducts());
			this.repository.flush();
			return this.repository.save(orderToUpdate);
		}
		this.repository.flush();
		return this.repository.save(order);
	}
	
	@PutMapping(path = "/orders/{orderId}/products/{prodId}/") @Transactional
	public Order putProductInOrder(@PathVariable(value = "orderId") int orderId, @PathVariable(value = "prodId") int prodId, @RequestBody Product product) {
		final Order currOrder = this.repository.findById(orderId).get();
		if(currOrder.getProducts().contains(product)) {
			currOrder.getProducts().set(currOrder.getProducts().indexOf(product), product);
		} else {
			currOrder.getProducts().add(product);
		}
		this.repository.flush();
		return currOrder;
	}
	
	@DeleteMapping(path = "/") @Transactional
	public void deleteOrders() {
		this.repository.deleteAllProductsFromOrders();
		this.repository.deleteAll();
		this.repository.flush();
	}
	
	@DeleteMapping(path = "/{id}/") @Transactional
	public void deleteOrder(@PathVariable(value = "id") int id) {
		this.repository.deleteAllProductsFromOrder(id);
		this.repository.deleteById(id);
		this.repository.flush();
	}

	@DeleteMapping(path = "/products/") @Transactional
	public void deleteProductsFromOrders() {
		this.repository.deleteAllProductsFromOrders();
		this.repository.flush();
	}
	
	@DeleteMapping(path = "/{id}/products/") @Transactional
	public void deleteProductsFromOrder(@PathVariable(value = "id") int id) {
		this.repository.deleteAllProductsFromOrder(id);
		this.repository.flush();
	}
	
	@DeleteMapping(path = "/{order}/products/{product}/") @Transactional
	public void deleteProductFromOrder(@PathVariable(value = "order") int order, @PathVariable(value = "product") int product) {
		this.repository.deleteProductFromOrder(order, product);
		this.repository.flush();
	}
}
