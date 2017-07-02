package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity 
public class Usuario {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;
	
	private String email;
	private String password;
	private String nombre;
	private Timestamp fechaDeNacimiento;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name="id_pais" )
	private Pais pais;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="usuarios")  
	private List<Coleccion> colecciones = new ArrayList();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_comic", 
	joinColumns = @JoinColumn(name = "usuario_id"), 
	inverseJoinColumns = @JoinColumn(name = "comic_id"))
	private List<Comic> comics;
	
	private Boolean administrador;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Timestamp getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(Timestamp fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	
	@Transient
	public Boolean isAdministrador() {
		return administrador;
	}
	
	public List<Coleccion> getColecciones() {
		return colecciones;
	}

	public void setColecciones(List<Coleccion> colecciones) {
		this.colecciones = colecciones;
	}

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}
}
