package es.inetum.curso0.modelo;


import es.inetum.curso0.module.PiedraPapelTijeraFactory;

public class Tijera extends PiedraPapelTijeraFactory {
	public Tijera() {
		this("tijera",PiedraPapelTijeraFactory.TIJERA);
	}
	
	public Tijera(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int numero) {
		return numero==TIJERA;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {
		case PAPEL:
		case LAGARTO:
			result=1;
			this.descripcionResultado = "tijera le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PIEDRA:
        case SPOCK:
        	result=-1;
			this.descripcionResultado = "tijera perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionResultado = "tijera empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
