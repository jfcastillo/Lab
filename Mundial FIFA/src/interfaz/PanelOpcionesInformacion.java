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
 * Panel que contiene los botones para cambiar el jugador
 */
public class PanelOpcionesInformacion extends JPanel implements ActionListener{
	
	public static final String ANTERIOR = "ant";
	public static final String PRIMERO = "pr";
	public static final String SIGUIENTE = "sgt";
	
	private JButton btnAnterior;
	private JButton btnPrimero;
	private JButton btnSiguiente;
	private PanelInfoJugador pInfoJugador;
	
	public PanelOpcionesInformacion(PanelInfoJugador pInfo) {
		pInfoJugador = pInfo;
		setLayout(new GridLayout(1, 3));
		btnAnterior = new JButton("Anterior");
		btnAnterior.setActionCommand(ANTERIOR);
		btnAnterior.addActionListener(this);
		btnPrimero = new JButton("Primero");
		btnPrimero.setActionCommand(PRIMERO);
		btnPrimero.addActionListener(this);
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setActionCommand(SIGUIENTE);
		btnSiguiente.addActionListener(this);
		add(btnAnterior);
		add(btnPrimero);
		add(btnSiguiente);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(ANTERIOR)) {
			pInfoJugador.getAnteriorJugador();
		}
		else if (comando.equals(PRIMERO)) {
			pInfoJugador.getPrimerJugador();
		}
		else if (comando.equals(SIGUIENTE)) {
			pInfoJugador.getSiguienteJugador();
		}
		
	}

}
