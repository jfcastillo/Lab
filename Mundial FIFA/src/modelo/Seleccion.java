package modelo;

import java.util.ArrayList;

public class Seleccion {
	
	private String pais;
	private double puntos;
	private double promedioAltura;
	private double promedioEdad;
	private double promedioFifa;
	private String imagen;
	private int cantidadJugadores;
	private Seleccion siguiente;
	private Jugador primerJugador;
	private Jugador ultimoJugador;
	public Seleccion(String pais, double puntos, double promedioAltura, double promedioEdad, double promedioFifa, String imagen) {
		
		this.pais = pais;
		this.puntos = puntos;
		this.promedioAltura = promedioAltura;
		this.promedioEdad = promedioEdad;
		this.promedioFifa = promedioFifa;
		this.imagen = imagen;
		cantidadJugadores = 0;
		
	}
	public Seleccion(String pais, double puntos,String imagen) {
		this.pais = pais;
		this.puntos = puntos;
		promedioAltura = 0.0;
		promedioEdad = 0.0;
		promedioFifa = 0.0;
		this.imagen = imagen;
		cantidadJugadores = 0;
	}
	/**
	 *  Inicio métodos dar y modificar 
	 */
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public double getPuntos() {
		return puntos;
	}
	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	public double getPromedioAltura() {
		return promedioAltura;
	}
	public void setPromedioAltura(double promedioAltura) {
		this.promedioAltura = promedioAltura;
	}
	public double getPromedioEdad() {
		return promedioEdad;
	}
	public void setPromedioEdad(double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}
	public double getPromedioFifa() {
		return promedioFifa;
	}
	public void setPromedioFifa(double promedioFifa) {
		this.promedioFifa = promedioFifa;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Seleccion getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Seleccion siguiente) {
		this.siguiente = siguiente;
	}	
	
	public int getCantidadJugadores() {
		return cantidadJugadores;
	}
	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	public Jugador getPrimerJugador() {
		return primerJugador;
	}
	public void setPrimerJugador(Jugador primerJugador) {
		this.primerJugador = primerJugador;
	}
	public Jugador getUltimoJugador() {
		return ultimoJugador;
	}
	public void setUltimoJugador(Jugador ultimoJugador) {
		this.ultimoJugador = ultimoJugador;
	}//Fin métodos dar y modificar.
	
	@Override
	public String toString() {		
		return pais;
	}
	//Está malo
	public ArrayList<Jugador> darJugadores() throws NoExisteException{
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		if (primerJugador == null) {
			throw new NoExisteException("No existe ningún jugador para mostrar");
		} else {
			Jugador actual = primerJugador;
			do {
				jugadores.add(actual);
				actual = actual.getSiguiente();
			} while (actual != primerJugador);

		}
		return jugadores;
	}
	
