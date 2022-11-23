package it.edoardo.spring.boot.model;

public class Dipartimento {
	
	private int id;
	private String nome;
	private Impiegato direttore;
	
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
