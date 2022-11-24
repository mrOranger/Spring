package it.edoardo.spring.boot.dao;

import java.util.List;

import it.edoardo.spring.boot.model.Dipartimento;

public interface DipartimentoDao {
	
	public abstract List<Dipartimento> getAllDipartimenti();
	public abstract Dipartimento getDipartimentoById(int id);
	public abstract Dipartimento getDipartimentoByNome(String nome);
	public abstract Dipartimento getDipartimentoByImpiegato(int id);
	public abstract Dipartimento getDipartimentoByDirigente(int id);

}
