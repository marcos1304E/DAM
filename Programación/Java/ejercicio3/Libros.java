public class Libros extends Articulos{

	private String autor;

	public Libros(int id, String titulo, boolean estadoDisponibilidad, String autor) {
		super(id, titulo, estadoDisponibilidad);
		this.autor = autor;
		
	}

	
	
}
