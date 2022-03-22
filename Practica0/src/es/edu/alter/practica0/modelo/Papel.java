package es.edu.alter.practica0.modelo;

public class Papel extends PiedraPapelTieraFactory {
	public Papel() {
		this("papel", PiedraPapelTieraFactory.PAPEL);
	}
	public Papel(String nombre, int numero) {
		super(nombre,numero);
		
	}

	@Override
	public boolean isMe(int numero) {
		return numero==PAPEL;
	}

	@Override
	public int comparar(PiedraPapelTieraFactory pPiedPapelTijera) {
		int result=0;
		switch (pPiedPapelTijera.getNumero()) {
		case PIEDRA:
		case SPOCK:	
			result=1;
			this.descripcionREsultado ="Papel le gano a " + pPiedPapelTijera.getNombre();
			break ;
		case TIJERA:
		case LAGARTO:	
			result=-1;
			this.descripcionREsultado ="Papel perdió con " + pPiedPapelTijera.getNombre();
			break;
		default:			
			result=0;
			this.descripcionREsultado = "Papel empata con " + pPiedPapelTijera.getNombre();
			break;
		}
		return result;
	}

}
