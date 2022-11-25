package it.edoardo.spring.boot.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.edoardo.spring.boot.dao.ImpiegatoDao;
import it.edoardo.spring.boot.model.Impiegato;
import it.edoardo.spring.boot.repository.ImpiegatoRepository;

@Service
public class ImpiegatoService implements ImpiegatoDao{
	
	@Autowired private ImpiegatoRepository repository;

	@Override
	public List<Impiegato> getImpiegati() {
		return this.repository.findAll();
	}

	@Override
	public Impiegato getImpiegatoById(int id) throws NoSuchElementException {
		return this.repository.findById(id).get();
	}

	@Override
	public Impiegato getImpiegatoByCf(String codiceFiscale) throws NoSuchElementException {
		return this.repository.findByCodiceFiscale(codiceFiscale).get();
	}

	@Override
	public List<Impiegato> getImpiegatiByData(LocalDate start, LocalDate end) {
		return this.repository.findAllByDataDiNascitaBetween(start, end);
	}

	@Override
	public List<Impiegato> getImpiegatiByVia(String via, int civico) {
		return this.repository.findAllByViaAndNumeroCivico(via, civico);
	}

	@Override
	public List<Impiegato> getImpiegatiByCittà(String città) {
		return this.repository.findAllByCittà(città);
	}

	@Override
	public List<Impiegato> getImpiegatiByRegione(String regione) {
		return this.repository.findAllByRegione(regione);
	}

	@Override
	public List<Impiegato> getImpiegatiByProvincia(String provincia) {
		return this.repository.findAllByProvincia(provincia);
	}

	@Override
	public List<Impiegato> getImpiegatiByNazionalità(String nazionalità) {
		return this.repository.findAllByNazione(nazionalità);
	}

	@Override
	public Impiegato getImpiegatoByEmail(String email) {
		return this.repository.findByEmail(email).orElse(null);
	}

	@Override
	public Impiegato getImpiegatoByTelefono(String telefono) throws NoSuchElementException {
		return this.repository.findByTelefono(telefono).get();
	}

	@Override
	public List<Impiegato> getImpiegatiByDipartimento(int dipartimento) {
		return this.repository.findAllByDipartimento(dipartimento);
	}

	@Override
	public List<Impiegato> getDirigenti() {
		return this.repository.findAllDirigenti();
	}

	@Override
	public Impiegato getDirigente(int dipartimento) throws NoSuchElementException {
		return this.repository.findDirigenteInDipartimento(dipartimento).get();
	}

	@Override
	public Impiegato postImpiegato(Impiegato impiegato) {
		return this.repository.save(impiegato);
	}
	
	@Override
	public List<Impiegato> putImpiegati(Iterable<Impiegato> impiegati) {
		return this.repository.saveAll(impiegati);
	}

	@Override
	public Impiegato putImpiegato(int id, Impiegato impiegato) {
		impiegato.setId(id);
		return this.repository.save(impiegato);
	}

	@Override
	public void deleteImpiegati() {
		this.repository.deleteAll();
	}

	@Override
	public void deleteImpiegato(int id) {
		this.repository.deleteById(id);
	}
}
