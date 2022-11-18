package it.edoardo.springdataaccess.controller.rest.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springdataaccess.dao.ProductService;
import it.edoardo.springdataaccess.model.Product;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired private ProductService productService; 
	
	@GetMapping(path = "/")
	public List<Product> getProducts() {
		try {
			return this.productService.getProducts();	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(path = "/{id}/")
	public Product getProduct(@PathVariable(value = "id") int id) {
		try {
			return this.productService.getProduct(id);
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product product) {
		try {
			this.productService.addProduct(product);
			return product;
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> updateProducts(@RequestBody List<Product> products) {
		try {
			this.productService.updateProducts(products);
			return products;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping(path = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
		try {
			this.productService.updateProduct(id, product);
			return product;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(path = "/")
	public List<Product> deleteUsers() {
		try {
			this.productService.deleteProducts();
			return null;	
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(path = "/{id}/")
	public Product deleteUser(@PathVariable(name = "id") int id) {
		try {
			this.productService.deleteProduct(id);
		} catch(DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
