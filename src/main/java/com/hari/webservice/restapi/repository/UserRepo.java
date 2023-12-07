package com.hari.webservice.restapi.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hari.webservice.restapi.model.User;

public class UserRepo {
     public static  List<User> users = new ArrayList<>() ;
     static{
         users= Arrays.asList(
          new User(1,"Hari",18,"12"),
          new User(2,"Ram",18,"12"),
          new User(3,"Raju",18,"12"));          
     }
     
     public static void save(User user ) {
    	 user.setId(245);
    	 System.out.println(users + " " + user);
    	 users.add(user);
    	 System.out.println(users);
     }
}
