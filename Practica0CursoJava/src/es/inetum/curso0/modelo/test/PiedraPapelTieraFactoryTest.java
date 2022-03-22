package es.inetum.curso0.modelo.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import es.inetum.curso0.modelo.Lagarto;
import es.inetum.curso0.modelo.Papel;
import es.inetum.curso0.modelo.Piedra;
import es.inetum.curso0.modelo.Spock;
import es.inetum.curso0.modelo.Tijera;
import es.inetum.curso0.module.PiedraPapelTijeraFactory;

class PiedraPapelTijeraFactoryTest {
	PiedraPapelTijeraFactory piedra, papel,tijera, lagarto, spock;

	@BeforeEach
	void setUp() throws Exception {
		piedra 	= new Piedra();
		papel 	= new Papel();
		tijera 	= new Tijera();
		lagarto = new Lagarto();
		spock = new Spock();
	}

	@AfterEach
	void tearDown() throws Exception {
		piedra = null;
		papel  = null;
		tijera = null;
		lagarto = null;
		spock 	= null;
	}

	@Test
	void testGetInstancePiedra() {
		assertEquals("piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA)
													  .getNombre()
													  .toLowerCase());
		
	}
	@Test
	void testGetInstancePapel() {
		assertEquals("papel", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PAPEL)
													  .getNombre()
													  .toLowerCase());		
	}

	@Test
	void testGetInstanceTiera() {
		assertEquals("tijera", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.TIJERA)
													  .getNombre()
													  .toLowerCase());		
	}
	
	@Test
	void testGetInstanceLagarto() {
		assertEquals("lagarto", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.LAGARTO)
													  .getNombre()
													  .toLowerCase());		
	}
	@Test
	void testGetInstanceSpock() {
		assertEquals("spock",
				PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.SPOCK)
													  .getNombre()
													  .toLowerCase());		
	}
	
	 //Casos de PIEDRA
	
	@Test
	void testCompararPiedraGanaATijera() {
		assertEquals(1, piedra.comparar(tijera));
		assertEquals("piedra le gana a tijera", piedra.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraGanaALagarto() {
		assertEquals(1, piedra.comparar(lagarto));
		assertEquals("piedra le gana a lagarto", piedra.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraPierdeConPapel() {
		assertEquals(-1, piedra.comparar(papel));
		assertEquals("piedra perdió con papel", piedra.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararPiedraPierdeConSpock() {
		assertEquals(-1, piedra.comparar(spock));
		assertEquals("piedra perdió con spock", piedra.getDescripcionResultado()
													  .toLowerCase());
	}
	
	@Test
	void testCompararPiedraEmpataConPiedra() {
		assertEquals(0, piedra.comparar(piedra));
		assertEquals("piedra empata con piedra", piedra.getDescripcionResultado()
													  .toLowerCase());
	}
	
	//Casos de PAPEL
	@Test
	void testCompararPapelGanaConPiedra() {
		assertEquals(1, papel.comparar(piedra));
		assertEquals("papel le gano a piedra", papel.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testPapelGanaSpock() {
		assertEquals(1, papel.comparar(spock));
		assertEquals("papel le gano a spock", papel.getDescripcionResultado()
				  							 	.toLowerCase());
	}
	@Test
	void testCompararPapelPierdeConTijera() {
		assertEquals(-1, papel.comparar(tijera));
		assertEquals("papel perdió con tijera", papel.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testPapelPierdeConLagarto() {
		assertEquals(-1, papel.comparar(lagarto));
		assertEquals("papel perdió con lagarto", papel.getDescripcionResultado()
				  							 	.toLowerCase());
	}
	@Test
	void testCompararPapelEmpataConPapel() {
		assertEquals(0, papel.comparar(papel));
		assertEquals("papel empata con papel", papel.getDescripcionResultado()
													  .toLowerCase());
	}
	

	//Casos de TIJERA
	@Test
	void testCompararTijeraGanaAPapel() {
		assertEquals(1, tijera.comparar(papel));
		assertEquals("tijera le gana a papel", tijera.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraGanaALagarto() {
		assertEquals(1, tijera.comparar(lagarto));
		assertEquals("tijera le gana a lagarto", tijera.getDescripcionResultado()
													  .toLowerCase());
	}
	
	@Test
	void testCompararTijeraPierdeConPiedra() {
		assertEquals(-1, tijera.comparar(piedra));
		assertEquals("tijera perdió con piedra", tijera.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraPierdeConSpock() {
		assertEquals(-1, tijera.comparar(spock));
		assertEquals("tijera perdió con spock", tijera.getDescripcionResultado()
													  .toLowerCase());
	}
	@Test
	void testCompararTijeraEmpataConTijera() {
		assertEquals(0, tijera.comparar(tijera));
		assertEquals("tijera empata con tijera", tijera.getDescripcionResultado()
													  .toLowerCase());
	}	
}
