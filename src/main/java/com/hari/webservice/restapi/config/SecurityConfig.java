package com.hari.webservice.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity // for pre and post
@EnableMethodSecurity(jsr250Enabled = true)
//@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth->
					auth.requestMatchers("/admin/**")
						.hasAuthority("ROLE_ADMIN")
						.anyRequest()
						.authenticated())
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS	))
			.httpBasic();		
			
						
//			http.oauth2Login(Customizer.withDefaults()); // oauth google
		
			http.headers().frameOptions().sameOrigin();
			http.csrf(csrf -> csrf.disable());
			http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
			
			
		return http.build();	
	}
}
