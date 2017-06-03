package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;

@Entity
public class Formato {
	
	public static final Long ISSUE = 1L;
	public static final Long TP = 2L;
	public static final Long HC = 3L;
	public static final Long OMNIBUS = 4L;
	public static final Long COMPENDIUM = 5L;
	public static final Long DELUXE = 6L;
	public static final Long ABSOLUTE = 7L;
	
	private Long id;
	private String nombre;
	
	public Formato (Long id, String nombre){
		this.id = id;
		this.nombre = nombre;
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
}
