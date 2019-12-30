package com.bridgelabz.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bridgelabz.register.database.DatabaseConnection;
import com.bridgelabz.register.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	static Connection connection = DatabaseConnection.dbConnection();

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
		Customer customer = new Customer();

		try {
			preparedStatement = connection.prepareStatement("select * from customer where username =? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				customer.setUsername(result.getString(1));
				customer.setPassword(result.getString(2));
				customer.setName(result.getString(3));
				// result.close();
				// preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// response.setContentType("text/html");
	// PrintWriter printWriter = response.getWriter();
	// try {
	// Class.forName("com.mysql.jdbc.Driver").newInstance();
	// Connection con =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/Ritesh", "root",
	// "mysql");
	// Statement st = con.createStatement();
	// String userName = request.getParameter("username");
	// String password = request.getParameter("password1");
	// String name = request.getParameter("name");
	// String strQuery = "SELECT COUNT(*) FROM customer where username='" +
	// userName + "'";
	// ResultSet rs = st.executeQuery(strQuery);
	// rs.next();
	// String Countrow = rs.getString(1);
	// printWriter.println(Countrow);
	// if (Countrow.equals("0")) {
	// int i = st.executeUpdate("insert into
	// customer(username,password,name)values('" + userName + "','"
	// + password + "','" + name + "')");
	// } else {
	// printWriter.println("User name or Email already exists !");
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}