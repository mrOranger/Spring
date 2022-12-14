package it.edoardo.spring.boot.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import it.edoardo.spring.boot.dao.impl.ImpiegatoService;
import it.edoardo.spring.boot.model.Impiegato;

@RestController @RequestMapping(path = "/impiegati") 
public class ImpiegatiController {
	
	@Autowired private ImpiegatoService service;
	
	@GetMapping(path = "/")
	public List<Impiegato> getImpiegati(){
		return this.service.getImpiegati();
	}
	
	@GetMapping(path = "/{id}/")
	public ResponseEntity<Impiegato> getImpiegato(@PathVariable(name = "id") int id) {
		try {
			return new ResponseEntity<Impiegato>(this.service.getImpiegatoById(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Impiegato>((Impiegato)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/cf/{cf}/")
	public ResponseEntity<Impiegato> getImpiegatoByCf(@PathVariable(name = "cf") String cf) {
		try {
			return new ResponseEntity<Impiegato>(this.service.getImpiegatoByCf(cf), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Impiegato>((Impiegato)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/data/{start}/{end}/")
	public List<Impiegato> getImpiegatiByData(@PathVariable(name = "start")
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			LocalDate start,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable(name = "end") LocalDate end) {
		return this.service.getImpiegatiByData(start, end);
	}
	
	@GetMapping(path = "/via/{via}/{civico}/")
	public List<Impiegato> getImpiegatiByVia(@PathVariable(name = "via") String via, 
			@PathVariable(name = "civico") int civico) {
		return this.service.getImpiegatiByVia(via, civico);
	}
	
	@GetMapping(path = "/citt??/{citt??}/")
	public List<Impiegato> getImpiegatiByCitt??(@PathVariable(name = "citt??") String citt??) {
		return this.service.getImpiegatiByCitt??(citt??);
	}
	
	@GetMapping(path = "/provincia/{provincia}/")
	public List<Impiegato> getImpiegatiByProvincia(@PathVariable(name = "provincia") String provincia) {
		return this.service.getImpiegatiByProvincia(provincia);
	}
	
	@GetMapping(path = "/regione/{regione}/")
	public List<Impiegato> getImpiegatiByRegione(@PathVariable(name = "regione") String regione) {
		return this.service.getImpiegatiByRegione(regione);
	}
	
	@GetMapping(path = "/nazione/{nazione}/")
	public List<Impiegato> getImpiegatiByNazione(@PathVariable(name = "nazione") String nazione) {
		return this.service.getImpiegatiByNazionalit??(nazione);
	}
	
	@GetMapping(path = "/email/{email}/")
	public ResponseEntity<Impiegato> getImpiegatoByEmail(@PathVariable(name = "email") String email) {
		try {
			return new ResponseEntity<Impiegato>(this.service.getImpiegatoByEmail(email), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Impiegato>((Impiegato)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/telefono/{telefono}/")
	public ResponseEntity<Impiegato> getImpiegatoByTelefono(@PathVariable(name = "telefono") String telefono) {
		try {
			return new ResponseEntity<Impiegato>(this.service.getImpiegatoByTelefono(telefono), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Impiegato>((Impiegato)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/dipartimento/{dipartimento}/")
	public List<Impiegato> getImpiegatiByDipartimento(@PathVariable(name = "dipartimento") int dipartimento) {
		return this.service.getImpiegatiByDipartimento(dipartimento);
	}
	
	@GetMapping(path = "/dirigenti/")
	public List<Impiegato> getDirigenti() {
		return this.service.getDirigenti();
	}
	
	@GetMapping(path = "/dirigente/{dipartimento}/")
	public ResponseEntity<Impiegato> getDirigente(@PathVariable(name = "dipartimento") int dipartimento) {
		try {
			return new ResponseEntity<Impiegato>(this.service.getDirigente(dipartimento), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Impiegato>((Impiegato)null, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path = "/") @Transactional
	public Impiegato postImpiegato(@RequestBody Impiegato impiegato) {
		return this.service.postImpiegato(impiegato);
	}
	
	@PutMapping(path = "/")
	public List<Impiegato> putImpiegati(@RequestBody Iterable<Impiegato> impiegati) {
		return this.service.putImpiegati(impiegati);
	}
	
	@PutMapping(path = "/{id}/")
	public Impiegato putImpiegati(@PathVariable(name = "id") int id, @RequestBody Impiegato impiegato) {
		return this.service.putImpiegato(id, impiegato);
	}
	
	@DeleteMapping(path = "/")
	public void deleteImpiegati() {
		this.service.deleteImpiegati();
	}
	
	@DeleteMapping(path = "/{id}/")
	public void deleteImpiegato(@PathVariable(name = "id") int id) {
		this.service.deleteImpiegato(id);
	}
}
