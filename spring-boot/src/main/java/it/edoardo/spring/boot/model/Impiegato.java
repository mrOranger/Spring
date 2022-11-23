package it.edoardo.spring.boot.model;

import java.time.LocalDate;
import java.util.List;

public class Impiegato {
	
	private int id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataDiNascita;
	
	private Dipartimento lavoraIn;
	private Indirizzo abitaIn;
	private List<Recapito> recapiti;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Dipartimento getLavoraIn() {
		return lavoraIn;
	}

	public void setLavoraIn(Dipartimento lavoraIn) {
		this.lavoraIn = lavoraIn;
	}

	public Indirizzo getAbitaIn() {
		return abitaIn;
	}

	public void setAbitaIn(Indirizzo abitaIn) {
		this.abitaIn = abitaIn;
	}

	public List<Recapito> getRecapiti() {
		return recapiti;
	}

	public void setRecapiti(List<Recapito> recapiti) {
		this.recapiti = recapiti;
	}
}
