package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Jugador;
import modelo.Seleccion;

/**
 * Laboratorio unidad 5-6
 * Mundial FIFA
 * @author Juan Felipe Castillo
 * Codigo: A003488979
 * Panel que contiene los paneles de la informacion del jugador y los botones
 */
public class PanelInfoJugador extends JPanel{
	
	private PanelDatosJugador pDatosJugador;
	private PanelOpcionesInformacion pOpcionesInfo;
	private VentanaPrincipal vPrincipal;

	public PanelInfoJugador(VentanaPrincipal vPrin) {
		vPrincipal = vPrin;
		setLayout(new BorderLayout());
		pDatosJugador = new PanelDatosJugador();
		pOpcionesInfo = new PanelOpcionesInformacion(this);
		add(pDatosJugador,BorderLayout.CENTER);
		add(pOpcionesInfo,BorderLayout.SOUTH);
		
	}
	public void llenarDatosJugador(String imagen, String nombre, String posicion, double puntaje, String fechaNacimiento, double altura) {
		pDatosJugador.llenarDatos(imagen, nombre, posicion, puntaje, fechaNacimiento, altura);
	}
	public void cambiarTituloPDatos(String nombre) {
		pDatosJugador.cambiarTitulo(nombre);
	}
	public void getSiguienteJugador() {
		vPrincipal.getSiguienteJugador();
	}
	public void getAnteriorJugador() {
		vPrincipal.getAnteriorJugador();
	}
	public void getPrimerJugador() {
		vPrincipal.getPrimerJugador();
	}

	public String getNombre() {
		return pDatosJugador.getNombre();
	}
}
