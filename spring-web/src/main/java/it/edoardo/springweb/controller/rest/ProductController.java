package it.edoardo.springweb.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.database.ItemType;
import it.edoardo.springweb.model.Item;

@RestController @RequestMapping(path = "products/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired private Database database;
	
	/**
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => GET
	 * @return all the element inside the collection 
	 */
	@GetMapping(path = "/")
	public List<Item> getProducts(HttpServletRequest request, HttpServletResponse response) {
		return database.getItems(ItemType.PRODUCT);
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => GET
	 * @return the element with the corresponding id
	 */
	@GetMapping(path = "/{productId}")
	public Item getProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable("productId") String productId) {
		return database.getItem(Integer.parseInt(productId), ItemType.PRODUCT);
	}
	
	/**
	 * Add a new product in the collectiom
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item addProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody Item item) {
		return database.addItem(item, ItemType.PRODUCT);
	}
	
	/**
	 * Replace the collection with a new one
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> updateProducts(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Item> items) {
		return database.replaceCollection(items, ItemType.PRODUCT);
	}
	
	/**
	 * Replace the element in the collection, or creates a new one
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item updateProduct(HttpServletRequest request, HttpServletResponse response,  @RequestBody Item item) {
		return database.replaceElement(item, ItemType.PRODUCT);
	}
	
	/**
	 * Delete all the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the empty collection
	 */
	@DeleteMapping(path = "/")
	public List<Item> deleteProducts(HttpServletRequest request, HttpServletResponse response) {
		return database.deleteCollection(ItemType.PRODUCT);
	}
	
	/**
	 * Delete a product in the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the new collection
	 */
	@DeleteMapping(path = "/{productId}")
	public List<Item> deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable("productId") String productId) {
		return database.deleteItem(Integer.parseInt(productId), ItemType.PRODUCT);
	}
}
