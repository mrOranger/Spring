package it.edoardo.spring.boot.model;

public class Indirizzo {
	
	private int id;
	private String via;
	private int numero;
	private String città;
	private String regione;
	private String provincia;
	private String nazione;
	
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
}
