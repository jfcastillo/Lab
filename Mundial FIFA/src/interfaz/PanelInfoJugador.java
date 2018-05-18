package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	private JLabel lblImagen;

	public PanelInfoJugador(VentanaPrincipal vPrin) {
		vPrincipal = vPrin;
		setLayout(new BorderLayout());
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("img/transparente.png"));
		pDatosJugador = new PanelDatosJugador();
		pOpcionesInfo = new PanelOpcionesInformacion(this);
		add(lblImagen, BorderLayout.NORTH);
		add(pDatosJugador,BorderLayout.CENTER);
		add(pOpcionesInfo,BorderLayout.SOUTH);
		
	}
	public void llenarDatosJugador(String imagen, String nombre, String posicion, double puntaje, String fechaNacimiento, double altura) {
		lblImagen.setIcon(new ImageIcon(imagen));
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
