public class Revistas extends Articulos {

	int num_edicion;

	public Revistas (int id_unico, String titulo, boolean estadoDisponibilidad) {
		super(id_unico, titulo, estadoDisponibilidad);
		this.
	}
	
	
	
	public Revistas(int num_edicion) {
		super();
		this.num_edicion = num_edicion;
	}



	public int getNum_edicion() {
		return num_edicion;
	}

	public void setNum_edicion(int num_edicion) {
		this.num_edicion = num_edicion;
	}
	
	
	
	
}

