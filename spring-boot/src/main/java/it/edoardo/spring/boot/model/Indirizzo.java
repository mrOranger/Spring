package it.edoardo.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "indirizzi")
public class Indirizzo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") private int id;
	@Column(name = "via") private String via;
	@Column(name = "numero") private int numero;
	@Column(name = "città") private String città;
	@Column(name = "regione") private String regione;
	@Column(name = "provincia") private String provincia;
	@Column(name = "nazione") private String nazione;
	
	@OneToMany(mappedBy = "abitaIn", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Impiegato> impiegati;
	
	public Indirizzo() {
		this.impiegati = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setVia(String via) {
		this.via = via;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCittà() {
		return città;
	}
	
	public void setCittà(String città) {
		this.città = città;
	}
	
	public String getRegione() {
		return regione;
	}
	
	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getNazione() {
		return nazione;
	}
	
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	public List<Impiegato> getImpiegati() {
		return impiegati;
	}
	
	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
}
