package com.hari.webservice.restapi.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("user1BeanFilter")
public class User1 {
	long id ;
	LocalDateTime timestamp,createdAt,leftAt;
	String firstName , lastName;
	
	String password,token;
	String paymentNo,paymentPassword;
	
	
	
	public User1(long id, LocalDateTime timestamp, LocalDateTime createdAt,String firstName,
			String lastName, String password, String token, String paymentNo, String paymentPassword) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.createdAt = createdAt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.token = token;
		this.paymentNo = paymentNo;
		this.paymentPassword = paymentPassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLeftAt() {
		return leftAt;
	}
	public void setLeftAt(LocalDateTime leftAt) {
		this.leftAt = leftAt;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getPaymentPassword() {
		return paymentPassword;
	}
	public void setPaymentPassword(String paymentPassword) {
		this.paymentPassword = paymentPassword;
	}
	
	
	
}
