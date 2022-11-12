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
import it.edoardo.springweb.info.JsonResponse;

@RestController @RequestMapping(path = "orders/")
public class OrderController {
	
	@Autowired private Database database;
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => GET 
	 * @return the list of the orders of the collection
	 */
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrders() {
		return new JsonResponse(database.getOrders()).toJson().toString();
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => GET 
	 * @return the order with the corresponding id if present in the collection
	 */
	@GetMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getOrder(@PathVariable("orderId") String orderId) {
		return new JsonResponse(database.getOrder(Integer.parseInt(orderId))).toJson().toString();
	}
	
	/**
	 * Creates a new element in the collection
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => POST 
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addOrder() {
		// TODO: Creare metodo per aggiungere un ordine
		return null;
	}
	
	/**
	 * Substitutes the collection with a new one
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => PUT 
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrders() {
		// TODO: creare metodo per sostituire una collezione di ordini
		return null;
	}
	
	/**
	 * Substitutes the order with the corresponding id if is in the collection,
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => PUT 
	 * @return the modified collection
	 */
	@PutMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateOrder(@PathVariable("orderId") String orderId) {
		// TODO: creare un metodo per sostituire un ordine
		return null;
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/
	 * METHOD => DELETE
	 * @return an empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrders() {
		// TODO: creare un metodo per eliminare gli ordini
		return null;
	}
	
	/**
	 * Deletes the element in the collection
	 * otherwise creates a new one.
	 * URL => http://localhost:8080/spring-web/orders/:id
	 * METHOD => DELETE
	 * @return the modified collection
	 */
	@DeleteMapping(path = "/{orderId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteOrder(@PathVariable("orderId") String orderId) {
		// TODO: creare un metodo per eliminare un ordine
		return orderId;
	}
}