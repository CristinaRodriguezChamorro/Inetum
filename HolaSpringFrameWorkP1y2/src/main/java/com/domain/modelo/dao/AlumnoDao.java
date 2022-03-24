package com.domain.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.modelo.Alumno;
import com.domain.modelo.Model;
import com.domain.util.ConnectionManager;

public class AlumnoDao implements DAO {


	public AlumnoDao() {
		
	}

	public void agregar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();
		
		String sql = new String("insert into alumnos(alu_nombre, alu_apellido, alu_conocimientos,alu_git) values(?,?,?,? )");
		
		Alumno alu =(Alumno) pModel;
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEstudios());
		stm.setString(4, alu.getLinkArepositorio());		
		stm.execute();
		
		con.close();
	}

	public void modificar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();
		
		String sql = new String("update alumnos set alu_nombre=?, alu_apellido=?,"
				+ " alu_conocimientos=?, alu_git=? where alu_id=?");
		PreparedStatement stm = con.prepareStatement(sql);
		
		Alumno alu =(Alumno) pModel;
		stm.setString(1, alu.getNombre());
		stm.setString(2, alu.getApellido());
		stm.setString(3, alu.getEstudios());
		stm.setString(4, alu.getLinkArepositorio());
		stm.setInt(5, alu.getCodigo());
		
		stm.execute();
		
		con.close();
	}

	public void eliminar(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();
		
		String sql = new String("delete from alumnos where alu_id=?");
		PreparedStatement stm = con.prepareStatement(sql);
		
		Alumno alu =(Alumno) pModel;
		stm.setInt(1, alu.getCodigo());
		stm.execute();
		
		con.close();
	}

	public List<Model> leer(Model pModel) throws ClassNotFoundException, SQLException {
		ConnectionManager.conectar();
		Connection con = ConnectionManager.getConnection();

		String sql = new String("select alu_nombre, alu_apellido, alu_git, alu_conocimientos, alu_id from alumnos");
		
		if(pModel != null && pModel instanceof Alumno ) {
			sql += " where alu_id=" + ((Alumno) pModel).getCodigo();
		}
		
		Statement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery(sql);
		
		List<Model> result = new ArrayList<Model>();
		if (rs.isBeforeFirst() ) {    
			while ( rs.next() ) {
				Alumno alu = new Alumno();
				alu.setNombre( rs.getString(1) );
				alu.setApellido( rs.getString(2) );
				alu.setLinkArepositorio( rs.getString(3));
				alu.setEstudios( rs.getString(4) );
				alu.setCodigo( rs.getInt( 5 ) );
				result.add(alu);
            }
		}
		return result;
	}
}
