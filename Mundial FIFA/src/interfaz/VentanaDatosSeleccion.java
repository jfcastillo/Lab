package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaDatosSeleccion extends JFrame implements ActionListener {
	public static final String AGREGAR = "add";
	public static final String MODIFICAR = "mod";
	
	private JLabel lblPais;
	private JLabel lblPuntos;
	private JLabel lblPromedioAltura;
	private JLabel lblPromedioEdad;
	private JLabel lblPromedioFifa;
	private JLabel lblImagen;
	
	private JTextField txtPais;
	private JTextField txtPuntos;	
	private JTextField txtPromedioAltura;
	private JTextField txtPromedioEdad;
	private JTextField txtPromedioFifa;
	private JTextField txtImagen;	
	
	private JButton btnGuardar;
	private JButton btnModificar;
	
	private VentanaPrincipal vPrincipal;

	public VentanaDatosSeleccion(VentanaPrincipal vPrin) {
		setLayout(new GridLayout(7,2));
		setVisible(false);
		lblPais = new JLabel("Pais");
		lblPuntos= new JLabel("Puntos");
		lblPromedioAltura= new JLabel("Promedio altura");
		lblPromedioEdad= new JLabel("Promedio edad");
		lblPromedioFifa= new JLabel("Promedio FIFA");
		lblImagen= new JLabel("Imagen");
		txtPais = new JTextField();
		txtPuntos = new JTextField();	
		txtPromedioAltura = new JTextField();
		txtPromedioAltura.setEnabled(false);
		txtPromedioEdad = new JTextField();
		txtPromedioEdad.setEnabled(false);
		txtPromedioFifa = new JTextField();
		txtPromedioFifa.setEnabled(false);
		txtImagen = new JTextField();	
		btnGuardar = new JButton("Agregar");
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand(AGREGAR);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand(MODIFICAR);
		vPrincipal = vPrin;
		
		add(lblPais);
		add(txtPais);
		add(lblPuntos);
		add(txtPuntos);
		add(lblPromedioAltura);
		add(txtPromedioAltura);
		add(lblPromedioEdad);
		add(txtPromedioEdad);
		add(lblPromedioFifa);
		add(txtPromedioFifa);		
		add(lblImagen);
		add(txtImagen);
		add(btnModificar);
		add(btnGuardar);
		
		pack();
	}
	

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(AGREGAR)) {
			String pais = txtPais.getText();
			double puntos = Double.parseDouble(txtPuntos.getText());
			String imagen = txtImagen.getText();
			vPrincipal.agregarSeleccion(pais, puntos, imagen);
			vPrincipal.verSelecciones();
			limpiarCampos();
		}
		else if (comando.equals(MODIFICAR)) {
			String pais = txtPais.getText();
			double puntos = Double.parseDouble(txtPuntos.getText());
			String imagen = txtImagen.getText();			
			vPrincipal.modificarSeleccion(pais, puntos, imagen);
			limpiarCampos();
		}
		
	}
	public void limpiarCampos() {
		txtPais.setText("");
		txtPuntos.setText("");;	
		txtPromedioAltura.setText("");
	    txtPromedioEdad.setText("");
		txtPromedioFifa.setText("");
		txtImagen.setText("");
	}
	public void llenarCampos(String pais, double puntos, double promedioAltura, double promedioEdad, double promedioFifa, String imagen) {
		txtPais.setText(pais);
		txtPuntos.setText(puntos+"");	
		txtPromedioAltura.setText(promedioAltura+"");
	    txtPromedioEdad.setText(promedioEdad+"");
		txtPromedioFifa.setText(promedioFifa+"");
		txtImagen.setText(imagen);
	}
	
	
	

}
