package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Timestamp;

public class Comic {
	
	private Long id;
	private String isbn;
	private String numero;
	private Timestamp fechaPublicacion;
	private Coleccion coleccion;
	
	public Comic(Long id, String isbn, String numero, Timestamp fechaPublicacion, Coleccion coleccion) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.numero = numero;
		this.fechaPublicacion = fechaPublicacion;
		this.coleccion = coleccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Timestamp getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Timestamp fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
}
