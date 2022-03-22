package es.edu.alter.practica0.modelo;

public class Tijera extends PiedraPapelTieraFactory {
	public Tijera() {
		this("tijera",PiedraPapelTieraFactory.TIJERA);
	}
	
	public Tijera(String nombre, int numero) {
		super(nombre, numero);
	}

	@Override
	public boolean isMe(int numero) {
		return numero==TIJERA;
	}

	@Override
	public int comparar(PiedraPapelTieraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {
		case PAPEL:
		case LAGARTO:
			result=1;
			this.descripcionREsultado = "tijera le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PIEDRA:
        case SPOCK:
        	result=-1;
			this.descripcionREsultado = "tijera perdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionREsultado = "tijera empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
