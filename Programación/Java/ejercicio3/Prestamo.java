package simulacro;

public class Prestamo {
	
	static int contadorPrestamos = 0;
	String fecha;
	Articulos articuloAPrestar;
	Usuario usuario;
	
	
	public void incrementarContador() {
		contadorPrestamos++;
	}


	public Prestamo(String fecha, Articulos articuloAPrestar, Usuario usuario) {
		super();
		this.fecha = fecha;
		this.articuloAPrestar = articuloAPrestar;
		this.usuario = usuario;
	}
	
	
}
