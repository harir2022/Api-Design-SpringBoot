package com.hari.webservice.restapi.controller;
 

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hari.webservice.restapi.exception.UserNotFoundException;
import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.model.User1;
import com.hari.webservice.restapi.repository.UserRepo;



@RestController
public class UserController {
	
	MessageSource messageSource;
	
	JwtEncoder jwtEncoder;
	
	public UserController(MessageSource messageSource,	JwtEncoder jwtEncoder) {
		this.messageSource=messageSource;
		this.jwtEncoder=jwtEncoder;
	}
	
     @GetMapping("/users")
     public List<User> getAllUser() {
          List<User> users = UserRepo.users;
         return users;
     }
     
     @GetMapping("/users/confidental")
     public MappingJacksonValue getAllConfidentalUserDetails(@RequestParam boolean high) {
    	 
    	 List<User1> users = UserRepo.confidentalUsers;
		 MappingJacksonValue mappingJacksonvalues= new MappingJacksonValue(users);
		 SimpleBeanPropertyFilter filter ;
		 if(high) {
			
			 filter=SimpleBeanPropertyFilter.filterOutAllExcept(
					"id","firstName","lastName"
					 );
			 
		 }else {
			 filter=SimpleBeanPropertyFilter.filterOutAllExcept(
					 "id","createdAt","leftAt","firstName","lastName",
					 "paymentNo","token"
					 );
		 }
         
		 FilterProvider provider = new SimpleFilterProvider().addFilter("user1BeanFilter", filter);
		 mappingJacksonvalues.setFilters(provider);
		 
         return mappingJacksonvalues;
     }
     
     
     
     @GetMapping("/users/{id}")
     public EntityModel<User> getAllUser(@PathVariable long id) {
          List<User> users =UserRepo.users;
          Predicate<? super User> predicate = user->user.getId()==id;
          User user = users.stream().filter(predicate).findFirst().get();
          System.out.println("user details"+user);
          if(user==null)
               throw new UserNotFoundException("user not found ..........45");
          

  		EntityModel<User> entityModel = EntityModel.of(user);
  		
  		WebMvcLinkBuilder link =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileController.class).profile());
  		WebMvcLinkBuilder link1 =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileController.class).changePassword());
  		WebMvcLinkBuilder link2 =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileController.class).updateProfile());
  		entityModel.add(link.withRel("profile"));
  		entityModel.add(link1.withRel("change-Password"));
  		entityModel.add(link2.withRel("update-profile"));
  		
  		return entityModel;

     }
     
     @PostMapping("/users")
     public List<User> saveUser(@RequestBody User user) {
    	 System.out.println(user.toString());
         UserRepo.save(user);
         return UserRepo.users;
     }
     
     
     @GetMapping("/internationalised")
     private String method() {
    	 Locale locale = LocaleContextHolder.getLocale();
 		return messageSource.getMessage("greeting", null,"Default message : "+locale.toString(), locale );
 		
     }
     
     @GetMapping("/auth")
     private String auth(Authentication authentication) {
    	return createToken(authentication);
     }
     
     public String createToken(Authentication auth) {
    	 var claims = JwtClaimsSet
    	 	.builder()
    	 	.issuer("hari")
    	 	.issuedAt(Instant.now())
    	 	.expiresAt(Instant.now().plusSeconds(60*60*24))
    	 	.subject(auth.getName())
    	 	.claim("scope",createScope(auth))
    	 	.build();
    	 JwtEncoderParameters parameter= JwtEncoderParameters.from(claims);
		return jwtEncoder.encode(parameter).getTokenValue();
     }

	private String createScope(Authentication auth) {
		return auth.getAuthorities().stream()
		.map(a->a.getAuthority())
		.collect(Collectors.joining(" "));
	}
     
     
     
     
}
