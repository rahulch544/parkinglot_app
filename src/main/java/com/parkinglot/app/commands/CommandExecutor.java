package com.parkinglot.app.commands;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CommandExecutor {
	
	@GetMapping("/commands")
	public String home() {
		return " Welcome to Parking Lot Application";
	}

}

