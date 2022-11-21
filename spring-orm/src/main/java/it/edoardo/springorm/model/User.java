package it.edoardo.springorm.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity @Table(name = "users") @Generated("jsonschema2pojo")
public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = -6162375524587174360L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id") private int id;
	
	@Column(name = "first_name") 
	@JsonProperty(value = "firstName") private String firstName;
	
	@Column(name = "last_name") 
	@JsonProperty(value = "lastName") private String lastName;
	
	@Column(name = "date_of_birth") 
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty(value = "dateOfBirth") private LocalDate dateOfBirth;
	
	@Column(name = "tax_code") 
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

	@Override
	public int compareTo(User o) {
		return this.getId() - o.getId();
	}
}
