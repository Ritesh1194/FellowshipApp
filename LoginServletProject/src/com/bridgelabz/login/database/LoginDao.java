package com.bridgelabz.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.login.bean.LoginBean;

public class LoginDao {
	Connection connection;

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Ritesh?autoReconnect=true&useSSL=false", "root", "mysql");

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from login where username=? and password=?");

			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			// System.out.println(preparedStatement);

			ResultSet result = preparedStatement.executeQuery();
			status = result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
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