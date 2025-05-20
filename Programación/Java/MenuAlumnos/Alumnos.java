import java.util.Arrays;

public class Alumnos {


	String dni;
	String nombre;
	String apellido;
	String fecha_Nac;
	String sexo;
	boolean repetidor;
	Modulo [] unModulo;
	
	public Alumnos(String dni, String nombre, String apellido, String fecha_Nac, String sexo, boolean repetidor,
			Modulo[] unModulo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nac = fecha_Nac;
		this.sexo = sexo;
		this.repetidor = repetidor;
		this.unModulo = unModulo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_Nac() {
		return fecha_Nac;
	}

	public void setFecha_Nac(String fecha_Nac) {
		this.fecha_Nac = fecha_Nac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public Modulo[] getUnModulo() {
		return unModulo;
	}

	public void setUnModulo(Modulo[] unModulo) {
		this.unModulo = unModulo;
	}

	@Override
	public String toString() {
		return "Alumnos [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_Nac=" + fecha_Nac
				+ ", sexo=" + sexo + ", repetidor=" + repetidor + ", Modulos=" + Arrays.toString(unModulo) + "]";
	}
	
}
