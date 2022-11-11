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
	
	/**
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => GET
	 * @return all the element inside the collection 
	 */
	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProducts() {
		// TODO: modificare cosa viene restituito
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("There are ").
			append(this.database.getProducts().size()).
			append(" products").
			append("\n");
		this.database.getProducts().stream().forEach(strBuilder::append);
		return strBuilder.toString();
	}
	
	/**
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => GET
	 * @return the element with the corresponding id
	 */
	@GetMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getProduct(@PathVariable("productId") String productId) {
		// TODO: modificare cosa viene restituito
		final int productIndex = Integer.parseInt(productId);
		if(productIndex >= 0 && (productIndex < this.database.getProducts().size())) {
			return this.database.getProducts().get(productIndex).toString();
		}
		return "There is not any product with that id!";
	}
	
	/**
	 * Add a new product in the collectiom
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => POST
	 * @return the new collection
	 */
	@PostMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String addProduct() {
		// TODO: creare metodo per aggiungere un prodotto
		return null;
	}
	
	/**
	 * Replace the collection with a new one
	 * URL => http://localhost:8080/spring-web/products/
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProducts() {
		// TODO: creare metodo per modificare la collezione di prodotti
		return null;
	}
	
	/**
	 * Replace the element in the collection, or creates a new one
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => PUT
	 * @return the new collection
	 */
	@PutMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updateProduct(@PathVariable("productId") String productId) {
		// TODO: creare metodo per modificare un prodotto
		return null;
	}
	
	/**
	 * Delete all the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the empty collection
	 */
	@DeleteMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProducts() {
		// TODO: creare metodo per eliminare i prodotti
		return null;
	}
	
	/**
	 * Delete a product in the collection
	 * URL => http://localhost:8080/spring-web/products/:id
	 * METHOD => DELETE
	 * @return the new collection
	 */
	@DeleteMapping(path = "/{productId}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduct(@PathVariable("productId") String productId) {
		// TODO: creare metodo per eliminare un prodotto
		return productId;
	}
}
