package com.bridgelabz.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {

	static Connection connection;

	static PreparedStatement preparedStatement;

	public int insertCustomer(Customer customer) {
		int status = 0;
		try {
			preparedStatement = connection.prepareStatement("insert into customer values(?,?,?)");
			preparedStatement.setString(1, customer.getUsername());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getName());
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Customer getCustomer(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		Customer customer = new Customer();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Ritesh?autoReconnect=true&useSSL=false", "root", "mysql");
			preparedStatement = connection.prepareStatement("select * from customer where username =? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				customer.setUsername(result.getString(1));
				customer.setPassword(result.getString(2));
				customer.setName(result.getString(3));
//				result.close();
//				preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
}