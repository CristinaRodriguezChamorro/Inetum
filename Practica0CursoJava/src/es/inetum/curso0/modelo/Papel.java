package es.inetum.curso0.modelo;

import es.inetum.curso0.module.PiedraPapelTijeraFactory;

public class Papel extends PiedraPapelTijeraFactory {
	public Papel() {
		this("papel", PiedraPapelTijeraFactory.PAPEL);
	}
	public Papel(String nombre, int numero) {
		super(nombre,numero);
		
	}

	@Override
	public boolean isMe(int numero) {
		return numero==PAPEL;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {
		case PIEDRA:
		case SPOCK:	
			result=1;
			this.descripcionResultado ="Papel le gano a " + pPiedPapelTijera.getNombre();
			break ;
		case TIJERA:
		case LAGARTO:	
			result=-1;
			this.descripcionResultado ="Papel perdió con " + pPiedPapelTijera.getNombre();
			break;
		default:			
			result=0;
			this.descripcionResultado = "Papel empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}

}
