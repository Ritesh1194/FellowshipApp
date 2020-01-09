package com.bridgelabz.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "usersdetail")
@Component
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	private String firstname;

	private String lastname;

	private String email;

	private String password;

	private Long mobileNumber;

	private LocalDateTime createdDate;

	private boolean isVerified;
}