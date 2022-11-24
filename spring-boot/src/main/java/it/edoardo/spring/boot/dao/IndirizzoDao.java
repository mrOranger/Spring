package it.edoardo.spring.boot.dao;

import java.util.List;

import it.edoardo.spring.boot.model.Indirizzo;

public interface IndirizzoDao {
	
	public abstract List<Indirizzo> getIndirizzi();
	public abstract Indirizzo getIndirizzo(int id);
	public abstract List<Indirizzo> getIndirizziByViaAndNumeroCivico(String via, int numeroCivico);
	public abstract List<Indirizzo> getIndirizziByCittà(String città);
	public abstract List<Indirizzo> getIndirizziByProvincia(String provincia);
	public abstract List<Indirizzo> getIndirizziByRegione(String regione);
	public abstract List<Indirizzo> getIndirizziByNazione(String nazione);
	public abstract Indirizzo getIndirizzoOfImpiegato(int id);
	public abstract List<Indirizzo> getIndirizziOfDipartimento(int id);
	public abstract List<Indirizzo> getIndirizziOfDirigenti();
	public abstract Indirizzo getIndirizzoOfDirigente(int dipartimento);

}
