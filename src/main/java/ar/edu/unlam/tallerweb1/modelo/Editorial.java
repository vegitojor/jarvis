package ar.edu.unlam.tallerweb1.modelo;

public class Editorial {
	
	private Long id;
	private String editorial;
	private String path500px;
	private String path250px;
	private String pathThumb;
	
	public Editorial (Long id, String editorial, String path500px, String path250px, String pathThumb){
		this.id = id;
		this.editorial = editorial;
		this.path500px = path500px;
		this.path250px = path250px;
		this.pathThumb = pathThumb;
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
	public String getPath500px() {
		return path500px;
	}
	public void setPath500px(String path500px) {
		this.path500px = path500px;
	}
	public String getPath250px() {
		return path250px;
	}
	public void setPath250px(String path250px) {
		this.path250px = path250px;
	}
	public String getPathThumb() {
		return pathThumb;
	}
	public void setPathThumb(String pathThumb) {
		this.pathThumb = pathThumb;
	}
	
}
