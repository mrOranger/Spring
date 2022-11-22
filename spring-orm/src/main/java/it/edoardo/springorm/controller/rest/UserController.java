package it.edoardo.springorm.controller.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.springorm.model.User;
import it.edoardo.springorm.repository.UserRepository;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired private UserRepository repository;
	
	/**
	 * @return all the submitted users
	 */
	@GetMapping(path = "/")
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	/**
	 * @param id of the user
	 * @return the user identified by that id
	 */
	@GetMapping(path = "/{id}/")
	public User getUser(@PathVariable(name = "id") int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	/**
	 * 
	 * @param taxCode of the user to get
	 * @return the removed user
	 */
	@GetMapping(path = "/taxCode/{taxCode}/")
	public User getUserByTaxCode(@PathVariable(name = "taxCode") String taxCode) {
		return this.repository.findByTaxCode(taxCode).orElse(null);
	}
	
	/**
	 * @param startDate greater or equal the user's date of birth
	 * @param endDate less then or equal to the user's date of birth
	 * @return the users with date of birth between these two dates
	 */
	@GetMapping(path = "/date/{start}/{end}/")
	public List<User> getUsersByDate(@PathVariable(name = "start") String start, @PathVariable(name = "end") String end) {
		return this.repository.findAllByDateOfBirthBetween(LocalDate.parse(start), LocalDate.parse(end));
	}
	
	/**
	 * @param user to add in the database
	 * @return the new user insert in the database
	 */
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User postUser(@RequestBody User user) {
		return this.repository.save(user);
	}
	
	/**
	 * @param users submitted in the database
	 * @return the new modified users
	 */
	@PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<User> putUsers(@RequestBody List<User> users) {
		users.stream().forEach((user) -> this.putUser(user.getId(), user));
		return users;
	}
	
	/**
	 * @param id of the user to modify
	 * @param user values to modify
	 * @return the modified user
	 */
	@PutMapping(path = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE) @Transactional
	public User putUser(@PathVariable(value = "id") int id, @RequestBody User user) {
		final User userToUpdate = this.repository.getReferenceById(id);
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setDateOfBirth(user.getDateOfBirth());
		userToUpdate.setTaxCode(user.getTaxCode());
		return this.repository.save(userToUpdate);
	}
	
	/**
	 * @return the empty collection of users
	 */
	@DeleteMapping(path = "/")
	public List<User> deleteUsers(){
		this.repository.deleteAll();
		return this.repository.findAll();
	}
	
	/**
	 * @return the removed user
	 */
	@DeleteMapping(path = "/{id}/")
	public User deleteUser(@PathVariable(name = "id") int id){
		final User user = this.repository.findById(id).get();
		this.repository.deleteById(id);
		return user;
	}
	
	/**
	 * 
	 * @param taxCode of the user to remove
	 * @return the user removed from the collection
	 */
	@DeleteMapping(path = "/taxCode/{taxCode}/") @Transactional
	public User deleteUserByTaxCode(@PathVariable(name = "taxCode") String taxCode){
		Optional<User> user = this.repository.findByTaxCode(taxCode);
		user.ifPresent((u) -> this.repository.deleteByTaxCode(taxCode));
		return user.orElse(null);
	}
	

	/**
	 * 
	 * @param start date from delete the user
	 * @param end date from delete the user
	 * @return the new collection with removed users
	 */
	@DeleteMapping(path = "/date/{start}/{end}/")
	public List<User> deleteUsersByDate(
			@PathVariable(name = "start") String start, 
			@PathVariable(name = "end") String end){
		List<User> users = this.repository.findAllByDateOfBirthBetween(LocalDate.parse(start), LocalDate.parse(end));
		this.repository.deleteAllByDateOfBirthBetween(LocalDate.parse(start), LocalDate.parse(end));
		return users;
	}
}
