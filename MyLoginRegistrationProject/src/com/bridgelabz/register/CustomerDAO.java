package com.bridgelabz.register;

public interface CustomerDAO {
	public int insertCustomer(Customer customer);

	public Customer getCustomer(String username, String password);
}