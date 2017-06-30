package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Comic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String numero;
	private Timestamp fechaPublicacion;
	@Transient
	private Coleccion coleccion;
	private String pvp;
	private String cantPaginas;
	@Transient
	private Autor autor;
	@Transient
	private Formato formato;
	private String pathImagen;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="comics")  
    private List<Usuario> usuarios;

	public Comic(Long id, String isbn, String numero, Timestamp fechaPublicacion, Coleccion coleccion,
			String pvp, String cantPaginas, Autor autor, Formato formato, String pathImagen) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.numero = numero;
		this.fechaPublicacion = fechaPublicacion;
		this.coleccion = coleccion;
		this.pvp = pvp;
		this.cantPaginas = cantPaginas;
		this.autor = autor;
		this.formato = formato;
		this.setPathImagen(pathImagen);
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
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

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
}
