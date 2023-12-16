package com.hari.webservice.restapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")

public class OauthController {
	@GetMapping("")
	public Authentication user(Authentication auth) {
		return auth;
	}
	
 

	    

	 
}
