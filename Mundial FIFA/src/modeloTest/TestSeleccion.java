package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Jugador;
import modelo.NoExisteJugadorException;
import modelo.Seleccion;

public class TestSeleccion extends TestCase{
	private Seleccion selec;



	public void escenario2(){
		selec = new Seleccion("Argentina", 1020.30, "Argentina");
	}
	public void escenario3() {
		escenario2();
		selec.agregarJugador("James", "mediocampista", 1360.2, "20/12/1990", 1.75, "james");
		selec.agregarJugador("Yerri", "Defensa", 1360.2, "20/12/1990", 1.75, "yerri");
		selec.agregarJugador("Radamel", "delantero", 1360.2, "20/12/1990", 1.75, "james");
	}
	
	@Test
	public void testAgregarJugador() {
		escenario2();
		selec.agregarJugador("Messi", "Delantero", 120, "20/10/1991", 1.65, "Messi");
		assertEquals(1, selec.getCantidadJugadores());
	}
	@Test
	public void testBuscarJugador() {
		escenario3();	
		System.out.println(selec.getCantidadJugadores());
		try {
			
			Jugador jug = selec.buscarJugador("Yerri");
			assertEquals("Yerri", jug.getNombreJugador());
		} catch (NoExisteJugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
