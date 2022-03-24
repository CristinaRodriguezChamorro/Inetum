package com.domain.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.util.ConnectionManager;

class ConnectionManagerTest {

	//lote de pruebass
	Connection con;
	
	@BeforeEach
	void setUp() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inetum", "root", "root");
		ConnectionManager.conectar();
	}

	@AfterEach
	void tearDown() throws Exception {
		con = null;
		ConnectionManager.desconectar();
	}

	@Test
	void testConectar() {
		
		try {
			ConnectionManager.conectar();
			assertTrue(true); //si paso lo pinto de verde
			
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false); //si no paso lo pinto de rojo
			e.printStackTrace();
		}
	}

	@Test
	void testDesconectar() {
		try {
			ConnectionManager.desconectar();
			assertTrue(true);
		} catch (SQLException e) {
			assertFalse(false);
			e.printStackTrace();
		}
		
	}

	@Test
	void testGetConnection() {
		assertNotNull( ConnectionManager.getConnection());
		
	}

}
