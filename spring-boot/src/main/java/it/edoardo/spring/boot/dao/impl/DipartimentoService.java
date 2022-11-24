package it.edoardo.spring.boot.dao.impl;

import java.util.List;

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
	public Dipartimento getDipartimentoById(int id) {
		return this.repository.findById(id).get();
	}

	@Override
	public Dipartimento getDipartimentoByNome(String nome) {
		return this.repository.findByNome(nome).get();
	}

	@Override
	public Dipartimento getDipartimentoByImpiegato(int id) {
		return this.repository.findByImpiegato(id).get();
	}

	@Override
	public Dipartimento getDipartimentoByDirigente(int id) {
		return this.repository.findByDirettore(id).get();
	}

}
