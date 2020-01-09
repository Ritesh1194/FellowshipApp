package com.bridgelabz.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserDto {

	String fisrtname;
	
	String lastname;

	String email;

	String password;

	Long mobileNumber;
}