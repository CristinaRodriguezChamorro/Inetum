package es.inetum.curso0.modelo;

import es.inetum.curso0.module.PiedraPapelTijeraFactory;

public class Piedra extends PiedraPapelTijeraFactory {
	public Piedra() {
		this("piedra", PiedraPapelTijeraFactory.PIEDRA );
	}

	public Piedra(String nombre, int numero) {
		super(nombre, numero);		
	}

	@Override
	public boolean isMe(int numero) {
		return numero==PIEDRA;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {	
		
		case TIJERA:
		case LAGARTO:
			result=1;
			this.descripcionResultado = "piedra le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PAPEL:
        case SPOCK:
        	result=-1;
			this.descripcionResultado = "piedra perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionResultado = "piedra empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
