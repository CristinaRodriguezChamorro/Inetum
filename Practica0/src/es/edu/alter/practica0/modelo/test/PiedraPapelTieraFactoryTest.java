package es.edu.alter.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.edu.alter.practica0.modelo.Lagarto;
import es.edu.alter.practica0.modelo.Papel;
import es.edu.alter.practica0.modelo.Piedra;
import es.edu.alter.practica0.modelo.PiedraPapelTieraFactory;
import es.edu.alter.practica0.modelo.Spock;
import es.edu.alter.practica0.modelo.Tijera;

class PiedraPapelTieraFactoryTest {
	//1- lote pruebas
	PiedraPapelTieraFactory piedra, papel,tijera, lagarto, spock;

	@BeforeEach
	void setUp() throws Exception {
		//se ejecuta antes de cada prueba
		piedra 	= new Piedra()	;
		papel 	= new Papel()	;
		tijera 	= new Tijera()	;
		//dos nuevos
		lagarto = new Lagarto()	;
		spock 	= new Spock()	;
	}

	@AfterEach
	void tearDown() throws Exception {
		//se ejecuta despues de cada prueba
		piedra = null;
		papel  = null;
		tijera = null;
		//
		lagarto = null;
		spock 	= null;
	}

	@Test
	void testGetInstancePiedra() {
		assertEquals("piedra", PiedraPapelTieraFactory.getInstance(PiedraPapelTieraFactory.PIEDRA)
													  .getNombre()
													  .toLowerCase());
		
	}
	@Test
	void testGetInstancePapel() {
		assertEquals("papel", PiedraPapelTieraFactory.getInstance(PiedraPapelTieraFactory.PAPEL)
													  .getNombre()
													  .toLowerCase());		
	}

	@Test
	void testGetInstanceTiera() {
		assertEquals("tijera", PiedraPapelTieraFactory.getInstance(PiedraPapelTieraFactory.TIJERA)
													  .getNombre()
													  .toLowerCase());		
	}
	
	@Test
	void testGetInstanceLagarto() {
		assertEquals("lagarto", PiedraPapelTieraFactory.getInstance(PiedraPapelTieraFactory.LAGARTO)
													  .getNombre()
													  .toLowerCase());		
	}
	@Test
	void testGetInstanceSpock() {
		assertEquals("spock", PiedraPapelTieraFactory.getInstance(PiedraPapelTieraFactory.SPOCK)
													  .getNombre()
													  .toLowerCase());		
	}
	
	 //Casos de PIEDRA
	
