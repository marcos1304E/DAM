package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Noticia {
	private String titular;
	private String fuente;
	private String categoria;
	private String hora;

	public Noticia(String titular, String fuente, String categoria) {
        this.titular = titular;
        this.fuente = fuente;
        this.categoria = categoria;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.hora = sdf.format(new Date());
    }

	public String getTitular() {
		return titular;
	}

	public String getFuente() {
		return fuente;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getHora() {
		return hora;
	}

	@Override
	public String toString() {
		return "[" + hora + "] " + fuente + ": " + titular;
	}
}