package com.hari.webservice.restapi.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.repository.UserRepo;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {
	
	public ProfileController() {}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/me")
	public User profile() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@PostAuthorize("returnObject.name=='Hari'")
	@GetMapping("/change-password")
	public User changePassword() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@RolesAllowed({"ADMIN","USER"})
	@GetMapping("/updateProfile")
	public User updateProfile() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
	@Secured({"USER"})
	@GetMapping("/remove")
	public User removeAcc() {
		User user= UserRepo.users.get(0);
		return user;
	}
	
}
