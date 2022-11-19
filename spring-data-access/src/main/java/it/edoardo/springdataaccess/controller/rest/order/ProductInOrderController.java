package it.edoardo.springdataaccess.controller.rest.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import it.edoardo.springdataaccess.model.Product;

@RestController
@RequestMapping(path = "/orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductInOrderController {
	
	@Autowired private OrderService orderService;
	
	@GetMapping(path = "/{orderId}/products/")
	public List<Product> getProducts(@PathVariable(value = "orderId") int orderId) {
		try {
			return this.orderService.getProducts(orderId);	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(path = "/{orderId}/products/{productId}")
	public Product getProduct(@PathVariable(value = "orderId") int orderId, 
			@PathVariable(value = "productId") int productId) {
		try {
			return this.orderService.getProduct(orderId, productId);	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(path = "/{orderId}/products/")
	public Product addProduct(@PathVariable(value = "orderId") int orderId, 
			@RequestBody Product product) {
		try {
			this.orderService.addProduct(orderId, product);
			return product;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping(path = "/{orderId}/products/")
	public List<Product> updateProducts(@PathVariable(value = "orderId") int orderId, 
			@RequestBody List<Product> products) {
		try {
			this.orderService.updateProducts(orderId, products);
			return products;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping(path = "/{orderId}/products/{productId}/")
	public Product updateProduct(@PathVariable(value = "orderId") int orderId, 
		@PathVariable(value = "productId") int productId,
		@RequestBody Product product) {
		try {
			this.orderService.updateProduct(orderId, productId, product);
			return product;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(path = "/{orderId}/products/")
	public List<Product> deleteProducts(@PathVariable(value = "orderId") int orderId) {
		try {
			this.orderService.deleteProducts(orderId);
			return null;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(path = "/{orderId}/products/{productId}/")
	public Product deleteProduct(@PathVariable(value = "orderId") int orderId, 
			@PathVariable(value = "productId") int productId) {
		try {
			this.orderService.deleteProduct(orderId, productId);
			return null;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
