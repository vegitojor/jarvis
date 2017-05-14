package ar.edu.unlam.tallerweb1.modelo;

public class Personaje {
	
	private Long id;
	private String nombre;
	private String alter_ego;
	
	public Personaje (Long id, String nombre, String alter_ego){
		this.id = id;
		this.nombre = nombre;
		this.alter_ego = alter_ego;
	}
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
	public String getAlter_ego() {
		return alter_ego;
	}
	public void setAlter_ego(String alter_ego) {
		this.alter_ego = alter_ego;
	}
}