	@Test
	void testCompararPiedraGanaATijera() {
		//TODO para mis queridos alumnos testCompararPiedraGanaATijera
		assertEquals(1, piedra.comparar(tijera));
		assertEquals("piedra le gana a tijera", piedra.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraGanaALagarto() {
		//TODO para mis queridos alumnos CompararPiedraEmpataConPiedra, agregar el texto del empate en todos loados
		assertEquals(1, piedra.comparar(lagarto));
		assertEquals("piedra le gana a lagarto", piedra.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraPierdeConPapel() {
		assertEquals(-1, piedra.comparar(papel));
		assertEquals("piedra pierdió con papel", piedra.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraPierdeConSpock() {
		//TODO para mis queridos alumnos CompararPiedraEmpataConPiedra, agregar el texto del empate en todos loados
		assertEquals(-1, piedra.comparar(spock));
		assertEquals("piedra pierdió con spock", piedra.getDescripcionREsultado()
													  .toLowerCase());
	}
	
	@Test
	void testCompararPiedraEmpataConPiedra() {
		//TODO para mis queridos alumnos CompararPiedraEmpataConPiedra, agregar el texto del empate en todos loados
		assertEquals(0, piedra.comparar(piedra));
		assertEquals("piedra empata con piedra", piedra.getDescripcionREsultado()
													  .toLowerCase());
	}
	
	//Casos de PAPEL
	@Test
	void testCompararPapelGanaConPiedra() {
		//TODO para mis queridos alumnos testCompararPapelGanaConPiedra
		assertEquals(1, papel.comparar(piedra));
		assertEquals("papel le gano a piedra", papel.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testPapelGanaSpock() {
		assertEquals(1, papel.comparar(spock));
		assertEquals("papel le gano a spock", papel.getDescripcionREsultado()
				  							 	.toLowerCase());
	}
	@Test
	void testCompararPapelPierdeConTijera() {
		//TODO para mis queridos alumnos testCompararPapelPierdeConTijera
		assertEquals(-1, papel.comparar(tijera));
		assertEquals("papel perdió con tijera", papel.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testPapelPierdeConLagarto() {
		assertEquals(-1, papel.comparar(lagarto));
		assertEquals("papel perdió con lagarto", papel.getDescripcionREsultado()
				  							 	.toLowerCase());
	}
	@Test
	void testCompararPapelEmpataConPapel() {
		//TODO para mis queridos alumnos testCompararPapelEmpataConPapel
		assertEquals(0, papel.comparar(papel));
		assertEquals("papel empata con papel", papel.getDescripcionREsultado()
													  .toLowerCase());
	}
	

	//Casos de TIJERA
	@Test
	void testCompararTijeraGanaAPapel() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, tijera.comparar(papel));
		assertEquals("tijera le gana a papel", tijera.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraGanaALagarto() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, tijera.comparar(lagarto));
		assertEquals("tijera le gana a lagarto", tijera.getDescripcionREsultado()
													  .toLowerCase());
	}
	
	@Test
	void testCompararTijeraPierdeConPiedra() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, tijera.comparar(piedra));
		assertEquals("tijera perdió con piedra", tijera.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraPierdeConSpock() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, tijera.comparar(spock));
		assertEquals("tijera perdió con spock", tijera.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraEmpataConTijera() {
		//TODO para mis queridos alumnos testCompararTijeraEmpataConTiera 
		assertEquals(0, tijera.comparar(tijera));
		assertEquals("tijera empata con tijera", tijera.getDescripcionREsultado()
													  .toLowerCase());
	}	
	
	//Casos de LAGARTO
	@Test
	void testCompararLagartoGanaASpock() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, lagarto.comparar(spock));
		assertEquals("lagarto le gana a spock", lagarto.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararLagartoGanaAPapel() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, lagarto.comparar(papel));
		assertEquals("lagarto le gana a papel", lagarto.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararLagartoPierdeConTijera() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, lagarto.comparar(tijera));
		assertEquals("lagarto perdió con tijera", lagarto.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararLagartoPierdeConPiedra() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, lagarto.comparar(piedra));
		assertEquals("lagarto perdió con piedra", lagarto.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararLagartoEmpataConLagarto() {
		//TODO para mis queridos alumnos testCompararTijeraEmpataConTiera 
		assertEquals(0, lagarto.comparar(lagarto));
		assertEquals("lagarto empata con lagarto", lagarto.getDescripcionREsultado()
													  .toLowerCase());
	}	
	
	//Casos de SPOCK
	@Test
	void testCompararSpockGanaATijera() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, spock.comparar(tijera));
		assertEquals("spock le gana a tijera", spock.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararSpockGanaATPiedra() {
		//TODO para mis queridos alumnos testCompararTijeraGanaAPapel() 
		assertEquals(1, spock.comparar(piedra));
		assertEquals("spock le gana a piedra", spock.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararSpockPierdeConPapel() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, spock.comparar(papel));
		assertEquals("spock perdió con papel", spock.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararSpockPierdeConLagarto() {
		//TODO para mis queridos alumnos testCompararTijeraPierdeConPiedra 
		assertEquals(-1, spock.comparar(lagarto));
		assertEquals("spock perdió con lagarto", spock.getDescripcionREsultado()
													  .toLowerCase());
	}
	@Test
	void testCompararSpockEmpataConSpock() {
		//TODO para mis queridos alumnos testCompararTijeraEmpataConTiera 
		assertEquals(0, spock.comparar(spock));
		assertEquals("spock empata con spock", spock.getDescripcionREsultado()
													  .toLowerCase());
	}
	
}
