package com.bridgelabz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.PasswordUpdate;
import com.bridgelabz.model.UserInformation;
@Repository
public interface IUserRepository {

	UserInformation save(UserInformation userInformation);

	UserInformation getUser(String email);

	boolean verify(Long id);

	boolean upDate(PasswordUpdate information, Long token);

	UserInformation getUserById(Long id);

	List<UserInformation> getUsers();
}