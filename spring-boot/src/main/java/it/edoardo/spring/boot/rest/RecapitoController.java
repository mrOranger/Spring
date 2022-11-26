package it.edoardo.spring.boot.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.RecapitoService;
import it.edoardo.spring.boot.model.Recapito;

@RestController @RequestMapping(path = "/recapiti")
public class RecapitoController {

	@Autowired
	private RecapitoService service;

	@GetMapping(path = "/")
	public ResponseEntity<List<Recapito>> getRecapiti() {
		return returnResponseEntityCollection(this.service.getRecapiti());
	}

	@GetMapping(path = "/{id}/")
	public ResponseEntity<Recapito> getRecapito(@PathVariable int id) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapito(id), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/impiegato/{id}/")
	public ResponseEntity<List<Recapito>> getRecapitoOfImpiegato(@PathVariable int id) {
		return returnResponseEntityCollection(this.service.getRecapitoOfImpiegato(id));
	}

	@GetMapping(path = "/email/{email}/")
	public ResponseEntity<Recapito> getRecapitoByEmail(@PathVariable String email) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapitoByEmail(email), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/telefono/{telefono}/")
	public ResponseEntity<Recapito> getRecapitoByTelefono(@PathVariable String telefono) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapitoByTelefono(telefono), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/email/provider/{provider}/")
	public ResponseEntity<List<Recapito>> getRecapitiByProvider(@PathVariable String provider) {
		return returnResponseEntityCollection(this.service.getRecapitiByProvider(provider));
	}

	@GetMapping(path = "/dipartimento/{id}/")
	public ResponseEntity<List<Recapito>> getRecapitiByDipartimento(@PathVariable int id) {
		return returnResponseEntityCollection(this.service.getRecapitiByDipartimento(id));
	}

	@GetMapping(path = "/dirigenti/")
	public ResponseEntity<List<Recapito>> getRecapitiOfDirigenti() {
		return returnResponseEntityCollection(this.service.getRecapitiOfDirigenti());
	}

	@GetMapping(path = "/dirigente/{id}/")
	public ResponseEntity<List<Recapito>> getRecapitiOfDirigente(@PathVariable int id) {
		return returnResponseEntityCollection(this.service.getRecapitiOfDirigente(id));
	}

	@PostMapping(path = "/")
	public ResponseEntity<Recapito> postRecapito(Recapito recapito) {
		return new ResponseEntity<Recapito>(this.service.postRecapito(recapito), HttpStatus.OK);
	}

	@PutMapping(path = "/")
	public ResponseEntity<List<Recapito>> putRecapiti(@RequestBody Iterable<Recapito> recapiti) {
		return new ResponseEntity<List<Recapito>>(this.service.putRecapiti(recapiti), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}/")
	public ResponseEntity<Recapito> putRecapito(@PathVariable int id, @RequestBody Recapito recapito) {
		return new ResponseEntity<Recapito>(this.service.putRecapito(id, recapito), HttpStatus.OK);
	}

	@DeleteMapping(path = "/")
	public void deleteRecapiti() {
		this.service.deleteRecapiti();
	}

	@DeleteMapping(path = "/{id}/")
	public void deleteRecapito(@PathVariable int id) {
		try {
			this.service.deleteRecapito(id);	
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping(path = "/impiegato/{id}/")
	public void deleteRecapitiOfImpiegato(@PathVariable int id) {
		try {
			this.service.deleteRecapitiOfImpiegato(id);	
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	private ResponseEntity<List<Recapito>> returnResponseEntityCollection(List<Recapito> recapiti) {
		if(recapiti.size() > 0) {
			return new ResponseEntity<List<Recapito>>(recapiti, HttpStatus.OK);
		}
		return new ResponseEntity<List<Recapito>>(recapiti, HttpStatus.NO_CONTENT);
	}
}
