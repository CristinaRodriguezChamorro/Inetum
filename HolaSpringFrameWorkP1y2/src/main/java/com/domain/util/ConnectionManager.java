package com.domain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection connection;
	
	public static void  conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inetum", "root", "root");
	}

	public static void desconectar() throws SQLException {
		connection.close();
	}
	public static Connection getConnection() {
		return connection;
	}

}
