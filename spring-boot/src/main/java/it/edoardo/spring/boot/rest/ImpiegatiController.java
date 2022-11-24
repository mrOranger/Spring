package it.edoardo.spring.boot.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.ImpiegatoService;
import it.edoardo.spring.boot.model.Impiegato;

@RestController 
public class ImpiegatiController {
	
	@Autowired private ImpiegatoService service;
	
	public List<Impiegato> getImpiegati(){
		return this.service.getImpiegati();
	}
	
	public Impiegato getImpiegato(int id) {
		return this.service.getImpiegatoById(id);
	}
	
	public Impiegato getImpiegatoByCf(String cf) {
		return this.service.getImpiegatoByCf(cf);
	}
	
	public List<Impiegato> getImpiegatiByData(LocalDate start, LocalDate end) {
		return this.service.getImpiegatiByData(start, end);
	}
	
	public List<Impiegato> getImpiegatiByVia(String via, int civico) {
		return this.service.getImpiegatiByVia(via, civico);
	}
	
	public List<Impiegato> getImpiegatiByCittà(String città) {
		return this.service.getImpiegatiByCittà(città);
	}
	
	public List<Impiegato> getImpiegatiByProvincia(String provincia) {
		return this.service.getImpiegatiByProvincia(provincia);
	}
	
	public List<Impiegato> getImpiegatiByRegione(String regione) {
		return this.service.getImpiegatiByRegione(regione);
	}
	
	public List<Impiegato> getImpiegatiByNazione(String nazione) {
		return this.service.getImpiegatiByNazionalità(nazione);
	}
	
	public Impiegato getImpiegatoByEmail(String email) {
		return this.service.getImpiegatoByEmail(email);
	}
	
	public Impiegato getImpiegatoByTelefono(String telefono) {
		return this.service.getImpiegatoByTelefono(telefono);
	}
	
	public List<Impiegato> getImpiegatiByDipartimento(int dipartimento) {
		return this.service.getImpiegatiByDipartimento(dipartimento);
	}
	
	public List<Impiegato> getDirigenti() {
		return this.service.getDirigenti();
	}
	
	public Impiegato getDirigente(int dipartimento) {
		return this.service.getDirigente(dipartimento);
	}

}
