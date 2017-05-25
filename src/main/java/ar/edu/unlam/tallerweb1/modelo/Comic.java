package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Timestamp;

public class Comic {

	private Long id;
	private String isbn;
	private String numero;
	private Timestamp fechaPublicacion;
	private Coleccion coleccion;
	private Coleccion volumen;
	private String pvp;
	private String cantPaginas;
	private Autor autor;
	private Formato formato;

	public Comic(Long id, String isbn, String numero, Timestamp fechaPublicacion, Coleccion coleccion, Coleccion volumen, String pvp, String cantPaginas, Autor autor, Formato formato) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.numero = numero;
		this.fechaPublicacion = fechaPublicacion;
		this.coleccion = coleccion;
		this.volumen = volumen;
		this.pvp = pvp;
		this.cantPaginas = cantPaginas;
		this.autor = autor;
		this.formato = formato;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public Coleccion getVolumen() {
		return volumen;
	}

	public void setVolumen(Coleccion volumen) {
		this.volumen = volumen;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(String cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public String getPvp() {
		return pvp;
	}

	public void setPvp(String pvp) {
		this.pvp = pvp;
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
