package it.edoardo.springweb.model;

import java.time.LocalDate;

import org.json.JSONObject;

import it.edoardo.springweb.model.interfaces.Jsonable;

public class User extends Item implements Jsonable{
	
	private String fistName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String taxCode;
	
	private static int INCREMENTAL_ID = 0;
	
	public User(String firstName, String lastName) {
		super(INCREMENTAL_ID++);
		this.fistName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = LocalDate.now();
		this.taxCode = this.generateTaxCode();
	}
	
	public User(int id, String firstName, String lastName) {
		super(id);
		this.fistName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = LocalDate.now();
		this.taxCode = this.generateTaxCode();
	}
	
	public User(int id, String fistName, String lastName, LocalDate dateOfBirth) {
		super(id);
		this.fistName = fistName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;		
		this.taxCode = this.generateTaxCode();
	}
	
	public User(int id, String fistName, String lastName, LocalDate dateOfBirth, String taxCode) {
		super(id);
		this.fistName = fistName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.taxCode = taxCode;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	
	private String generateTaxCode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(this.getFistName().toUpperCase().substring(0, 3))
			.append(this.getLastName().toUpperCase().substring(0, 3))
			.append(this.getDateOfBirth().toString())
			.append((int)(Math.random()*100));
		return strBuilder.toString();
	}

	@Override
	public String toString() {
		return super.toString() + " " + fistName + " " + lastName + " " + dateOfBirth
				+ " " + taxCode + '\n';
	}

	@Override
	public JSONObject toJson() {
		return super.toJson().put("firstName", this.getFistName())
			.put("lastName", this.getLastName())
			.put("dateOfBirth", this.getDateOfBirth().toString())
			.put("taxCode", this.getTaxCode());
	}
}
