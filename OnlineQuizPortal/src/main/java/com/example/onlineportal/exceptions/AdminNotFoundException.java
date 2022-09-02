package com.example.onlineportal.exceptions;

public class AdminNotFoundException extends RuntimeException {

	public AdminNotFoundException(int id) {
		super("Admin with id " + id + " not found.");
	}

	public AdminNotFoundException(String username, String password) {
		super("Admin with Username: " + username + " password " + password + " not found.");
	}

}
