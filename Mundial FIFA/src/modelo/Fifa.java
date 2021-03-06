package modelo;

import java.util.ArrayList;

public class Fifa {
	private int numeroSelecciones;
	private Seleccion primeraSeleccion;
	public Fifa(Seleccion primeraSeleccion) {	
		this.primeraSeleccion = primeraSeleccion;
		
	}
	public Fifa() {
		Seleccion argentina = new Seleccion("Argentina", 1253.61, "img/argentina.png"); 
		Seleccion colombia = new Seleccion("Colombia", 988.57, "img/colombia.png"); 
		Seleccion brasil = new Seleccion("Brasil", 1384.24, "img/brasil.jpg"); 
		
		primeraSeleccion = argentina;
		argentina.agregarJugador("Lionel Messi", "Delantero", 223.4, "24/06/1987", 1.70, "img/messi.jpg");
		argentina.agregarJugador("Sergio Aguero", "Delantero", 223.4, "02/06/1988", 1.73, "img/aguero.jpg");
		argentina.agregarJugador("Gonzalo Higuain", "Delantero", 223.4, "10/12/1987", 1.86, "img/higuain.jpg");
		agregarSeleccion(colombia);
		colombia.agregarJugador("James Rodriguez", "Mediocampista", 185.9, "05/07/1990", 1.75, "img/james.jpg");
		colombia.agregarJugador("Radamel Falcao", "Delantero", 188.9, "05/07/1988", 1.85, "img/falcao.jpg");
		colombia.agregarJugador("Juan Cuadrado", "Mediocampista", 170.9, "08/07/1989", 1.73, "img/cuadrado.jpg");
		
		agregarSeleccion(brasil);
		numeroSelecciones++;
	}
	
	public int getNumeroSelecciones() {
		return numeroSelecciones;
	}
	public void setNumeroSelecciones(int numeroSelecciones) {
		this.numeroSelecciones = numeroSelecciones;
	}
	public Seleccion getPrimeraSeleccion() {
		return primeraSeleccion;
	}
	public void setPrimeraSeleccion(Seleccion primeraSeleccion) {
		this.primeraSeleccion = primeraSeleccion;
	}

	
	public void agregarSeleccion(Seleccion selec) {
			
		if (primeraSeleccion == null) {			
			primeraSeleccion = selec;
			numeroSelecciones++;
		} else {
			Seleccion siguiente = primeraSeleccion;
			while (siguiente.getSiguiente() != null) {
				siguiente = siguiente.getSiguiente();				
			}			
			siguiente.setSiguiente(selec);
			numeroSelecciones++;
		}
	}
	public void agregarSeleccion(String pais, double puntos, String imagen) {
		Seleccion selec = new Seleccion(pais, puntos, imagen);		
		if (primeraSeleccion == null) {			
			primeraSeleccion = selec;
			numeroSelecciones++;
		} else {
			Seleccion siguiente = primeraSeleccion;
			while (siguiente.getSiguiente() != null) {
				siguiente = siguiente.getSiguiente();				
			}			
			siguiente.setSiguiente(selec);
			numeroSelecciones++;
		}
	}
	
	
	public ArrayList<String> darNombreSelecciones() throws NoExisteException{
		ArrayList<String> selec = new ArrayList<String>();
		if (primeraSeleccion == null) {
			throw new NoExisteException("No existe ninguna selecci�n para mostrar");			
		}
		else {
			Seleccion siguiente = primeraSeleccion;
			while(siguiente != null) {
				selec.add(siguiente.getPais());
				siguiente = siguiente.getSiguiente();
			}
		}
		return selec;
	}
	
	public ArrayList<Seleccion> darSelecciones() throws NoExisteException{
		ArrayList<Seleccion> selec = new ArrayList<Seleccion>();
		if (primeraSeleccion == null) {
			throw new NoExisteException("No existe ninguna selecci�n para mostrar");			
		}
		else {
			Seleccion siguiente = primeraSeleccion;
			while(siguiente != null) {
				
				selec.add(siguiente);
				siguiente = siguiente.getSiguiente();
			}
		}
		return selec;
	}
	
