package com.acme.ecommerce.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class CombinedBilling {

	private boolean billingAddressSame = false;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String streetAddress;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;

	@NotEmpty
	@Size(min = 5, max = 10)
	private String zipCode;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	@Size(min = 10, max = 11)
	private String phoneNumber;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Size(min = 13, max = 19)
	private String creditCardNumber;
	
	@NotEmpty
	private String creditCardName;
	
	@NotEmpty
	private String creditCardExpMonth;
	
	@NotEmpty
	private String creditCardExpYear;
	
	@NotEmpty
	@Size(min = 3, max = 4)
	private String creditCardCVC;

	public boolean isBillingAddressSame() {
		return billingAddressSame;
	}

	public void setBillingAddressSame(boolean billingAddressSame) {
		this.billingAddressSame = billingAddressSame;
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public String getCreditCardExpMonth() {
		return creditCardExpMonth;
	}

	public void setCreditCardExpMonth(String creditCardExpMonth) {
		this.creditCardExpMonth = creditCardExpMonth;
	}

	public String getCreditCardExpYear() {
		return creditCardExpYear;
	}

	public void setCreditCardExpYear(String creditCardExpYear) {
		this.creditCardExpYear = creditCardExpYear;
	}

	public String getCreditCardCVC() {
		return creditCardCVC;
	}

	public void setCreditCardCVC(String creditCardCVC) {
		this.creditCardCVC = creditCardCVC;
	}

}
