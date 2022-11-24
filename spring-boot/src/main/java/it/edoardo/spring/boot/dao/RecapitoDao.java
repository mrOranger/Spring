package it.edoardo.spring.boot.dao;

import java.util.List;

import it.edoardo.spring.boot.model.Recapito;

public interface RecapitoDao {
	
	public abstract List<Recapito> getRecapiti();
	public abstract Recapito getRecapito(int id);
	public abstract List<Recapito> getRecapitoOfImpiegato(int id);
	public abstract Recapito getRecapitoByEmail(String email);
	public abstract Recapito getRecapitoByTelefono(String telefono);
	public abstract List<Recapito> getRecapitiByProvider(String provider);
	public abstract List<Recapito> getRecapitiByDipartimento(int id);
	public abstract List<Recapito> getRecapitiOfDirigenti();
	public abstract List<Recapito> getRecapitiOfDirigente(int id);

}
