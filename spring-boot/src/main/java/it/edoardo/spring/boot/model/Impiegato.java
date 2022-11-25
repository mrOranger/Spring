package it.edoardo.spring.boot.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name = "impiegati")
public class Impiegato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id") private int id;
	@Column(name = "nome") private String nome;
	@Column(name = "cognome") private String cognome;
	@Column(name = "codice_fiscale") private String codiceFiscale;
	@Column(name = "data_di_nascita") private LocalDate dataDiNascita;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "lavora_in", nullable = false)
	@JsonIgnoreProperties(value = {"impiegati", "direttore"})
	private Dipartimento lavoraIn;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "abita_in", nullable = false)
	@JsonIgnoreProperties(value = "impiegati")
	private Indirizzo abitaIn;

	@OneToOne(optional = true, mappedBy = "direttore", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties(value = {"impiegati", "direttore"})
	private Dipartimento dirige;

	
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

	public Dipartimento getDirige() {
		return dirige;
	}

	public void setDirettore(Dipartimento dipartimento) {
		this.dirige = dipartimento;
	}
}
