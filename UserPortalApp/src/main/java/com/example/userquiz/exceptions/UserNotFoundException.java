package com.example.userquiz.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(int id) {
		super("User with id " + id + " not found.");
	}

	public UserNotFoundException(String username, String password) {
		super("Admin with Username: " + username + " password " + password + " not found.");
	}

}
