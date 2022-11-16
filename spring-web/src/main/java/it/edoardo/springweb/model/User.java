package it.edoardo.springweb.model;

import java.time.LocalDate;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Generated("jsonschema2pojo")
public class User extends Item{
	
	@JsonProperty(value = "firstName") private String firstName;
	
	@JsonProperty(value = "lastName") private String lastName;
	
	@JsonProperty(value = "dateOfBirth") 
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@JsonProperty(value = "taxCode") private String taxCode;
	
	@JsonProperty(value = "firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty(value = "firstName")
	public void setFistName(String firstName) {
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

	@Override
	public String toString() {
		return super.toString() + " " + firstName + " " + lastName + " " + dateOfBirth
				+ " " + taxCode;
	}
}
