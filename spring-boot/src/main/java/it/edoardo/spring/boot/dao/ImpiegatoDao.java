package it.edoardo.spring.boot.dao;

import java.time.LocalDate;
import java.util.List;

import it.edoardo.spring.boot.model.Impiegato;

public interface ImpiegatoDao {
	
	public abstract List<Impiegato> getImpiegati();
	public abstract Impiegato getImpiegatoById(int id);
	public abstract Impiegato getImpiegatoByCf(String codiceFiscale);
	public abstract List<Impiegato> getImpiegatiByData(LocalDate start, LocalDate end);
	public abstract List<Impiegato> getImpiegatiByVia(String via, int civico);
	public abstract List<Impiegato> getImpiegatiByCitt√†(String citt√†);
	public abstract List<Impiegato> getImpiegatiByRegione(String regione);
	public abstract List<Impiegato> getImpiegatiByProvincia(String provincia);
	public abstract List<Impiegato> getImpiegatiByNazionalit√†(String nazionalit√†);
	public abstract Impiegato getImpiegatoByEmail(String email);
	public abstract Impiegato getImpiegatoByTelefono(String telefono);
	public abstract List<Impiegato> getImpiegatiByDipartimento(int dipartimento);
	public abstract List<Impiegato> getDirigenti();
	public abstract Impiegato getDirigente(int dipartimento);
	
	public abstract Impiegato postImpiegato(Impiegato impiegato);
	
	public abstract List<Impiegato> putImpiegati(Iterable<Impiegato> impiegati);
	public abstract Impiegato putImpiegato(int id, Impiegato impiegato);
	
	public abstract void deleteImpiegati();
	public abstract void deleteImpiegato(int id);
}
