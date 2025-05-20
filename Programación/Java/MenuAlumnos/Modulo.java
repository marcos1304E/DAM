public class Modulo {

	
	String nombre;
	int horas;
	Profesor unProfesor;
	boolean convalidable;
	
	public Modulo(String nombre, int horas, Profesor unProfesor, boolean convalidable) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.unProfesor = unProfesor;
		this.convalidable = convalidable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Profesor getUnProfesor() {
		return unProfesor;
	}

	public void setUnProfesor(Profesor unProfesor) {
		this.unProfesor = unProfesor;
	}

	public boolean isConvalidable() {
		return convalidable;
	}

	public void setConvalidable(boolean convalidable) {
		this.convalidable = convalidable;
	}

	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", horas=" + horas + ", Profesor=" + unProfesor + ", convalidable="
				+ convalidable + "]";
	}
	
}


