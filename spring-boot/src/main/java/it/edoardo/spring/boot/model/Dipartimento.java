package it.edoardo.spring.boot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "dipartimenti")
public class Dipartimento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id") private int id;
	@Column(name = "nome") private String nome;
	
	@OneToMany(mappedBy = "lavoraIn", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Impiegato> impiegati;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "direttore")
	private Impiegato direttore;
	
	public Dipartimento() {
		this.impiegati = new ArrayList<>();
	}
	
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
	
	public Impiegato getDirettore() {
		return direttore;
	}
	
	public void setDirettore(Impiegato direttore) {
		this.direttore = direttore;
	}
}
