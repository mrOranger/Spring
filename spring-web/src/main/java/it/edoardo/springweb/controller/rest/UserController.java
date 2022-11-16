package it.edoardo.springweb.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.database.ItemType;
import it.edoardo.springweb.model.Item;

@RestController 
@RequestMapping(path = "users/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired private Database database;
	
	/**
	 * Returns all the users in the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => GET
	 * @return the collection of users
	 */
	@GetMapping(path = "/")
	public List<Item> getUsers(HttpServletRequest request, HttpServletResponse response) {
		return database.getItems(ItemType.USER);
	}
	
	/**
	 * Returns the user identified with the id
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => GET
	 * @return the user if present
	 */
	@GetMapping(path = "/{userId}")
	public Item getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") String userId) {
		return database.getItem(Integer.parseInt(userId), ItemType.USER);
	}
	
	/**
	 * Add a new user in the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item addUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Item user) {
		return database.addItem(user, ItemType.USER);
	}
	
	/**
	 * Replace the collection with a new one
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> updateUsers(HttpServletRequest request, HttpServletResponse response, @ModelAttribute List<Item> items) {
		return database.replaceCollection(items, ItemType.USER);
	}

	/**
	 * Replace the user in the collection with a new one
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Item updateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Item item) {
		return database.replaceElement(item, ItemType.USER);
	}

	/**
	 * Delete all the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => DELETE
	 * @return the empty collection
	 */
	@DeleteMapping(path = "/")
	public List<Item> deleteUsers(HttpServletRequest request, HttpServletResponse response) {
		return database.deleteCollection(ItemType.USER);
	}
	
	/**
	 * Delete the user in the collection
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => DELETE
	 * @return the new collection
	 */	
	@DeleteMapping(path = "/{userId}")
	public List<Item> deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") String userId) {
		return database.deleteItem(Integer.parseInt(userId), ItemType.USER);
	}
}
