package com.bridgelabz.register.dao;

import com.bridgelabz.register.model.Customer;

public interface CustomerDAO {
	public int insertCustomer(Customer customer);

	public Customer getCustomer(String username, String password);
}