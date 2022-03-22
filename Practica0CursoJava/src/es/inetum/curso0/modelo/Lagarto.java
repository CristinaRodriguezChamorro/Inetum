package es.inetum.curso0.modelo;
import es.inetum.curso0.module.PiedraPapelTijeraFactory;

public class Lagarto extends PiedraPapelTijeraFactory {
	public Lagarto() {
		this("lagarto", PiedraPapelTijeraFactory.LAGARTO);
	}

	
	public Lagarto(String nombre, int numero) {
		super(nombre, numero);
	}


	@Override
	public boolean isMe(int numero) {
		return numero==LAGARTO;
	}

	@Override
	public int comparar(PiedraPapelTijeraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {		
		case PAPEL:
		case SPOCK:
			result=1;
			this.descripcionResultado = "lagarto le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PIEDRA:
        case TIJERA:
        	result=-1;
			this.descripcionResultado = "lagarto perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionResultado = "lagarto empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}

}
