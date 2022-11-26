package it.edoardo.spring.boot.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "impiegati")
public class Impiegato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id") private int id;
	@Column(name = "nome") private String nome;
	@Column(name = "cognome") private String cognome;
	@Column(name = "codice_fiscale") private String codiceFiscale;
	@Column(name = "data_di_nascita") private LocalDate dataDiNascita;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "lavora_in", nullable = false)
	private Dipartimento lavoraIn;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "abita_in", nullable = false)
	private Indirizzo abitaIn;

	@OneToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "dirige", nullable = true)
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

	public void setDirige(Dipartimento dipartimento) {
		this.dirige = dipartimento;
	}
}
