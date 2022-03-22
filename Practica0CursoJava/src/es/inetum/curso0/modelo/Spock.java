package es.inetum.curso0.modelo;

import es.inetum.curso0.module.PiedraPapelTijeraFactory;

public class Spock extends PiedraPapelTijeraFactory {
	public Spock() {
		this("spock", PiedraPapelTijeraFactory.SPOCK);
	}
	public Spock(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int numero) {
		return numero == SPOCK;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {	
		
		case TIJERA:
		case PIEDRA:
			result=1;
			this.descripcionResultado = "spock le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PAPEL:
        case LAGARTO:
        	result=-1;
			this.descripcionResultado = "spock perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionResultado = "spock empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
