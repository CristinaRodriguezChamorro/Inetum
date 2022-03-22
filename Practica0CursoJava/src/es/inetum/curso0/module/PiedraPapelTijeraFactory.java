package es.inetum.curso0.module;

import java.util.ArrayList;
import java.util.List;

import es.inetum.curso0.modelo.Lagarto;
import es.inetum.curso0.modelo.Papel;
import es.inetum.curso0.modelo.Piedra;
import es.inetum.curso0.modelo.Spock;
import es.inetum.curso0.modelo.Tijera;

public abstract class PiedraPapelTijeraFactory {
	public final static int PIEDRA = 1;
	public final static int PAPEL = 2;
	public final static int TIJERA = 3;
	public final static int LAGARTO = 4;
	public final static int SPOCK = 5;

	//atributos
	protected String 								descripcionResultado;
	private static List<PiedraPapelTijeraFactory> 	elementos			;
	protected String 								nombre				;
	protected int 									numero				;

	//constructores
	public PiedraPapelTijeraFactory(String pNom, int pNum) {
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

	public String getDescripcionResultado() {
		return descripcionResultado;
	}
	
	public abstract boolean isMe(int pNum);
	public abstract int comparar(PiedraPapelTijeraFactory pPiedPapelTijera);
	
	public static PiedraPapelTijeraFactory getInstance(int pNumero) {
		elementos = new ArrayList<PiedraPapelTijeraFactory>();
		elementos.add(new Piedra());
		elementos.add(new Papel());
		elementos.add(new Tijera());
		elementos.add(new Lagarto());
		elementos.add(new Spock());

		// este código sirve para ir recorriendo cada elemento. Este trozo de código no
		// cambia.
		for (PiedraPapelTijeraFactory piedraPapelTieraFactory : elementos) {
			if (piedraPapelTieraFactory.isMe(pNumero))
				return piedraPapelTieraFactory;

		}
		return null;
	}

}
