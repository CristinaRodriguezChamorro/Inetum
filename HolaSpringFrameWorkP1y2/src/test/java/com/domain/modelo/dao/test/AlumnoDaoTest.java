package com.domain.modelo.dao.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.modelo.dao.AlumnoDao;
import com.domain.modelo.dao.DAO;
import com.domain.util.ConnectionManager;

class AlumnoDaoTest {
	Alumno aluNuevo = null;
	DAO alumnoDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();
		Statement consulta = con.createStatement();
		String sql = "";
		BufferedReader bf = new BufferedReader(
				new InputStreamReader(AlumnoDaoTest.class.getResource("AlumnosCrear.sql").openStream()));
		while ((sql = bf.readLine()) != null) {
			if (sql.trim().length() != 0 && !sql.startsWith("--")) {
				consulta.executeUpdate(sql);
			}
		}
		ConnectionManager.desconectar();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();

		Statement consulta = con.createStatement();

		String sql = "";
		BufferedReader bf = new BufferedReader(
				new InputStreamReader(AlumnoDaoTest.class.getResource("AlumnosEliminar.sql").openStream()));
		while ((sql = bf.readLine()) != null) {
			if (sql.trim().length() != 0 && !sql.startsWith("--")) {
				consulta.executeUpdate(sql);
			}
		}
		ConnectionManager.desconectar();
	}

	@BeforeEach
	void setUp() throws Exception {
		alumnoDao = new AlumnoDao();
	}

	@AfterEach
	void tearDown() throws Exception {
		alumnoDao = null;
	}

	@Test
	public void testAgregar() {
		try {
			alumnoDao.agregar(new Alumno(0, "Gabriel_test", "Casas_test", "Estudios_test", "Repo_test"));
			ConnectionManager.conectar();
			Connection con = ConnectionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select alu_nombre from alumnos where alu_nombre ='Gabriel_test'");
			rs.next();
			assertEquals("Gabriel_test", rs.getString("alu_nombre"));
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void testModificar() {
		try {
			ConnectionManager.conectar();
			Connection con = ConnectionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select  ALU_ID  from alumnos where alu_nombre ='Marina_test'");
			rs.next();
			Alumno alu = new Alumno(rs.getInt("ALU_ID"), "MarinaModif_test", "Calvo PereñaModif_test",
					"FisicaMofi_test", "RepoModif");
			alumnoDao.modificar(alu);
			StringBuilder sql = new StringBuilder(
					"Select  ALU_ID,ALU_NOMBRE, ALU_APELLIDO , ALU_CONOCIMIENTOS , ALU_GIT");
			sql.append("  from alumnos");
			sql.append(" where alu_nombre ='MarinaModif_test'");
			rs = stm.executeQuery(sql.toString());
			rs.next();
			Alumno aluLeido = new Alumno(rs.getInt("ALU_ID"), rs.getString("ALU_NOMBRE"), rs.getString("ALU_APELLIDO"),
					rs.getString("ALU_CONOCIMIENTOS"), rs.getString("ALU_GIT"));
			assertEquals(alu.getCodigo(), aluLeido.getCodigo());
			assertEquals("MarinaModif_test", aluLeido.getNombre());
			assertEquals("Calvo PereñaModif_test", aluLeido.getApellido());
			assertEquals("FisicaMofi_test", aluLeido.getEstudios());
			assertEquals("RepoModif", aluLeido.getLinkArepositorio());
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void testEliminar() {
		try {
			ConnectionManager.conectar();
			Connection con = ConnectionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select  ALU_ID  from alumnos where alu_nombre ='Monsef_test'");
			rs.next();
			Alumno alu = new Alumno(rs.getInt("ALU_ID"));
			alumnoDao.eliminar(alu);
			rs = stm.executeQuery("Select  ALU_ID  from alumnos where alu_nombre ='Monsef_test'");
			assertFalse(rs.next());

		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}

	}

	@Test
	public void testLeerPorCodigo() {
		try {
			ConnectionManager.conectar();
			Connection con = ConnectionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select  ALU_ID  from alumnos where alu_nombre ='Aarón_test'");
			rs.next();
			Alumno alu = new Alumno(rs.getInt("ALU_ID"));
			List<Model> alumnos = alumnoDao.leer(alu);
			assertEquals("Aarón_test", ((Alumno) alumnos.get(0)).getNombre());
			assertEquals("Sánchez Sánchez_test", ((Alumno) alumnos.get(0)).getApellido());
			assertEquals("Desarrollo de Aplicaciones Multiplataforma_test", ((Alumno) alumnos.get(0)).getEstudios());
			assertEquals("https://github.com/Pashinian/CursoJava2021.git_test",
					((Alumno) alumnos.get(0)).getLinkArepositorio());
		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
}
