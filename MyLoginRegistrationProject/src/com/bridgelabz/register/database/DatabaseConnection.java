package com.bridgelabz.register.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection connection = null;

	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Ritesh?autoReconnect=true&useSSL=false", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}