package it.edoardo.springweb.controller.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.info.HttpResponseMessage;

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
	public JSONObject getUsers() {
		final JSONArray json = database.getUsers();
		if(!json.equals(null)) {
			final HttpResponseMessage message = new HttpResponseMessage(
					"Users in the collection", json, HttpStatus.OK);
			return message.toJson();
		}
		return new HttpResponseMessage("Empty collection", new JSONArray(), HttpStatus.OK).toJson();
	}
	
	/**
	 * Returns the user identified with the id
	 * URL => http://localhost:8080/spring-web/users/:id
	 * METHOD => GET
	 * @return the user if present
	 */
	@GetMapping(path = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getUser(@PathVariable("userId") String userId) {
		return null;
	}
	
	/**
	 * Add a new user in the collection
	 * URL => http://localhost:8080/spring-web/users/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addUser() {
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
	public String updateUsers() {
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
	public String updateUser(@PathVariable("userId") String userId) {
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
	public String deleteUsers() {
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
	public String deleteUser(@PathVariable("userId") String userId) {
		// TODO: creare un metodo per eliminare un utente
		return userId;
	}
}
