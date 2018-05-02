package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Laboratorio unidad 5-6 Mundial FIFA
 * 
 * @author Juan Felipe Castillo Codigo: A003488979 Panel que contiene los
 *         botones usados por el PanelSeleccion
 */
public class PanelOpcionesSeleccion extends JPanel implements ActionListener {

	public static final String AGREGAR = "agregar";
	public static final String ELIMINAR = "eliminar";
	public static final String BUSCAR = "buscar";
	public static final String MODIFICAR = "modificar";

	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private PanelSeleccion pSeleccion;

	public PanelOpcionesSeleccion(PanelSeleccion pSele) {
		setLayout(new GridLayout(1, 4));
		pSeleccion = pSele;
		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setActionCommand(ELIMINAR);
		btnEliminar.addActionListener(this);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(BUSCAR);
		btnBuscar.addActionListener(this);
		btnModificar = new JButton("Modificar");
		btnModificar.setActionCommand(MODIFICAR);
		btnModificar.addActionListener(this);
		add(btnAgregar);
		add(btnEliminar);
		add(btnBuscar);
		add(btnModificar);
	}

	public PanelSeleccion darPanelSeleccion() {
		return pSeleccion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(AGREGAR)) {
			pSeleccion.mostrarVentanaDatos();
		}
		else if (comando.equals(ELIMINAR)) {
			pSeleccion.eliminarSeleccion(pSeleccion.getSeleccion());
		}
		else if (comando.equals(MODIFICAR)) {
			pSeleccion.modificarSeleccion();					
		}
		else if (comando.equals(BUSCAR)) {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la selección que desea buscar", "Buscar selección");
			pSeleccion.darPrincipal().buscarSeleccion(nombre);
		}

	}

	// public void agregarSeleccion(String pais, double puntos, String imagen) {
	// pSeleccion.agregarSeleccion(pais, puntos, imagen);
	//
	// }

}
