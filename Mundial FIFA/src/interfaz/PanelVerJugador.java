package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jdk.nashorn.internal.scripts.JS;
import modelo.Jugador;
import modelo.Seleccion;
/**
 * Laboratorio unidad 5-6
 * Mundial FIFA
 * @author Juan Felipe Castillo
 * Codigo: A003488979
 * Panel que contiene la tabla para ver los jugadores de la seleccion y 
 * los botones.
 */
public class PanelVerJugador extends JPanel implements ListSelectionListener{
	public static String[] TITULOS = {"Jugadores"};
	private JList listaJugadores;
	private JLabel lblTitulo;
	private DefaultListModel modeloLista;
	private JScrollPane scroll;
	private PanelOpcionesJugador pOpcionesJugador;
	private VentanaPrincipal vPrincipal;

	public PanelVerJugador(VentanaPrincipal vPrin)  {
		setLayout(new BorderLayout());
		pOpcionesJugador = new PanelOpcionesJugador(this);
		vPrincipal = vPrin;
		listaJugadores = new JList();
		listaJugadores.getSelectionModel().addListSelectionListener(this);
		
		modeloLista = new DefaultListModel();
		
		lblTitulo = new JLabel("Jugadores");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		scroll = new JScrollPane(listaJugadores);
		add(lblTitulo, BorderLayout.NORTH);		
		add(scroll, BorderLayout.CENTER);
		add(pOpcionesJugador, BorderLayout.SOUTH);
	}
	public void mostrarVentanaJugador() {
		vPrincipal.mostrarVentanaJugador();
	}
	public void modificarTabla(ArrayList<Jugador> juga) {
		modeloLista.clear();

		for (int i = 0; i < juga.size(); i++) {
		modeloLista.addElement(juga.get(i));
		}

		listaJugadores.setModel(modeloLista);

	}
	public void verJugadorEncontrado(Jugador jug) {
		modeloLista.clear();
		modeloLista.addElement(jug);
		listaJugadores.setModel(modeloLista);
	}
	public Jugador getJugador() {
		return (Jugador)listaJugadores.getSelectedValue();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		if (!lsm.isSelectionEmpty()) {
			Jugador jug = getJugador();
			vPrincipal.verInformacionJugador(jug);
		}		
	}
	public void limpiarTabla() {
		modeloLista.clear();
	}
	public void eliminarJugador() {
		if (getJugador() == null) {
			JOptionPane.showMessageDialog(null, "Seleccione el jugador que desea eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			vPrincipal.eliminarJugador(getJugador());
		}
		
	}
	public void modificarJugador() {
		if (getJugador() == null) {
			JOptionPane.showMessageDialog(null, "Seleccione el jugador que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			vPrincipal.abrirModificarJugador(getJugador());
		}
		
	}
	public void buscarJugador() {
		String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador que desea buscar", "Buscar jugador");
		vPrincipal.buscarJugador(nombreJugador);
	}
	public int darIndexSeleccion() {
		return listaJugadores.getSelectedIndex();
	}
	public void seleccionarJugador(int index) {
		listaJugadores.setSelectedIndex(index);
	}

}
