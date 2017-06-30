package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Coleccion {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private String pathImagen;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_editorial" )
	private Editorial editorial;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_formato" )
	private Formato formato;
	@Transient
	private Personaje personaje;
	private Boolean enCurso;
	private String volumen;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="colecciones")  
    private List<Usuario> usuarios;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getPathImagen() {
		return pathImagen;
	}
	
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public Formato getFormato() {
		return formato;
	}
	
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public Boolean getEnCurso() {
		return enCurso;
	}
	
	public void setEnCurso(Boolean enCurso) {
		this.enCurso = enCurso;
	}
	
	public String getVolumen() {
		return volumen;
	}
	
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
}
