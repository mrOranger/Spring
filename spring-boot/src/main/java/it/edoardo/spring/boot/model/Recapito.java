package it.edoardo.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "Recapiti")
public class Recapito {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_recapito") private int id;
	@Column(name = "telefono") private String telefono;
	@Column(name = "email") private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_impiegato", nullable = false)
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
}
