package com.acme.ecommerce.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -5920378527592916159L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	
	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@NotEmpty
	@Column(name = "street_address", nullable = false)
	private String streetAddress;
	
	@NotEmpty
	@Column(name = "city", nullable = false)
	private String city;
	
	@NotEmpty
	@Column(name = "state", nullable = false)
	private String state;
	
	@NotEmpty
	@Size(min = 5, max = 10)
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@NotEmpty
	@Column(name = "country", nullable = false)
	private String country;
	
	@NotEmpty
	@Size(min = 10, max = 11)
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Email
	@NotEmpty
	@Column(name = "email", nullable = false)
	private String email;
	
	public Long getId() {
		return addressId;
	}
	
	public void setId(Long id) {
		this.addressId = id;
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
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress="
				+ streetAddress + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country="
				+ country + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
