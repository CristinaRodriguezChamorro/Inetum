package es.inetum.curso0.module;

import java.util.List;

public abstract class PiedraPapelTijeraFactory {
	public static int PIEDRA = 1;
	public static int PAPEL = 1;
	public static int TIJERA = 1;

	protected String descripcionResultado;
	private List<PiedraPapelTijeraFactory> elementos;
	protected String nombre;
	protected String numero;

	public PiedraPapelTijeraFactory(String nombre, String numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcionResultado() {
		return descripcionResultado;
	}
	
	public abstract boolean isMe(int integer);
	public abstract int comparar(PiedraPapelTijeraFactory integer);
	
	public static PiedraPapelTijeraFactory getInstance(int pPPTijera) {
		return null;
	}

}
