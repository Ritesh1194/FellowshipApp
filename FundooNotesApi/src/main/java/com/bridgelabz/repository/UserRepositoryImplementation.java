package com.bridgelabz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.PasswordUpdate;
import com.bridgelabz.model.UserInformation;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public UserInformation save(UserInformation userInformation) {

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(userInformation);
		return userInformation;

	}

	@Override
	public UserInformation getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDate(PasswordUpdate information, Long token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInformation getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInformation> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}