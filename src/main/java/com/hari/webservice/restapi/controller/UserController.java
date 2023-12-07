package com.hari.webservice.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hari.webservice.restapi.exception.UserNotFoundException;
import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.repository.UserRepo;

import jakarta.validation.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class UserController {
     @GetMapping("/users")
     public List<User> getAllUser() {
          List<User> users = UserRepo.users;
         return users;
     }
     
     @GetMapping("/users/{id}")
     public User getAllUser(@PathVariable long id) {
          List<User> users =UserRepo.users;
          Predicate<? super User> predicate = user->user.getId()==id;
          User user = users.stream().filter(predicate).findFirst().get();
          System.out.println("user details"+user);
          if(user==null)
               throw new UserNotFoundException("user not found ..........45");
          return user;
     //     return users;
     }
     
     @PostMapping("/users")
     public List<User> saveUser(@RequestBody User user) {
    	 System.out.println(user.toString());
         UserRepo.save(user);
         return UserRepo.users;
     }
     
     
}
