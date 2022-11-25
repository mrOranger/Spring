package it.edoardo.spring.boot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "recapiti")
public class Recapito {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id") private int id;
	@Column(name = "telefono") private String telefono;
	@Column(name = "email") private String email;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_impiegato")
	private Impiegato impiegato;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Impiegato getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}
}
