package it.edoardo.spring.boot.dao;

import java.time.LocalDate;
import java.util.List;

import it.edoardo.spring.boot.model.Impiegato;
import it.edoardo.spring.boot.model.Recapito;

public interface ImpiegatoDao {
	
	public abstract List<Impiegato> getImpiegati();
	public abstract Impiegato getImpiegatoById(int id);
	public abstract Impiegato getImpiegatoByCf(String codiceFiscale);
	public abstract List<Impiegato> getImpiegatiByData(LocalDate start, LocalDate end);
	public abstract List<Impiegato> getImpiegatiByVia(String via, int civico);
	public abstract List<Impiegato> getImpiegatiByCittà(String città);
	public abstract List<Impiegato> getImpiegatiByRegione(String regione);
	public abstract List<Impiegato> getImpiegatiByProvincia(String provincia);
	public abstract List<Impiegato> getImpiegatiByNazionalità(String nazionalità);
	public abstract Impiegato getImpiegatoByEmail(String email);
	public abstract Impiegato getImpiegatoByTelefono(String telefono);
	public abstract List<Impiegato> getImpiegatiByDipartimento(int dipartimento);
	public abstract List<Impiegato> getDirigenti();
	public abstract Impiegato getDirigente(int dipartimento);
	
	public abstract Impiegato postImpiegato(Impiegato impiegato);
	public abstract Impiegato postRecapito(Recapito recapito);
	
	public abstract Impiegato putImpiegato(Impiegato impiegato);
	
	public abstract List<Impiegato> deleteImpiegati();
	public abstract Impiegato deleteImpiegato(int id);
	public abstract Impiegato deleteDirigente(int dipartimento);
}
