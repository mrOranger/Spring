package it.edoardo.springweb.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@RestController @RequestMapping(path = "users/")
public class UserController {
	
	@Autowired private Database database;
	
	/**
	 * Returns all the users in the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => GET
	 * @return the collection of users
	 */
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUsers(HttpServletRequest request, HttpServletResponse response) {
		return new JsonResponse(database.getUsers()).toJson().toString();
	}
	
	/**
	 * Returns the user identified with the id
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => GET
	 * @return the user if present
	 */
	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") String userId) {
		return new JsonResponse(database.getUser(Integer.parseInt(userId))).toJson().toString();
	}
	
	/**
	 * Add a new user in the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO: creare un metodo per aggiungere un utente
		return null;
	}
	
	/**
	 * Replace the collection with a new one
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateUsers(HttpServletRequest request, HttpServletResponse response) {
		// TODO: creare un metodo per sostituire la collezione di utenti
		return null;
	}

	/**
	 * Replace the user in the collection with a new one
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") String userId) {
		// TODO: creare un metodo per sostituire un utente
		return null;
	}

	/**
	 * Delete all the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => DELETE
	 * @return the empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUsers(HttpServletRequest request, HttpServletResponse response) {
		// TODO: creare un metodo per eliminare la collezione di utentei
		return null;
	}
	
	/**
	 * Delete the user in the collection
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => DELETE
	 * @return the new collection
	 */	
	@DeleteMapping(path = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("userId") String userId) {
		// TODO: creare un metodo per eliminare un utente
		return userId;
	}
}
