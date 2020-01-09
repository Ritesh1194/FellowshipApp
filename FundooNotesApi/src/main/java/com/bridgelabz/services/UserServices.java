package com.bridgelabz.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.model.LoginInformation;
import com.bridgelabz.model.PasswordUpdate;
import com.bridgelabz.model.UserDto;
import com.bridgelabz.model.UserInformation;
@Service
public interface UserServices {

	UserInformation login(LoginInformation information);

	boolean register(UserDto ionformation);

	boolean verify(String token) throws Exception;

	boolean isUserExist(String email);

	boolean update(PasswordUpdate information, String token);

	List<UserInformation> getUsers();

	UserInformation getSingleUser(String token);
}
