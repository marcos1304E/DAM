enum TipoCoche{MINI, DEPORTIVO, UTILITARIO, FAMILIAR}
enum seguro{TERCERO, A_TODO_RIESGO}

public class Coche {
	
	String modelo;
	String color;
	boolean metalizado;
	String matricula;
	TipoCoche unCoche;
	int año_fabricacion;
	seguro tipoSeguro;

	
	public Coche(String modelo, String color, boolean metalizado, String matricula, TipoCoche unCoche,
			int año_fabricacion, seguro tipoSeguro) {
		super();
		this.modelo = modelo;
		this.color = color;
		this.metalizado = metalizado;
		this.matricula = matricula;
		this.unCoche = unCoche;
		this.año_fabricacion = año_fabricacion;
		this.tipoSeguro = tipoSeguro;
	}
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isMetalizado() {
		return metalizado;
	}
	public void setMetalizado(boolean metalizado) {
		this.metalizado = metalizado;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public TipoCoche getUnCoche() {
		return unCoche;
	}
	public void setUnCoche(TipoCoche unCoche) {
		this.unCoche = unCoche;
	}
	public int getAño_fabricacion() {
		return año_fabricacion;
	}
	public void setAño_fabricacion(int año_fabricacion) {
		this.año_fabricacion = año_fabricacion;
	}
	public seguro getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(seguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	@Override
	public String toString() {
		return "Coche: [modelo=" + modelo + ", color=" + color + ", metalizado=" + metalizado + ", matricula="
				+ matricula + ", unCoche=" + unCoche + ", año_fabricacion=" + año_fabricacion + ", tipoSeguro="
				+ tipoSeguro + "]";
	}
	
	
}
