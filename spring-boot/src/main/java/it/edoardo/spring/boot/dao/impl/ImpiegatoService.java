package it.edoardo.spring.boot.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.edoardo.spring.boot.dao.ImpiegatoDao;
import it.edoardo.spring.boot.model.Impiegato;
import it.edoardo.spring.boot.model.Recapito;
import it.edoardo.spring.boot.repository.ImpiegatoRepository;

public class ImpiegatoService implements ImpiegatoDao{
	
	@Autowired private ImpiegatoRepository repository;

	@Override
	public List<Impiegato> getImpiegati() {
		return this.repository.findAll();
	}

	@Override
	public Impiegato getImpiegatoById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public Impiegato getImpiegatoByCf(String codiceFiscale) {
		return this.repository.findByCodiceFiscale(codiceFiscale).orElse(null);
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
	public Impiegato getImpiegatoByTelefono(String telefono) {
		return this.repository.findByTelefono(telefono).orElse(null);
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
	public Impiegato getDirigente(int dipartimento) {
		return this.repository.findDirigenteInDipartimento(dipartimento).orElse(null);
	}

	@Override
	public Impiegato postImpiegato(Impiegato impiegato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Impiegato postRecapito(Recapito recapito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Impiegato putImpiegato(Impiegato impiegato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Impiegato> deleteImpiegati() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Impiegato deleteImpiegato(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Impiegato deleteDirigente(int dipartimento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
