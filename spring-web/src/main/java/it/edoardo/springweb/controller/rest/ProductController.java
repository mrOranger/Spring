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
import it.edoardo.springweb.info.JsonResponse;
import it.edoardo.springweb.model.Item;

@RestController @RequestMapping(path = "products/")
public class ProductController {
	
	@Autowired private Database database;
	
	/**
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => GET
	 * @return all the element inside the collection 
	 */
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProducts(HttpServletRequest request, HttpServletResponse response) {
		return new JsonResponse(database.getItems(ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => GET
	 * @return the element with the corresponding id
	 */
	@GetMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable("productId") String productId) {
		return new JsonResponse(database.getItem(Integer.parseInt(productId), ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * Add a new product in the collectiom
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody Item item) {
		return new JsonResponse(database.addItem(item, ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * Replace the collection with a new one
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProducts(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Item> items) {
		return new JsonResponse(database.replaceCollection(items, ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * Replace the element in the collection, or creates a new one
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProduct(HttpServletRequest request, HttpServletResponse response,  @RequestBody Item item) {
		return new JsonResponse(database.replaceElement(item, ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * Delete all the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProducts(HttpServletRequest request, HttpServletResponse response) {
		return new JsonResponse(database.deleteCollection(ItemType.PRODUCT)).toJson().toString();
	}
	
	/**
	 * Delete a product in the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the new collection
	 */
	@DeleteMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable("productId") String productId) {
		return new JsonResponse(database.deleteItem(Integer.parseInt(productId), ItemType.PRODUCT)).toJson().toString();
	}
}
