package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Ping {
	
	private final String VERSION = "1.0";
	
	@RequestMapping("ping")
	public String index() {
		return "Greetings from Demo! You are running version: " + VERSION + "\n";
	}

}
