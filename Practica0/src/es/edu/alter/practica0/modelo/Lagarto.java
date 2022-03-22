package es.edu.alter.practica0.modelo;

public class Lagarto extends PiedraPapelTieraFactory {
	public Lagarto() {
		this("lagarto", PiedraPapelTieraFactory.LAGARTO);
	}

	
	public Lagarto(String nombre, int numero) {
		super(nombre, numero);
	}


	@Override
	public boolean isMe(int numero) {
		return numero==LAGARTO;
	}

	@Override
	public int comparar(PiedraPapelTieraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {		
		case PAPEL:
		case SPOCK:
			result=1;
			this.descripcionREsultado = "lagarto le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PIEDRA:
        case TIJERA:
        	result=-1;
			this.descripcionREsultado = "lagarto perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionREsultado = "lagarto empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}

}
