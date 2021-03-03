package com.mindtree.ajaxandservletcodechallenge.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/countrydetails";
	private static final String uName = "root";
	private static final String pass = "root";

	public Connection createConnection() throws SQLException {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con = DriverManager.getConnection(url, uName, pass);

		return con;
	}

}
