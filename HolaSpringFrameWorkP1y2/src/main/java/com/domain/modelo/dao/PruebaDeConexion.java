package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaDeConexion {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement  stm = null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alten", "sistema", "sistema");
			
			stm = con.createStatement();
			
			rs = stm.executeQuery("select alu_id, alu_nombre, alu_apellido from alumnos");
			
			while(rs.next()) {
				System.out.println("\nid=" + rs.getInt("alu_id"));
				System.out.println("nombre=" + rs.getString("alu_nombre"));
				System.out.println("apellido=" + rs.getString("alu_apellido"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			stm.close();
			con.close();
			
			
		}
		

	}

}
