package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Fifa;
import modelo.Jugador;
import modelo.NoExisteException;
import modelo.NoExisteJugadorException;
import modelo.Seleccion;
/**
 * Laboratorio unidad 5-6
 * Mundial FIFA
 * @author Juan Felipe Castillo
 * Codigo: A003488979
 * Frame principal de la interfaz, que contiene los 3 paneles principales.
 * Panel de selecciones, Panel para ver los jugadores de cada seleccion 
 * y otro para ver la información de un jugador
 *
 */
public class VentanaPrincipal extends JFrame {
	private Fifa laFifa;
	private PanelSeleccion pSeleccion;
	private PanelVerJugador pJugador;
	private PanelInfoJugador pInfoJugador;
	private VentanaDatosSeleccion vDatos;
	private VentanaAgregarJugador vAddJugador;

	public VentanaPrincipal() {
		
		super("Copa Mundial de la FIFA");
		setLayout(new BorderLayout());
		

		laFifa = new Fifa();
		pSeleccion = new PanelSeleccion(this);
		pJugador = new PanelVerJugador(this);
		pInfoJugador = new PanelInfoJugador(this);
		vDatos = new VentanaDatosSeleccion(this);
		vAddJugador = new VentanaAgregarJugador(this);
			
		add(pSeleccion,BorderLayout.WEST);
		add(pJugador, BorderLayout.CENTER);
		add(pInfoJugador, BorderLayout.EAST);
		verSelecciones();		
		pack();		
	}
	public Fifa darFifa() {
		return laFifa;
	}
	
	public void agregarSeleccion(String pais, double puntos, String imagen) {
		laFifa.agregarSeleccion(pais, puntos, imagen);
	}
	

