package com.mindtree.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Passport {

	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String passportNumber;
	private String nationality;
	private String countryOfIssue;

	private String expiryDate;


	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountryOfIssue() {
		return countryOfIssue;
	}

	public void setCountryOfIssue(String countryOfIssue) {
		this.countryOfIssue = countryOfIssue;
	}

}
