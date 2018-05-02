package modelo;

public class Jugador {
	
	private String nombreJugador;
	private String posicion;
	private double puntajeFifa;
	private String fechaNacimiento;
	private double altura;
	private String imagen;	
	private Jugador siguiente;
	private Jugador anterior;
	
	public Jugador(String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {		
		this.nombreJugador = nombreJugador;
		this.posicion = posicion;
		this.puntajeFifa = puntajeFifa;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.imagen = imagen;
	}
	
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public double getPuntajeFifa() {
		return puntajeFifa;
	}
	public void setPuntajeFifa(double puntajeFifa) {
		this.puntajeFifa = puntajeFifa;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Jugador getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}

	public Jugador getAnterior() {
		return anterior;
	}

	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}	
	
	@Override
	public String toString() {
		return nombreJugador;
	}
	
	public void desconectarSiguiente() {
		siguiente = siguiente.siguiente;
	}
	public void modificarJugador(String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {		
		this.nombreJugador = nombreJugador;
		this.posicion = posicion;
		this.puntajeFifa = puntajeFifa;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.imagen = imagen;
	}
	

}