	public void verSelecciones() {
		try {			
			pSeleccion.modificarTabla(laFifa.darSelecciones());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	/**
	 * Metodo para visualizar todos los jugadores de una selección 
	 * en PanelSeleccion
	 */
	public void verJugadores() {
		pJugador.limpiarTabla();
		try {
			pJugador.modificarTabla(laFifa.darJugadores(pSeleccion.getSeleccion()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/**
	 * Muestra la ventana para agregar una selección
	 */
	public void mostrarVentanaDatos() {
		vDatos.setVisible(true);
	}
	/**
	 * Muestra la ventana para agregar un juego a una seleccion
	 */
	public void mostrarVentanaJugador() {
		vAddJugador.setVisible(true);
	}
	public void agregarJugadorSinBuscar(String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
		Seleccion sele = pSeleccion.getSeleccion();
		laFifa.agregarJugadorSinBuscar(sele, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
		vAddJugador.limpiarCampos();
	}
	
	public void buscarSeleccion(String nombreSeleccion) {
		try {
			ArrayList<Seleccion> encontrada = laFifa.buscarSeleccion(nombreSeleccion);
			if (encontrada == null) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado la selección", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				pSeleccion.modificarTabla(encontrada);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void eliminarSeleccion(Seleccion sele) {
		try {
			laFifa.eliminarSeleccion(sele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			verSelecciones();
		}		
	}
	public void abrirModificarSeleccion(Seleccion sele) {
		laFifa.calcularPromedios(sele);
		vDatos.llenarCampos(sele.getPais(), sele.getPuntos(), sele.getPromedioAltura(), sele.getPromedioEdad(), sele.getPromedioFifa(), sele.getImagen());
		vDatos.setVisible(true);
	}
	public void modificarSeleccion(String pais, double puntos,String imagen) {
		Seleccion sele = pSeleccion.getSeleccion();
		laFifa.modificarSeleccion(sele, pais, puntos, imagen);
		verSelecciones();
		vAddJugador.limpiarCampos();
	}
	
	public void verInformacionJugador(Jugador jug) {
		String imagen = jug.getImagen();
		String nombre = jug.getNombreJugador();
		String posicion = jug.getPosicion();
		double puntaje = jug.getPuntajeFifa();
		String fechaNacimiento = jug.getFechaNacimiento();
		double altura = jug.getAltura();
		pInfoJugador.llenarDatosJugador(imagen, nombre, posicion, puntaje, fechaNacimiento, altura);
		pInfoJugador.cambiarTituloPDatos(nombre);
	}
	
	public void eliminarJugador(Jugador jug) {
		Seleccion selec = pSeleccion.getSeleccion();
		laFifa.eliminarJugador(selec, jug);
		verJugadores();
	}
	
	public void abrirModificarJugador(Jugador juga) {		
		String imagen = juga.getImagen();
		String nombreJugador = juga.getNombreJugador();
		String posicion = juga.getPosicion();
		double puntajeFifa = juga.getPuntajeFifa();
		String fechaNacimiento = juga.getFechaNacimiento();
		double altura = juga.getAltura();
		vAddJugador.llenarCampos(imagen, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura);
		vAddJugador.setVisible(true);
		
	}
	public void modificarJugador(String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
		Seleccion sele = pSeleccion.getSeleccion();
		Jugador jug = pJugador.getJugador();
		laFifa.modificarJugador(sele, jug, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
		verJugadores();
	}
	public void buscarJugador(String nombreJugador) {
		try {
			Jugador juga = laFifa.buscarJugador(pSeleccion.getSeleccion(), nombreJugador);
			if (juga == null) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el jugador", "Error", JOptionPane.WARNING_MESSAGE);
				
			}
			else
				pJugador.verJugadorEncontrado(juga);
			
		} catch (NoExisteJugadorException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		

	}
	
	public void getSiguienteJugador() {
		Seleccion sele = pSeleccion.getSeleccion();
		Jugador actual = pJugador.getJugador();
		String nombre  = pInfoJugador.getNombre();
		if (sele == null) {
			JOptionPane.showMessageDialog(null, "Seleccione una selección", "Error", JOptionPane.WARNING_MESSAGE);
		}
		else {			
			if (nombre.length()<1) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un jugador primero", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Jugador siguiente = laFifa.buscarJugadorSiguiente(sele, nombre);
				String imagen = siguiente.getImagen();
				String nombreJugador = siguiente.getNombreJugador();
				String posicion = siguiente.getPosicion();
				double puntajeFifa = siguiente.getPuntajeFifa();
				String fechaNacimiento = siguiente.getFechaNacimiento();
				double altura = siguiente.getAltura();
				pInfoJugador.llenarDatosJugador(imagen, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura);
			}
		}
		
	}
	public void getAnteriorJugador( ) {
		Seleccion sele = pSeleccion.getSeleccion();
		Jugador actual = pJugador.getJugador();
		String nombre  = pInfoJugador.getNombre();
		if (sele == null) {
			JOptionPane.showMessageDialog(null, "Seleccione una selección", "Error", JOptionPane.WARNING_MESSAGE);
		}
		else {			
			if (nombre.length()<1) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un jugador primero", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Jugador anterior = laFifa.buscarJugadorAnterior(sele, nombre);
				String imagen = anterior.getImagen();
				String nombreJugador = anterior.getNombreJugador();
				String posicion = anterior.getPosicion();
				double puntajeFifa = anterior.getPuntajeFifa();
				String fechaNacimiento = anterior.getFechaNacimiento();
				double altura = anterior.getAltura();
				pInfoJugador.llenarDatosJugador(imagen, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura);
			}
		}
		
	}
	public void getPrimerJugador() {	
		Seleccion sele = pSeleccion.getSeleccion();
		if (sele == null) {
			JOptionPane.showMessageDialog(null, "Seleccione una selección", "Error", JOptionPane.WARNING_MESSAGE);
		}
		else {
			Jugador juga = sele.getPrimerJugador();
			if (juga == null) {
				JOptionPane.showMessageDialog(null, "No ha agregado ningun jugador", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else {
				String imagen = juga.getImagen();
				String nombreJugador = juga.getNombreJugador();
				String posicion = juga.getPosicion();
				double puntajeFifa = juga.getPuntajeFifa();
				String fechaNacimiento = juga.getFechaNacimiento();
				double altura = juga.getAltura();
				pInfoJugador.llenarDatosJugador(imagen, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura);
			}
		}
		
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
