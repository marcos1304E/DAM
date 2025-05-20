public class Profesor {


	String dni;
	String nombre;
	String apellidos;
	int salario;
	int numero_asignatuas;
	boolean tutor;
	
	public Profesor(String dni, String nombre, String apellidos, int salario, int numero_asignatuas, boolean tutor) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.numero_asignatuas = numero_asignatuas;
		this.tutor = tutor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getNumero_asignatuas() {
		return numero_asignatuas;
	}

	public void setNumero_asignatuas(int numero_asignatuas) {
		this.numero_asignatuas = numero_asignatuas;
	}

	public boolean isTutor() {
		return tutor;
	}

	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario=" + salario
				+ ", numero_asignatuas=" + numero_asignatuas + ", tutor=" + tutor + "]";
	}
	
}

