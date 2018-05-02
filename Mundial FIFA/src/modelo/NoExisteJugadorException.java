package modelo;

public class NoExisteJugadorException extends Exception  {
	private String nombre;

	public NoExisteJugadorException(String nombre) {

		super("El jugador "+nombre+" no existe");
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
