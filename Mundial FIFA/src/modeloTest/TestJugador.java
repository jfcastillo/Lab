package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;

public class TestJugador {

	private Jugador jug;
	
	public void escenario3() {
		jug = new Jugador("Radamel", "delantero", 1360.2, "20/12/1990", 1.75, "james");
	}
	@Test
	public void testModificarJugador() {
		escenario3();
		jug.modificarJugador("Radamel", "delantero", 1210.26, "15/06/1989", 1.85, "falcao");
		assertEquals("falcao", jug.getImagen());
	}
	

}
