package com.bridgelabz.registration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bridgelabz.registration.bean.Employee;

public class RegistrationDao {
	Connection connection;

	public int registerEmployee(Employee employee) {
		String sql = "INSERT INTO employees"
				+ "  (id, first_name, last_name, username, password, address, contact) VALUES "
				+ " (?, ?, ?, ?, ?,?,?);";

		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Ritesh?autoReconnect=true&useSSL=false", "root", "mysql");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.out.println("SQL State " + ((SQLException) e).getSQLState());
				System.out.println("Error Code " + ((SQLException) e).getErrorCode());
				System.out.println("Message " + ((SQLException) e).getMessage());

				Throwable throwable = ex.getCause();
				while (throwable != null) {
					System.out.println("Cause" + throwable);
					throwable.getCause();
				}
			}
		}
	}
}