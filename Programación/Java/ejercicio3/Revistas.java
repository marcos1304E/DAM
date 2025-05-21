public class Revistas extends Articulos{

	private int num_edicion;
	
	
	
	public Revistas(int id, String titulo, boolean estadoDisponibilidad,int num_edicion) {
		super(id, titulo, estadoDisponibilidad);

		this.num_edicion = num_edicion;
		
	}



	public int getNum_edicion() {
		return num_edicion;
	}

	public void setNum_edicion(int num_edicion) {
		this.num_edicion = num_edicion;
	}
	
}
