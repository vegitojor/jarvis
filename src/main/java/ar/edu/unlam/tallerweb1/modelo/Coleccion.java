package ar.edu.unlam.tallerweb1.modelo;

public class Coleccion {

	private Long id;
	private String nombre;
	private String descripcion;
	private String pathImagen;
	private Editorial editorial;
	private Formato formato;
	private Personaje personaje;
	private Boolean enCurso;
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
	public Coleccion(Long id, String nombre, String descripcion, String pathImagen, Editorial editorial,
			Formato formato, Personaje personaje, Boolean enCurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pathImagen = pathImagen;
		this.editorial = editorial;
		this.formato = formato;
		this.personaje = personaje;
		this.enCurso = enCurso;
	}
	
	

}
