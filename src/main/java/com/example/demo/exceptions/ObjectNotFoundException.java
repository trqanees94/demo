package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {
	
	public ObjectNotFoundException(String token) {
		super("Could not find object with token: " + token);
	}
	
}
