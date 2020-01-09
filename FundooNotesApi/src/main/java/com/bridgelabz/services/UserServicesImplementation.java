package com.bridgelabz.services;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.bridgelabz.exception.UserException;
import com.bridgelabz.model.LoginInformation;
import com.bridgelabz.model.PasswordUpdate;
import com.bridgelabz.model.UserDto;
import com.bridgelabz.model.UserInformation;
import com.bridgelabz.repository.IUserRepository;
import com.bridgelabz.responses.MailObject;
import com.bridgelabz.responses.MailResponse;
import com.bridgelabz.util.JwtGenerator;
import com.bridgelabz.util.MailServiceProvider;

@Service
public class UserServicesImplementation implements UserServices {

	@Autowired
	private UserInformation userInformation;

	@Autowired
	private IUserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encryption;

	@Autowired
	private JwtGenerator generate;

	@Autowired
	private MailResponse response;

	@Autowired
	private MailObject mailObject;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MailServiceProvider MailServiceProvider;

	@Transactional
	@Override
	public boolean register(UserDto information) {
		System.out.println("inside service");
		UserInformation user = repository.getUser(information.getEmail());

		if (user == null) {

			userInformation = modelMapper.map(information, UserInformation.class);
			userInformation.setFirstname(information.getFisrtname());
			userInformation.setLastname(information.getLastname());
			userInformation.setCreatedDate(LocalDateTime.now());
			String epassword = encryption.encode(information.getPassword());
			userInformation.setPassword(epassword);
			userInformation.setVerified(false);
			userInformation = repository.save(userInformation);
			System.out.println("id" + " " + userInformation.getUserId());
			System.out.println("token" + " " + generate.jwtToken(userInformation.getUserId()));
			String mailResponse = response.formMessage("http://localhost:9000/verify",
					generate.jwtToken(userInformation.getUserId()));
			System.out.println(mailResponse);
			mailObject.setEmail(information.getEmail());
			mailObject.setMessage(mailResponse);
			mailObject.setSubject("verification");

			// MailServiceProvider.send();
			return true;

		} else {
			throw new UserException("user already exist with the same mail id");

		}

	}

	@Override
	public UserInformation login(LoginInformation information) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(String token) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PasswordUpdate information, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInformation> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInformation getSingleUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}