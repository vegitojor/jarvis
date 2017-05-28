package ar.edu.unlam.tallerweb1.modelo;

public class Editorial {
	
	private Long id;
	private String editorial;
	private String pathImagen;
	
	public Editorial (Long id, String editorial, String pathImagen){
		this.id = id;
		this.editorial = editorial;
		this.pathImagen = pathImagen;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getPathImagen() {
		return pathImagen;
	}
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
}
