package com.mindtree.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="Customers")
public class Customer {

	@Id
	private String id;
	private String title;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String firstName;
	private String lastName;
	private String dateofBirth;
	//@JsonIgnore
	//private LocalDate dob;
	private String countryofResident;
	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}


	private String nationality;
	private String customerRelation;
	@JsonIgnore
	private String password;
	private String preferredLangauage;
	private String skywardsNumber;

	
	private List<Preference> preferences;

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}


	private Passport passport;

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	private Address address;
	//@Transient
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/*public String getDateofBirth() {
		if (dob != null) {
			return dob.format(formatter);
		}
		return "";
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
		this.dob = LocalDate.parse(dateofBirth, formatter);
	}
*/
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer() {
	}

	public Customer(String id, String title, String firstName, String lastName, String countryofResident, String nationality, String customerRelation, String password,
			String preferredLangauage, String skywardsNumber) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryofResident = countryofResident;
		this.nationality = nationality;
		this.customerRelation = customerRelation;
		this.password = password;
		this.preferredLangauage = preferredLangauage;
		this.skywardsNumber = skywardsNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryofResident() {
		return countryofResident;
	}

	public void setCountryofResident(String countryofResident) {
		this.countryofResident = countryofResident;
	}

	public String getCustomerRelation() {
		return customerRelation;
	}

	public void setCustomerRelation(String customerRelation) {
		this.customerRelation = customerRelation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreferredLangauage() {
		return preferredLangauage;
	}

	public void setPreferredLangauage(String preferredLangauage) {
		this.preferredLangauage = preferredLangauage;
	}

	public String getSkywardsNumber() {
		return skywardsNumber;
	}

	public void setSkywardsNumber(String skywardsNumber) {
		this.skywardsNumber = skywardsNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
