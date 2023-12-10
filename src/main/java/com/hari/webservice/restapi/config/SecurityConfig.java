package com.hari.webservice.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS	))
			.httpBasic();
			http.csrf(csrf -> csrf.disable());
		;
		return http.build();	
	}
}
