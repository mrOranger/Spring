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

//TODO: modify methods with @RequestBody
@RestController @RequestMapping(path = "orders/")
public class OrderController {
	
	@Autowired private Database database;
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => GET 
	 * @return the list of the orders of the collection
	 */
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrders(HttpServletRequest request, HttpServletResponse response) {
		return new JsonResponse(database.getItems(ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => GET 
	 * @return the order with the corresponding id if present in the collection
	 */
	@GetMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("orderId") String orderId) {
		return new JsonResponse(database.getItem(Integer.parseInt(orderId), ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * Creates a new element in the collection
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => POST 
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Item item) {
		return new JsonResponse(database.addItem(item, ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * Substitutes the collection with a new one
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => PUT 
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrders(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Item> items) {
		return new JsonResponse(database.replaceCollection(items, ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * Substitutes the order with the corresponding id if is in the collection,
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => PUT 
	 * @return the modified collection
	 */
	@PutMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Item item) {
		return new JsonResponse(database.replaceElement(item, ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => DELETE
	 * @return an empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrders(HttpServletRequest request, HttpServletResponse response) {
		return new JsonResponse(database.deleteCollection(ItemType.ORDER)).toJson().toString();
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => DELETE
	 * @return the modified collection
	 */
	@DeleteMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("orderId") String orderId) {
		return new JsonResponse(database.deleteItem(Integer.parseInt(orderId), ItemType.ORDER)).toJson().toString();
	}
}