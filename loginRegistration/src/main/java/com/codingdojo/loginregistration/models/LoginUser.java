package com.codingdojo.loginregistration.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// Doesn't connect to database
public class LoginUser {

	// Attributes
	@NotEmpty(message="Please enter a email")
	@Email(message="Email is invalid")
	private String email;
	
	@NotEmpty(message="Please enter a password")
	@Size(min=8, max=255, message="Password must be 8 to 255 characters.")
	private String password;

	// Constructor
	public LoginUser() {
	}

	// Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
