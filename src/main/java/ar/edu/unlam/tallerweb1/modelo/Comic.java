package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Comic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String isbn;
	private Timestamp fechaPublicacion;
	private String pvp;
	private String cantidadDePaginas;
	private String pathImagen;
	
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_coleccion" )	
	private Coleccion coleccion;
	@Transient
	private Autor autor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Timestamp getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Timestamp fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getPvp() {
		return pvp;
	}
	public void setPvp(String pvp) {
		this.pvp = pvp;
	}
	public String getCantidadDePaginas() {
		return cantidadDePaginas;
	}
	public void setCantidadDePaginas(String cantidadDePaginas) {
		this.cantidadDePaginas = cantidadDePaginas;
	}
	public String getPathImagen() {
		return pathImagen;
	}
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	public Coleccion getColeccion() {
		return coleccion;
	}
	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
