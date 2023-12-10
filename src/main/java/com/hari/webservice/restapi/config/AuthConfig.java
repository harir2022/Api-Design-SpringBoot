package com.hari.webservice.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AuthConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User
							.withUsername("admin")
							.password("admin")
							.roles("ADMIN")
							.passwordEncoder(str-> passwordEncoder().encode(str))
							.build();
		UserDetails user1 = User.withUsername("harish")
				.password("12")
				.roles("USER")
				.passwordEncoder(str-> passwordEncoder().encode(str))
				.build();
		UserDetails user2 = User
				.withUsername("hari")
				.password("12")
				.roles("USER")
				.passwordEncoder(str-> passwordEncoder().encode(str))
				.build();
		return new InMemoryUserDetailsManager(admin,user1,user2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
