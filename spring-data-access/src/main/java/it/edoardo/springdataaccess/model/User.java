package it.edoardo.springdataaccess.model;

import java.time.LocalDate;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class User {
	
	@JsonProperty(value = "id") private int id;
	@JsonProperty(value = "firstName") private String firstName;
	@JsonProperty(value = "lastName") private String lastName;
	@JsonProperty(value = "dateOfBirth") private LocalDate dateOfBirth;
	@JsonProperty(value = "taxCode") private String taxCode;
	
	@JsonProperty(value = "id")
	public int getId() {
		return id;
	}
	
	@JsonProperty(value = "id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty(value = "firstName")
	public String getFirstName() {
		return firstName;
	}
	
	@JsonProperty(value = "firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty(value = "lastName")
	public String getLastName() {
		return lastName;
	}
	
	@JsonProperty(value = "lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty(value = "dateOfBirth")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	@JsonProperty(value = "dateOfBirth")
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@JsonProperty(value = "taxCode")
	public String getTaxCode() {
		return taxCode;
	}
	
	@JsonProperty(value = "taxCode")
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
}
