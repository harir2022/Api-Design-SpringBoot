package com.hari.webservice.restapi.controller;
 

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hari.webservice.restapi.exception.UserNotFoundException;
import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.repository.UserRepo;



@RestController
public class UserController {
	
	MessageSource messageSource;
	
	public UserController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
     @GetMapping("/users")
     public List<User> getAllUser() {
          List<User> users = UserRepo.users;
         return users;
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
     
     
}
