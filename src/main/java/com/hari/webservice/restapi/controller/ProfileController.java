package com.hari.webservice.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.repository.UserRepo;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {
	
	public ProfileController() {}
	
	@GetMapping("/me")
	public User profile() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@GetMapping("/change-password")
	public User changePassword() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@GetMapping("/updateProfile")
	public User updateProfile() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
}
