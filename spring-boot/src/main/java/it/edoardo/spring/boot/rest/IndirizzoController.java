package it.edoardo.spring.boot.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.IndirizzoService;
import it.edoardo.spring.boot.model.Indirizzo;

@RestController @RequestMapping(path = "/indirizzi")
public class IndirizzoController {
	
	@Autowired private IndirizzoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Indirizzo>> getIndirizzi() {
		if(this.service.getIndirizzi().size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizzi(), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizzi(), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/{id}/")
	public ResponseEntity<Indirizzo> getIndirizzo(@PathVariable int id) {
		try {
			return new ResponseEntity<Indirizzo>(this.service.getIndirizzo(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Indirizzo>((Indirizzo)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/via/{via}/{civico}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByViaAndNumeroCivico(@PathVariable String via, @PathVariable int civico) {
		if(this.service.getIndirizziByViaAndNumeroCivico(via, civico).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByViaAndNumeroCivico(via, civico), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByViaAndNumeroCivico(via, civico), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/città/{città}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByCittà(@PathVariable String città) {
		if(this.service.getIndirizziByCittà(città).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByCittà(città), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByCittà(città), HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping(path = "/provincia/{provincia}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByProvincia(@PathVariable String provincia) {
		if(this.service.getIndirizziByProvincia(provincia).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByProvincia(provincia), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByProvincia(provincia), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/regione/{regione}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByRegione(@PathVariable String regione) {
		if(this.service.getIndirizziByRegione(regione).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByRegione(regione), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByRegione(regione), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/nazione/{nazione}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByNazione(@PathVariable String nazione) {
		if(this.service.getIndirizziByNazione(nazione).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByNazione(nazione), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziByNazione(nazione), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/impiegato/{id}/")
	public ResponseEntity<Indirizzo> getIndirizzoOfImpiegato(@PathVariable int id) {
		try {
			return new ResponseEntity<Indirizzo>(this.service.getIndirizzoOfImpiegato(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Indirizzo>((Indirizzo)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/dipartimento/{id}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziOfDipartimento(int id) {
		if(this.service.getIndirizziOfDipartimento(id).size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziOfDipartimento(id), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziOfDipartimento(id), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/dirigenti/")
	public ResponseEntity<List<Indirizzo>> getIndirizziOfDirigenti() {
		if(this.service.getIndirizziOfDirigenti().size() > 0) {
			return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziOfDirigenti(), HttpStatus.OK);
		} 
		return new ResponseEntity<List<Indirizzo>>(this.service.getIndirizziOfDirigenti(), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/dirigenti/{dipartimento}/")
	public ResponseEntity<Indirizzo> getIndirizzoOfDirigente(int dipartimento) {
		try {
			return new ResponseEntity<Indirizzo>(this.service.getIndirizzoOfDirigente(dipartimento), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Indirizzo>((Indirizzo)null, HttpStatus.NO_CONTENT);
	}
}
