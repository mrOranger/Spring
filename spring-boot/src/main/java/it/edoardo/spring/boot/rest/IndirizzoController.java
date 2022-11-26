package it.edoardo.spring.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.IndirizzoService;
import it.edoardo.spring.boot.model.Indirizzo;

@RestController @RequestMapping(path = "/indirizzi")
public class IndirizzoController {
	
	@Autowired private IndirizzoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Indirizzo>> getIndirizzi() {
		return null;
	}
	
	@GetMapping(path = "/{id}/")
	public ResponseEntity<Indirizzo> getIndirizzo(int id) {
		return null;
	}
	
	@GetMapping(path = "/via/{via}/{civico}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByViaAndNumeroCivico(String via, int civico) {
		return null;
	}
	
	@GetMapping(path = "/città/{città}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByCittà(String città) {
		return null;
	}
	
	@GetMapping(path = "/provincia/{provincia}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByProvincia(String provincia) {
		return null;
	}
	
	@GetMapping(path = "/regione/{regione}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByRegione(String regione) {
		return null;
	}
	
	@GetMapping(path = "/nazione/{nazione}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziByNazione(String nazione) {
		return null;
	}
	
	@GetMapping(path = "/impiegato/{id}/")
	public ResponseEntity<Indirizzo> getIndirizzoOfImpiegato(int id) {
		return null;
	}
	
	@GetMapping(path = "/dipartimento/{id}/")
	public ResponseEntity<List<Indirizzo>> getIndirizziOfDipartimento(int id) {
		return null;
	}
	
	@GetMapping(path = "/dirigenti/")
	public ResponseEntity<List<Indirizzo>> getIndirizziOfDirigenti() {
		return null;
	}
	
	@GetMapping(path = "/dirigenti/{dipartimento}/")
	public ResponseEntity<Indirizzo> getIndirizzoOfDirigente(int dipartimento) {
		return null;
	}
}
