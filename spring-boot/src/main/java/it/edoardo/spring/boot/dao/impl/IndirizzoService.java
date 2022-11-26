package it.edoardo.spring.boot.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.edoardo.spring.boot.dao.IndirizzoDao;
import it.edoardo.spring.boot.model.Indirizzo;
import it.edoardo.spring.boot.repository.IndirizzoRepository;

@Service
public class IndirizzoService implements IndirizzoDao{
	
	@Autowired private IndirizzoRepository repository;

	@Override
	public List<Indirizzo> getIndirizzi() {
		return this.repository.findAll();
	}

	@Override
	public Indirizzo getIndirizzo(int id) throws NoSuchElementException {
		return this.repository.findById(id).get();
	}

	@Override
	public List<Indirizzo> getIndirizziByViaAndNumeroCivico(String via, int numeroCivico) {
		return this.repository.findAllByViaAndNumero(via, numeroCivico);
	}

	@Override
	public List<Indirizzo> getIndirizziByCittà(String città) {
		return this.repository.findAllByCittà(città);
	}

	@Override
	public List<Indirizzo> getIndirizziByProvincia(String provincia) {
		return this.repository.findAllByProvincia(provincia);
	}

	@Override
	public List<Indirizzo> getIndirizziByRegione(String regione) {
		return this.repository.findAllByRegione(regione);
	}

	@Override
	public List<Indirizzo> getIndirizziByNazione(String nazione) {
		return this.repository.findAllByNazione(nazione);
	}

	@Override
	public Indirizzo getIndirizzoOfImpiegato(int id) throws NoSuchElementException {
		return this.repository.findByImpiegato(id).get();
	}

	@Override
	public List<Indirizzo> getIndirizziOfDipartimento(int id) {
		return this.repository.findAllByDipartimento(id);
	}

	@Override
	public List<Indirizzo> getIndirizziOfDirigenti() {
		return this.repository.findAllByDirigenti();
	}

	@Override
	public Indirizzo getIndirizzoOfDirigente(int dipartimento) throws NoSuchElementException {
		return this.repository.findByDirigente(dipartimento).get();
	}
}
