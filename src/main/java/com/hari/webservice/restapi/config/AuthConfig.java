package com.hari.webservice.restapi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


@Configuration
public class AuthConfig {

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails admin = User
//							.withUsername("admin")
//							.password("admin")
//							.roles("ADMIN")
//							.passwordEncoder(str-> passwordEncoder().encode(str))
//							.build();
//		UserDetails user1 = User.withUsername("harish")
//				.password("12")
//				.roles("USER")
//				.passwordEncoder(str-> passwordEncoder().encode(str))
//				.build();
//		UserDetails user2 = User
//				.withUsername("hari")
//				.password("12")
//				.roles("USER")
//				.passwordEncoder(str-> passwordEncoder().encode(str))
//				.build();
//		return new InMemoryUserDetailsManager(admin,user1,user2);
//	}
//	
//	
//	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// JDBC
	@Bean
	public DataSource datasource() {
		return  new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(DataSource ds) {
		UserDetails user1 = User.builder()
				.username("hari")
				.password("123")
				.roles("USER")
					.passwordEncoder(str-> passwordEncoder().encode(str))
				.build();
	
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(ds);
		jdbcUserDetailsManager.createUser(user1);

		return jdbcUserDetailsManager;
	}
	
	
	
}
