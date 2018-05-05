package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Fifa;
import modelo.NoExisteException;
import modelo.Seleccion;

public class TestFifa extends TestCase{

	private Fifa laFifa;
	
	
	public void escenario1() {
		laFifa = new Fifa();
	}
	public void escenario2() {
		escenario1();
		laFifa.agregarSeleccion("Argentina", 1020.30, "Argentina");
		laFifa.agregarSeleccion("Brasil", 1059.630, "Brasil");
		laFifa.agregarSeleccion("Colombia", 958.30, "Colombia");
	}
	@Test
	public void testAgregarSeleccion() {
		escenario1();
		laFifa.agregarSeleccion("Camerun", 1020.30, "Argentina");
		assertEquals(2, laFifa.getNumeroSelecciones());
	}
	
	@Test
	public void testDarSelecciones() {
		escenario2();
		
		try {
			assertEquals(4, laFifa.darSelecciones().size());
		} catch (NoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testBuscarSeleccion() {
		escenario2();
		try {
			ArrayList<Seleccion> sele = laFifa.buscarSeleccion("Argentina");
			assertEquals("Argentina",sele.get(0).getPais());
		} catch (NoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testEliminarSeleccion() {
		escenario2();
		try {
			Seleccion sele = laFifa.buscarSeleccion("Argentina").get(0);
			System.out.println(sele.toString());
			laFifa.eliminarSeleccion(sele);
			assertEquals(3, laFifa.getNumeroSelecciones());
		} catch (NoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
