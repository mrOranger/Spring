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

import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.repository.ProductRepository;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired private ProductRepository repository;
	
	/**
	 * 
	 * @return he submitted products in the database
	 */
	@GetMapping(path = "/") @Transactional
	public List<Product> getProducts() {
		return this.repository.findAll();
	}
	
	/**
	 * 
	 * @param id of the product to find
	 * @return the product identified by id
	 */
	@GetMapping(path = "/{id}/") @Transactional
	public Product getProduct(@PathVariable(name = "id") int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/users/{id}/") @Transactional
	public List<Product> getProductsOrederedByUser(@PathVariable(value = "id") int id) {
		return this.repository.findAllProductsOrderedByUser(id);
	}
	
	@GetMapping(path = "/orders/{id}/") @Transactional
	public List<Product> getProductsInOrder(@PathVariable(value = "id") int id) {
		return this.repository.findAllProductsInOrder(id);
	}
	
	@GetMapping(path = "/{product}/users/{user}/") @Transactional
	public Product getProductOrderedByUser(@PathVariable(value = "product") int product, @PathVariable(value = "user") int user) {
		return this.repository.findByIdAndUser(product, user).orElse(null);
	}
	
	@GetMapping(path = "/{product}/orders/{order}/") @Transactional
	public Product getProductInOrder(@PathVariable(value = "product") int product, @PathVariable(value = "order") int order) {
		return this.repository.findByIdAndOrder(product, order).orElse(null);
	}
	
	@GetMapping(path = "/price/less/{price}") @Transactional
	public List<Product> getProductsWithPriceLessThan(@PathVariable(value = "price") double price) {
		return this.repository.findAllByPriceLessThanEqual(price);
	}
	
	@GetMapping(path = "/price/greater/{price}") @Transactional
	public List<Product> getProductsWithPriceGreaterThan(@PathVariable(value = "price") double price) {
		return this.repository.findAllByPriceGreaterThanEqual(price);
	}
	
	@GetMapping(path = "/price/{start}/{end}") @Transactional
	public List<Product> getProductsWithPriceBetween(@PathVariable(value = "start") double start, @PathVariable(value = "end") double end) {
		return this.repository.findAllByPriceBetween(start, end);
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE) @Transactional
	public Product postProduct(@RequestBody Product product) {
		return this.repository.save(product);
	}
	
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE) @Transactional
	public List<Product> putProducts(@RequestBody List<Product> products) {
		products.stream().forEach((pro) -> this.putProduct(pro.getId(), pro));
		return products;
	}
	
	@PutMapping(path = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE) @Transactional
	public Product putProduct(@PathVariable(value = "id") int id, @RequestBody Product product) {
		if(this.repository.findById(id).isPresent())  {
			final Product productToUpdate = this.repository.getReferenceById(id);
			productToUpdate.setId(id);
			productToUpdate.setName(product.getName());
			productToUpdate.setPrice(product.getPrice());
			return this.repository.save(productToUpdate);
		}
		return this.repository.save(product);
	}
	
	@DeleteMapping(path = "/") @Transactional
	public void deleteProducts()  {
		this.repository.detachProducts();
		this.repository.deleteAll();
	}
	
	@DeleteMapping(path = "/{id}/") @Transactional
	public void deleteProduct(@PathVariable(value = "id") int id) {
		this.repository.detachProduct(id);
		this.repository.deleteById(id);
	}
	
}
