package com.hari.webservice.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(value = {"password","id"})
public class User{
	
	 
     long id ;
     @Size(min = 2)
     String name ;
     
     @Min(value = 18)
     int age ;
     
//     @JsonIgnore
     String password;

     public User(long id ,String name , int age , String password){
          this.id=id;
          this.name=name;
          this.age=age;
          this.password=password;
     }

     

public int getAge() {
     return age;
}

public void setAge(int age) {
     this.age = age;
}

public String getPassword() {
     return password;
}

public void setPassword(String password) {
     this.password = password;
}

public String getName() {
     return name;
}

public void setName(String name) {
     this.name = name;
}



public long getId() {
     return id;
}



public void setId(long id) {
     this.id = id;
}

@Override
public String toString() {
	return name+" " +age + " " ;
}

}