	public ArrayList<Seleccion> buscarSeleccion(String nombreSeleccion) throws NoExisteException{
		ArrayList<Seleccion> encontrada = new ArrayList<Seleccion>();
		Seleccion actual = primeraSeleccion;
		if (actual == null) {
			throw new NoExisteException("No existe ninguna seleccion para buscar");
		}
		else {
			while (actual != null) {
				if (actual.getPais().equalsIgnoreCase(nombreSeleccion)) {
					encontrada.add(actual);
					actual = actual.getSiguiente();
				}
				else {
					actual = actual.getSiguiente();
				}
				
			}
		}
		return encontrada;
	}
	
//	public void agregarJugador(String nombreSeleccion, String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) throws NoExisteException{
//		Seleccion actual = buscarSeleccion(nombreSeleccion);
//		actual.agregarJugador(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
//	}
	
	
	public void agregarJugadorSinBuscar(Seleccion sele, String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
//		Seleccion actual = buscarSeleccion(nombreSeleccion);
		sele.agregarJugador(nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
	}
	
	public ArrayList<Jugador> darJugadores(Seleccion sele) throws NoExisteException{
		if (sele == null) {
			throw new NoExisteException("No ha seleccionado ninguna selecci�n");
		} else {
			return sele.darJugadores();
		}
		
	}
	public Seleccion buscarSeleccionAnterior(Seleccion sele) {
		Seleccion anterior = null;
		Seleccion actual = primeraSeleccion;
		boolean salir = false;
		if (actual == sele) {
			anterior = actual;
			
		}
		else {
			while (actual.getSiguiente() != null && !salir) {
				if (actual.getSiguiente() == sele) {
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
	
	public void eliminarSeleccion(Seleccion sele) throws NoExisteException {
		if (primeraSeleccion == null) {
			throw new NoExisteException("No existe la selecci�n a eliminar");
		}
		else if (sele == primeraSeleccion) {
			primeraSeleccion = primeraSeleccion.getSiguiente();
			numeroSelecciones--;
		}
		else {
			Seleccion anterior = buscarSeleccionAnterior(sele);
			if (anterior == null) {
				throw new NoExisteException("No existe la selecci�n a eliminar");
				
			}
			anterior.desconectarSiguiente();
			numeroSelecciones--;
		}
		
		
	}
	public void eliminarJugador(Seleccion selec, Jugador jug) {
		selec.eliminarJugador(jug);
	}
	public Jugador buscarJugador(Seleccion sele, String nombreJugador) throws NoExisteJugadorException {		
		return sele.buscarJugador(nombreJugador);
	}
	public Jugador buscarJugadorAnterior(Seleccion sele, String nombreJugador) {		
		return sele.buscarJugadorAnteriorPorNombre(nombreJugador);
	}
	public Jugador buscarJugadorSiguiente(Seleccion sele, String nombreJugador) {		
		return sele.buscarJugadorSiguientePorNombre(nombreJugador);
	}
	public void calcularPromedios(Seleccion selec) {
		selec.calcularPromedioAltura();
		selec.calcularPromedioFifa();
	}
	public void modificarSeleccion(Seleccion sele, String pais, double puntos,String imagen) {
		sele.modificarSeleccion(pais, puntos, imagen);
	}
	public void modificarJugador(Seleccion sele, Jugador jug, String nombreJugador, String posicion, double puntajeFifa, String fechaNacimiento, double altura, String imagen) {
		sele.modificarJugador(jug, nombreJugador, posicion, puntajeFifa, fechaNacimiento, altura, imagen);
	}
	
	public Jugador getSiguienteJugador(Seleccion sele, Jugador jug) {
		return sele.getSiguienteJugador(jug);
	}
	public Jugador getAnteriorJugador(Seleccion sele, Jugador jug) {
		return sele.getAnteriorJugador(jug);
	}
	public Jugador getPrimerJugador(Seleccion sele) {
		return sele.getPrimerJugador();
	}
	

	
}
