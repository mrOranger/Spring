package it.edoardo.spring.boot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "impiegati")
public class Impiegato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_impiegato") private int id;
	@Column(name = "nome") private String nome;
	@Column(name = "cognome") private String cognome;
	@Column(name = "codice_fiscale") private String codiceFiscale;
	@Column(name = "data_di_nascita") private LocalDate dataDiNascita;
	
	@ManyToOne
	@JoinColumn(name = "id_dipartimento", nullable = false)
	private Dipartimento lavoraIn;
	
	@ManyToOne
	@JoinColumn(name = "id_indirizzo", nullable = false)
	private Indirizzo abitaIn;
	
	@OneToMany(mappedBy = "impiegato")
	private List<Recapito> recapiti;
	
	@OneToOne(mappedBy = "direttore", optional = true)
	private Dipartimento dipartimento;
	
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

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
}
