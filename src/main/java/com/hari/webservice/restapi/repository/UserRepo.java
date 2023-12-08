package com.hari.webservice.restapi.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hari.webservice.restapi.model.User;
import com.hari.webservice.restapi.model.User1;

public class UserRepo {
     public static  List<User> users = new ArrayList<>() ;
     public static  List<User1> confidentalUsers = new ArrayList<>() ;
     
     static{
         users= Arrays.asList(
          new User(1,"Hari",18,"12"),
          new User(2,"Ram",18,"12"),
          new User(3,"Raju",18,"12"));  
         
         confidentalUsers= Arrays.asList(
                 new User1(1,LocalDateTime.now(),LocalDateTime.now(),"Hari","R","password",
                		 "token","pay01","paymentPasswrod"),
                 new User1(2,LocalDateTime.now(),LocalDateTime.now(),"Vijay","R","password",
                		 "token","pay01","paymentPasswrod"),
                 new User1(3,LocalDateTime.now(),LocalDateTime.now(),"Dualipa","H","password",
                		 "token","pay01","paymentPasswrod")
                 );    	
         
         
     }
     
     public static void save(User user ) {
    	 user.setId(245);
    	 System.out.println(users + " " + user);
    	 users.add(user);
    	 System.out.println(users);
     }
}
