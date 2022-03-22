package es.edu.alter.practica0.modelo;

public class Piedra extends PiedraPapelTieraFactory {
	public Piedra() {
		this("piedra", PiedraPapelTieraFactory.PIEDRA );
	}

	public Piedra(String nombre, int numero) {
		super(nombre, numero);		
	}

	@Override
	public boolean isMe(int numero) {
		return numero==PIEDRA;
	}

	@Override
	public int comparar(PiedraPapelTieraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {
		case TIJERA:
		case LAGARTO:
			result=1;
			this.descripcionREsultado = "piedra le gana a " + pPiedPapelTijera.getNombre();
			break;
			
        case PAPEL:
        case SPOCK:
        	result=-1;
			this.descripcionREsultado = "piedra pierdió con " + pPiedPapelTijera.getNombre();
			break;

		default:
			result=0;
			this.descripcionREsultado = "piedra empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}
}
