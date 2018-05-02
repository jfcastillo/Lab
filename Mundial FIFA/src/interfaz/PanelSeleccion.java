package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Seleccion;

import java.awt.*;

/**
 * Laboratorio unidad 5-6 Mundial FIFA
 * 
 * @author Juan Felipe Castillo Codigo: A003488979 
 * Panel principal de las selecciones que contiene una tabla y la relación con el panel de botones.
 *
 */
public class PanelSeleccion extends JPanel implements ListSelectionListener{
	public static String[] TITULOS = { "Selecciones" };
	private JList listaSelecciones;
	private JLabel lblTitulo;
	private DefaultListModel modeloLista;
	private JScrollPane scroll;
	private PanelOpcionesSeleccion pOpcionesSelecciones;
	private VentanaPrincipal vPrincipal;
	

	public PanelSeleccion(VentanaPrincipal ven) {
		setLayout(new BorderLayout());

		pOpcionesSelecciones = new PanelOpcionesSeleccion(this);
		vPrincipal = ven;
		
		listaSelecciones = new JList();
		listaSelecciones.getSelectionModel().addListSelectionListener(this);
	
		modeloLista = new DefaultListModel();
		
		lblTitulo = new JLabel("Selecciones");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		scroll = new JScrollPane(listaSelecciones);
		add(lblTitulo, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(pOpcionesSelecciones, BorderLayout.SOUTH);

	}
	
	public VentanaPrincipal darPrincipal() {
		return  vPrincipal;
	}

	public void modificarTabla(ArrayList<Seleccion> selec) {
		modeloLista.clear();

		for (int i = 0; i < selec.size(); i++) {
		modeloLista.addElement(selec.get(i));
		}

		listaSelecciones.setModel(modeloLista);

	}
	public void limpiarTabla() {
		modeloLista.clear();
	}
	
	public void mostrarVentanaDatos() {
		vPrincipal.mostrarVentanaDatos();
	}

	/**
	 * Evento para modificar la lista de jugadores al cambiar de selección
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		if (!lsm.isSelectionEmpty()) {
			Seleccion sel = (Seleccion)listaSelecciones.getSelectedValue();
			vPrincipal.verJugadores();
		}		
	}
	/**
	 * Elimina una selección de la lista enlazada
	 */
	public void eliminarSeleccion(Seleccion sele) {
		if (getSeleccion() == null) {
			JOptionPane.showMessageDialog(null, "Seleccione la selección que desea eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			vPrincipal.eliminarSeleccion(sele);
		}
		
	}
	public void modificarSeleccion() {
		if (getSeleccion() == null) {
			JOptionPane.showMessageDialog(null, "Seleccione la selección que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			vPrincipal.abrirModificarSeleccion(getSeleccion());
		}
		
	}

	public Seleccion getSeleccion() {
		return (Seleccion)listaSelecciones.getSelectedValue();
	}
//	public void agregarSeleccion(String pais, double puntos, String imagen) {
//		vPrincipal.agregarSeleccion(pais, puntos, imagen);
//	}

}
