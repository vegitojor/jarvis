package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formato {
	
	public static final Long ABSOLUTE = 1L;
	public static final Long COMPENDIUM = 2L;
	public static final Long DELUXE = 3L;
	public static final Long HC = 4L;
	public static final Long ISSUE = 5L;
	public static final Long OMNIBUS = 6L;
	public static final Long TPB = 7L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
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
