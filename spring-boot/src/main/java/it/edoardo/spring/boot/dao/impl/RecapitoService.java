package it.edoardo.spring.boot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.edoardo.spring.boot.dao.RecapitoDao;
import it.edoardo.spring.boot.model.Recapito;
import it.edoardo.spring.boot.repository.RecapitoRepository;

@Service
public class RecapitoService implements RecapitoDao{
	
	@Autowired private RecapitoRepository repository;

	@Override
	public List<Recapito> getRecapiti() {
		return this.repository.findAll();
	}

	@Override
	public Recapito getRecapito(int id) {
		return this.repository.findById(id).get();
	}

	@Override
	public List<Recapito> getRecapitoOfImpiegato(int id) {
		return this.repository.findAllByImpiegato(id);
	}

	@Override
	public Recapito getRecapitoByEmail(String email) {
		return this.repository.findByEmail(email).get();
	}

	@Override
	public Recapito getRecapitoByTelefono(String telefono) {
		return this.repository.findByTelefono(telefono).get();
	}

	@Override
	public List<Recapito> getRecapitiByProvider(String provider) {
		return this.repository.findAllByEmailContaining(provider);
	}

	@Override
	public List<Recapito> getRecapitiByDipartimento(int id) {
		return this.repository.findAllByDipartimento(id);
	}

	@Override
	public List<Recapito> getRecapitiOfDirigenti() {
		return this.repository.findAllOfDirigenti();
	}

	@Override
	public List<Recapito> getRecapitiOfDirigente(int id) {
		return this.repository.findAllOfDirigente(id);
	}
}
