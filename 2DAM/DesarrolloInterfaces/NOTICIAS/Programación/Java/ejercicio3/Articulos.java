public class Articulos {

	int id;
	String titulo;
	boolean estadoDisponibilidad;
	
	
	
	public Articulos(int id, String titulo, boolean estadoDisponibilidad) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public int getId_unico() {
		return id;
	}
	
	public void setId_unico(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public boolean isEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}
	
	public void setEstadoDisponibilidad(boolean estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	@Override
	public String toString() {
		return "Articulos [id=" + id + ", titulo=" + titulo + ", estadoDisponibilidad="
				+ estadoDisponibilidad + "]";
	}

	
	//devolverArticulo();
	
}
