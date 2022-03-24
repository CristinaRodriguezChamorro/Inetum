package com.domain.modelo;

import java.util.Objects;

public class Alumno implements Model, Vaciable {
	//atributos
	private int 	codigo				;
	private String 	nombre				;
	private String 	apellido			;
	private String 	estudios			;
	private String 	linkArepositorio	;
	//constructores
	public Alumno() {}
	public Alumno(int pCodigo) {
		codigo = pCodigo;
	}	
	public Alumno(int codigo, String nombre, String apellido, String estudios, String linkArepositorio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estudios = estudios;
		this.linkArepositorio = linkArepositorio;
	}
	
	//getter y setter
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public String getLinkArepositorio() {
		return linkArepositorio;
	}
	public void setLinkArepositorio(String linkArepositorio) {
		this.linkArepositorio = linkArepositorio;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, codigo, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && codigo == other.codigo
				&& Objects.equals(nombre, other.nombre);
	}
	

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", estudios=" + estudios
				+ ", linkArepositorio=" + linkArepositorio + "]";
	}
	
	@Override
	public boolean isEmpty() {
		return codigo 					== 0 									&&
			   (this.nombre				==null 	|| nombre.isEmpty())  			&&
			   (this.apellido			==null	|| apellido.isEmpty()) 			&&
			   (this.estudios			==null 	|| estudios.isEmpty()) 			&&
			   (this.linkArepositorio 	==null 	|| linkArepositorio.isEmpty())	;
	}

}
