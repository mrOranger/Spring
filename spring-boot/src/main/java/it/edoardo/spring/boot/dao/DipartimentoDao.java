package it.edoardo.spring.boot.dao;

import java.util.List;

import it.edoardo.spring.boot.model.Dipartimento;

public interface DipartimentoDao {
	
	public abstract List<Dipartimento> getAllDipartimenti();
	public abstract Dipartimento getDipartimentoById(int id);
	public abstract Dipartimento getDipartimentoByNome(String nome);
	public abstract Dipartimento getDipartimentoByImpiegato(int id);
	public abstract Dipartimento getDipartimentoByDirigente(int id);
	public abstract Dipartimento postDipartimento(Dipartimento dipartimento);
	public abstract List<Dipartimento> putDipartimenti(Iterable<Dipartimento> dipartimenti);
	public abstract Dipartimento putDipartimento(int id, Dipartimento dipartimento);
	public abstract void deleteDipartimenti();
	public abstract void deleteDipartimento(int id);

}
