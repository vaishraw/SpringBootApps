package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
