package es.edu.alter.practica0.modelo;

public class Spock extends PiedraPapelTieraFactory {
	public Spock() {
		this("spock", PiedraPapelTieraFactory.SPOCK);
	}
	public Spock(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int numero) {
		return numero == SPOCK;
	}

	@Override
	public int comparar(PiedraPapelTieraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {	
		
		case TIJERA:
		case PIEDRA:
			result=1;
			this.descripcionREsultado = "spock le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PAPEL:
        case LAGARTO:
        	result=-1;
			this.descripcionREsultado = "spock perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionREsultado = "spock empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
