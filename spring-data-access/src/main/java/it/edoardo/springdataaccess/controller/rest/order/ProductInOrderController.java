package it.edoardo.springdataaccess.controller.rest.order;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springdataaccess.model.Product;

@RestController
@RequestMapping(path = "/orders/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductInOrderController {
	
	@GetMapping(path = "/{orderId}/products/")
	public List<Product> getProducts(@PathVariable(value = "orderId") int orderId) {
		return null;
	}
	
	@GetMapping(path = "/{orderId}/products/{productId}")
	public Product getProduct(@PathVariable(value = "orderId") int orderId, 
			@PathVariable(value = "productId") int productId) {
		return null;
	}
	
	@PostMapping(path = "/{orderId}/products/")
	public Product addProduct(@PathVariable(value = "orderId") int orderId, 
			@RequestBody Product product) {
		return null;
	}
	
	@PutMapping(path = "/{orderId}/products/")
	public List<Product> updateProducts(@PathVariable(value = "orderId") int orderId, 
			@RequestBody List<Product> products) {
		return null;
	}
	
	@PutMapping(path = "/{orderId}/products/{productId}/")
	public Product updateProduct(@PathVariable(value = "orderId") int orderId, 
		@PathVariable(value = "productId") int productId,
		@RequestBody Product product) {
		return null;
	}
	
	@DeleteMapping(path = "/{orderId}/products/")
	public List<Product> deleteProducts(@PathVariable(value = "orderId") int orderId) {
		return null;
	}
	
	@DeleteMapping(path = "/{orderId}/products/{productId}/")
	public Product deleteProduct(@PathVariable(value = "orderId") int orderId, 
			@PathVariable(value = "productId") int productId) {
		return null;
	}
}
