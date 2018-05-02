package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Laboratorio unidad 5-6
 * Mundial FIFA
 * @author Juan Felipe Castillo
 * Codigo: A003488979
 * Panel que contiene los botones usados por el PanelVerJugador
 */
public class PanelOpcionesJugador extends JPanel implements ActionListener{
	
	public static final String AGREGAR = "agregar";
	public static final String ELIMINAR = "eliminar";
	public static final String BUSCAR = "buscar";
	public static final String MODIFICAR = "modificar";
	
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private PanelVerJugador pVerJugador;
	

	public PanelOpcionesJugador(PanelVerJugador pVer) {
		setLayout(new GridLayout(1, 4));
		pVerJugador = pVer;
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


	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(AGREGAR)) {
			pVerJugador.mostrarVentanaJugador();
		}
		else if (evento.equals(ELIMINAR)) {
			pVerJugador.eliminarJugador();
		}
		else if (evento.equals(BUSCAR)) {
			pVerJugador.buscarJugador();
		}
		else if (evento.equals(MODIFICAR)) {
			pVerJugador.modificarJugador();
			
		}
		
	}
	

}