	public void agregarJugador(String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
		Jugador jug = new Jugador(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
		Jugador actual = primerJugador;
		if (actual == null) {
			primerJugador = jug;
			ultimoJugador = jug;
			primerJugador.setAnterior(ultimoJugador);
			primerJugador.setSiguiente(ultimoJugador);
			cantidadJugadores++;
		} else {
			actual = ultimoJugador;
			actual.setSiguiente(jug);
			actual.getSiguiente().setAnterior(actual);
			ultimoJugador = jug;
			primerJugador.setAnterior(ultimoJugador);
			actual.getSiguiente().setSiguiente(primerJugador);
			cantidadJugadores++;

		}
	}
	

	
	public void calcularPromedioAltura() {
		Jugador actual = primerJugador;
		double sumaAlturas = 0.0;
		if (actual == null) {
			promedioAltura = 0.0;
		}
		else {
			do {
				sumaAlturas += actual.getAltura();
				actual = actual.getSiguiente();
			} while (actual != primerJugador);
			promedioAltura = sumaAlturas/cantidadJugadores;
		}
	}
	public void calcularPromedioFifa() {
		Jugador actual = primerJugador;
		double sumaPuntos = 0.0;
		if (actual == null) {
			promedioFifa = 0.0;
		}
		else {
			do {
				sumaPuntos += actual.getPuntajeFifa();
				actual = actual.getSiguiente();
			} while (actual != primerJugador);
			promedioFifa = sumaPuntos/cantidadJugadores;
		}
	}
	
	public void desconectarSiguiente() {
		siguiente = siguiente.siguiente;
	}
	
	public Jugador buscarJugador(String nombreJugador) throws NoExisteJugadorException {
		Jugador encontrado = null;
		Jugador actual = primerJugador;
		
		if (actual == null) {
			throw new NoExisteJugadorException(nombreJugador);
			
		}
		else {
			if (actual.getNombreJugador().equals(nombreJugador)) {
				encontrado = actual;
			}
			else {
				actual = actual.getSiguiente();
				while (actual != null && actual != primerJugador) {
					if (actual.getSiguiente().getNombreJugador().equalsIgnoreCase(nombreJugador)) {
						encontrado = actual.getSiguiente();	
						actual = actual.getSiguiente();
						
					}		
					else {
						actual = actual.getSiguiente();
					}
				}
			}
			
			
		}
		return encontrado;
	}
	
	public Jugador buscarJugadorAnterior(Jugador juga) {
		Jugador anterior = null;
		Jugador actual = primerJugador;
		boolean salir = false;
		if (actual == juga) {
			anterior = actual;
			
		}
		else {
			while (actual.getSiguiente() != null && !salir) {
				if (actual.getSiguiente() == juga) {
					anterior = actual;					
					salir = true;
				}		
				else {
					actual = actual.getSiguiente();
				}
			}
			
		}
		return anterior;
	}
	public Jugador buscarJugadorAnteriorPorNombre(String nombre) {
		Jugador anterior = null;
		Jugador actual = primerJugador;
		boolean salir = false;
		if (actual.getNombreJugador().equals(nombre)) {
			anterior = actual;
			
		}
		else {
			while (actual.getSiguiente() != null && !salir) {
				if (actual.getSiguiente().getNombreJugador().equals(nombre)) {
					anterior = actual;					
					salir = true;
				}		
				else {
					actual = actual.getSiguiente();
				}
			}
			
		}
		return anterior;
	}
	public Jugador buscarJugadorSiguientePorNombre(String nombre) {
		Jugador siguiente = null;
		Jugador actual = primerJugador;
		boolean salir = false;
		if (actual.getNombreJugador().equals(nombre)) {
			siguiente = actual;
			
		}
		else {
			while (actual.getSiguiente() != null && !salir) {
				if (actual.getSiguiente().getNombreJugador().equals(nombre)) {
					siguiente = actual.getSiguiente();					
					salir = true;
				}		
				else {
					actual = actual.getSiguiente();
				}
			}
			
		}
		return siguiente;
	}
	
	public void eliminarJugador(Jugador jug) {
		if (jug == primerJugador) {
			primerJugador = primerJugador.getSiguiente();
			ultimoJugador.setSiguiente(primerJugador);
		}
		else {
			Jugador anterior = buscarJugadorAnterior(jug);
			if (anterior.getSiguiente() == ultimoJugador) {
				anterior.setSiguiente(primerJugador);
				ultimoJugador = anterior;
			}
			else {
				anterior.desconectarSiguiente();
			}
		}
	}
	public void modificarSeleccion(String pais, double puntos,String imagen) {
		this.pais = pais;
		this.puntos = puntos;
		this.imagen = imagen;
		calcularPromedioAltura();
		calcularPromedioFifa();
	}
	public void modificarJugador(Jugador jug, String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
		jug.modificarJugador(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
	}
	public Jugador getSiguienteJugador(Jugador jug) {
		return jug.getSiguiente();
	}
	public Jugador getAnteriorJugador(Jugador jug) {
		return jug.getAnterior();
	}

}
