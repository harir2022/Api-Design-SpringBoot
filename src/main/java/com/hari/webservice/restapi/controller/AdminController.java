package com.hari.webservice.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.repository.UserRepo;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	public AdminController() {}
	
	@GetMapping("")
	public User profile() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@GetMapping("/add-users")
	public User addUsers() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@GetMapping("/remove-users")
	public User removeUsers() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
}
