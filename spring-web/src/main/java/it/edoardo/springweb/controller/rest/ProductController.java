package it.edoardo.springweb.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springweb.database.Database;

@RestController @RequestMapping(path = "products/")
public class ProductController {
	
	@Autowired private Database database;
	
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProducts() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("There are ").append(this.database.getProducts().size()).append(" products");
		this.database.getProducts().stream().forEach(strBuilder::append);
		return strBuilder.toString();
	}
	
	@GetMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProduct(@PathVariable("productId") String productId) {
		final int productIndex = Integer.parseInt(productId);
		if(productIndex > 0 && (productIndex < this.database.getProducts().size())) {
			return this.database.getProducts().get(productIndex).toString();
		}
		return "There is not any product with that id!";
	}
	
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addProduct() {
		return null;
	}
	
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProduct() {
		return null;
	}
	
	@DeleteMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduct(@PathVariable("productId") String productId) {
		return productId;
	}
}
