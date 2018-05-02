package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaAgregarJugador extends JFrame implements ActionListener{
	public static final String AGREGAR = "agregar";
	public static final String MODIFICAR = "modificar";
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
	private JButton btnAgregar;
	private JButton btnModificar;
	private VentanaPrincipal vPrincipal;

	public VentanaAgregarJugador(VentanaPrincipal vPrin) {
		setLayout(new GridLayout(7, 2));
		setTitle("Agregar jugador");
		setVisible(false);
		vPrincipal = vPrin;
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
		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		btnModificar = new JButton("Modificar");
		btnModificar.setActionCommand(MODIFICAR);
		btnModificar.addActionListener(this);
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
		add(btnAgregar);
		add(btnModificar);
		pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		String imagen = txtImagen.getText();
		String nombreJugador = txtNombre.getText();
		String posicion = txtPosicion.getText();
		double puntajeFifa = Double.parseDouble(txtPuntaje.getText());
		String fechaNacimiento = txtFechaNac.getText();
		double altura = Double.parseDouble(txtAltura.getText());
		if (evento.equals(AGREGAR)) {			
			
			vPrincipal.agregarJugadorSinBuscar(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
			vPrincipal.verJugadores();
		}
		else if (evento.equals(MODIFICAR)) {
			vPrincipal.modificarJugador(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
		}
		
	}
	public void llenarCampos(String imagen, String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento,double altura) {
		txtImagen.setText(imagen);
		txtNombre.setText(nombreJugador);
		txtPosicion.setText(posicion);
		txtPuntaje.setText(puntajeFifa+"");
		txtFechaNac.setText(fechaNacimiento);
		txtAltura.setText(altura+"");
	}
	public void limpiarCampos() {
		txtImagen.setText("");
		txtNombre.setText("");
		txtPosicion.setText("");
		txtPuntaje.setText("");
		txtFechaNac.setText("");
		txtAltura.setText("");
	}

}
