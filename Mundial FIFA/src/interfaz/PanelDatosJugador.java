package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * Laboratorio unidad 5-6
 * Mundial FIFA
 * @author Juan Felipe Castillo
 * Codigo: A003488979
 * Panel que contiene los campos para mostrar y pedir la informacion de un jugador.
 */
public class PanelDatosJugador extends JPanel {
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JLabel lblPosicion;
	private JLabel lblPuntaje;
	private JLabel lblFechaNac;
	private JLabel lblAltura;
	private JTextField txtImagen;
	private JTextField txtNombre;
	private JTextField txtPosicion;
	private JTextField txtPuntaje;
	private JTextField txtFechaNac;
	private JTextField txtAltura;
	private TitledBorder border;

	public PanelDatosJugador() {
		
		setLayout(new GridLayout(6,2));
		setSize(new Dimension(300, 600));
		
		lblImagen = new JLabel("Imagen");
		lblNombre = new JLabel("Nombre");
		lblPosicion = new JLabel("Posicion");
		lblPuntaje = new JLabel("Puntaje");
		lblFechaNac = new JLabel("Fecha de nacimiento");
		lblAltura = new JLabel("Altura");
		txtImagen = new JTextField();
		txtNombre = new JTextField();
		txtPosicion = new JTextField();
		txtPuntaje = new JTextField();
		txtFechaNac = new JTextField();
		txtAltura = new JTextField();
		add(lblImagen);
		add(txtImagen);
		add(lblNombre);
		add(txtNombre);
		add(lblPosicion);
		add(txtPosicion);
		add(lblPuntaje);
		add(txtPuntaje);
		add(lblFechaNac);
		add(txtFechaNac);
		add(lblAltura);
		add(txtAltura);
	}
	
	public void llenarDatos(String imagen, String nombre, String posicion, double puntaje, String fechaNacimiento, double altura) {
		txtImagen.setText(imagen);
		txtNombre.setText(nombre);
		txtPosicion.setText(posicion);
		txtPuntaje.setText(puntaje+"");
		txtFechaNac.setText(fechaNacimiento);
		txtAltura.setText(altura+"");
	}
	public void cambiarTitulo(String nombre) {
		border = new TitledBorder(nombre);
		setBorder(border);
	}
	public String getNombre() {
		return txtNombre.getText();
	}

}
