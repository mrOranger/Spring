package it.edoardo.spring.boot.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.edoardo.spring.boot.dao.DipartimentoDao;
import it.edoardo.spring.boot.model.Dipartimento;
import it.edoardo.spring.boot.repository.DipartimentoRepository;

@Service
public class DipartimentoService implements DipartimentoDao{
	
	@Autowired private DipartimentoRepository repository;

	@Override
	public List<Dipartimento> getAllDipartimenti() {
		return this.repository.findAll();
	}

	@Override
	public Dipartimento getDipartimentoById(int id) throws NoSuchElementException {
		return this.repository.findById(id).get();
	}

	@Override
	public Dipartimento getDipartimentoByNome(String nome) throws NoSuchElementException {
		return this.repository.findByNome(nome).get();
	}

	@Override
	public Dipartimento getDipartimentoByImpiegato(int id) throws NoSuchElementException {
		return this.repository.findByImpiegato(id).get();
	}

	@Override
	public Dipartimento getDipartimentoByDirigente(int id) throws NoSuchElementException {
		return this.repository.findByDirettore(id).get();
	}

	@Override
	public Dipartimento postDipartimento(Dipartimento dipartimento) {
		return this.repository.save(dipartimento);
	}

	@Override
	public List<Dipartimento> putDipartimenti(Iterable<Dipartimento> dipartimenti) {
		return this.repository.saveAll(dipartimenti);
	}

	@Override
	public Dipartimento putDipartimento(int id, Dipartimento dipartimento) {
		dipartimento.setId(id);
		return this.repository.save(dipartimento);
	}

	@Override
	public void deleteDipartimenti() {
		this.repository.deleteAll();
	}

	@Override
	public void deleteDipartimento(int id) throws IllegalArgumentException {
		this.repository.deleteById(id);
	}

}
