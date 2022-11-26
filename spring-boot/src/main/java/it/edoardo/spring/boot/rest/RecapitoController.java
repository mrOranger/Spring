package it.edoardo.spring.boot.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.edoardo.spring.boot.dao.impl.RecapitoService;
import it.edoardo.spring.boot.model.Recapito;

public class RecapitoController {

	@Autowired
	private RecapitoService service;

	public ResponseEntity<List<Recapito>> getRecapiti() {
		return returnResponseEntityCollection(this.service.getRecapiti());
	}

	public ResponseEntity<Recapito> getRecapito(int id) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapito(id), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<List<Recapito>> getRecapitoOfImpiegato(int id) {
		return returnResponseEntityCollection(this.service.getRecapitoOfImpiegato(id));
	}

	public ResponseEntity<Recapito> getRecapitoByEmail(String email) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapitoByEmail(email), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Recapito> getRecapitoByTelefono(String telefono) {
		try {
			return new ResponseEntity<Recapito>(this.service.getRecapitoByTelefono(telefono), HttpStatus.OK);			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Recapito>((Recapito)null, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<List<Recapito>> getRecapitiByProvider(String provider) {
		return returnResponseEntityCollection(this.service.getRecapitiByProvider(provider));
	}

	public ResponseEntity<List<Recapito>> getRecapitiByDipartimento(int id) {
		return returnResponseEntityCollection(this.service.getRecapitiByDipartimento(id));
	}

	public ResponseEntity<List<Recapito>> getRecapitiOfDirigenti() {
		return returnResponseEntityCollection(this.service.getRecapitiOfDirigenti());
	}

	public ResponseEntity<List<Recapito>> getRecapitiOfDirigente(int id) {
		return returnResponseEntityCollection(this.service.getRecapitiOfDirigente(id));
	}

	public ResponseEntity<Recapito> postRecapito(Recapito recapito) {
		return new ResponseEntity<Recapito>(this.service.postRecapito(recapito), HttpStatus.OK);
	}

	public ResponseEntity<List<Recapito>> putRecapiti(Iterable<Recapito> recapiti) {
		return new ResponseEntity<List<Recapito>>(this.service.putRecapiti(recapiti), HttpStatus.OK);
	}

	public ResponseEntity<Recapito> putRecapito(int id, Recapito recapito) {
		return new ResponseEntity<Recapito>(this.service.putRecapito(id, recapito), HttpStatus.OK);
	}

	public void deleteRecapiti() {
		this.service.deleteRecapiti();
	}

	public void deleteRecapito(int id) {
		try {
			this.service.deleteRecapito(id);	
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void deleteRecapitiOfImpiegato(int id) {
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
