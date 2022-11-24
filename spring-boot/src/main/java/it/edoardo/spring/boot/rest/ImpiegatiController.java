package it.edoardo.spring.boot.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.ImpiegatoService;
import it.edoardo.spring.boot.model.Impiegato;

@RestController @RequestMapping(path = "/impiegati/") 
public class ImpiegatiController {
	
	@Autowired private ImpiegatoService service;
	
	@GetMapping(path = "/")
	public List<Impiegato> getImpiegati(){
		return this.service.getImpiegati();
	}
	
	@GetMapping(path = "/{id}/")
	public Impiegato getImpiegato(@PathVariable(name = "id") int id) {
		return this.service.getImpiegatoById(id);
	}
	
	@GetMapping(path = "/cf/{cf}/")
	public Impiegato getImpiegatoByCf(@PathVariable(name = "cf") String cf) {
		return this.service.getImpiegatoByCf(cf);
	}
	
	// TODO : Bad request da rivedere
	@GetMapping(path = "/data/{start}/{end}/")
	public List<Impiegato> getImpiegatiByData(@PathVariable(name = "start") LocalDate start, 
			@PathVariable(name = "end") LocalDate end) {
		return this.service.getImpiegatiByData(start, end);
	}
	
	// TODO : Internal server error da riveredere
	@GetMapping(path = "/via/{via}/{civico}/")
	public List<Impiegato> getImpiegatiByVia(@PathVariable(name = "via") String via, 
			@PathVariable(name = "civico") int civico) {
		return this.service.getImpiegatiByVia(via, civico);
	}
	
	@GetMapping(path = "/città/{città}/")
	public List<Impiegato> getImpiegatiByCittà(@PathVariable(name = "città") String città) {
		return this.service.getImpiegatiByCittà(città);
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
		return this.service.getImpiegatiByNazionalità(nazione);
	}
	
	@GetMapping(path = "/email/{email}/")
	public Impiegato getImpiegatoByEmail(@PathVariable(name = "email") String email) {
		return this.service.getImpiegatoByEmail(email);
	}
	
	@GetMapping(path = "/telefono/{telefono}/")
	public Impiegato getImpiegatoByTelefono(@PathVariable(name = "telefono") String telefono) {
		return this.service.getImpiegatoByTelefono(telefono);
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
	public Impiegato getDirigente(@PathVariable(name = "dipartimento") int dipartimento) {
		return this.service.getDirigente(dipartimento);
	}

}
