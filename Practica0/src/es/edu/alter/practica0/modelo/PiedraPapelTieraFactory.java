package es.edu.alter.practica0.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class PiedraPapelTieraFactory {
	public final static int PIEDRA 	= 1;
	public final static int PAPEL 	= 2;
	public final static int TIJERA 	= 3;
	public final static int LAGARTO = 4;
	public final static int SPOCK	= 5;
	
	//atributos
	protected String 								descripcionREsultado;
	private static List<PiedraPapelTieraFactory> 	elementos			;
	protected String 								nombre				;
	protected int 									numero				;

	//constructores
	public PiedraPapelTieraFactory(String pNom, int pNum) {
		nombre = pNom;
		numero = pNum;
	}
	//gettter y setter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcionREsultado() {
		return descripcionREsultado;
	}
	
	//metodo de negocio
	public abstract boolean isMe(int pNum);
	public abstract int comparar(PiedraPapelTieraFactory pPiedPapelTijera);
	
	public static PiedraPapelTieraFactory getInstance(int pNumero) {
		elementos = new ArrayList<PiedraPapelTieraFactory>();
		elementos.add(new Piedra());
		elementos.add(new Papel());
		elementos.add(new Tijera());
		elementos.add(new Lagarto());
		elementos.add(new Spock());
			
		// este código sirve para ir recorriendo cada elemento. Este trozo de código no cambia.
		for (PiedraPapelTieraFactory piedraPapelTieraFactory : elementos) {
			if(piedraPapelTieraFactory.isMe(pNumero))
				return piedraPapelTieraFactory;
			 	
		}			
		return null;
	}
	
	
}
