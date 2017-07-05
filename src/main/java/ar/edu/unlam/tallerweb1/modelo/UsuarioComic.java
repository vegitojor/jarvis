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
public class UsuarioComic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_comic" )
	private Comic comic;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_usuario" )
	private Usuario usuario;
	private Timestamp fechaRegistro;
	private Boolean siguiendoActualmente;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Comic getComic() {
		return comic;
	}
	
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getSiguiendoActualmente() {
		return siguiendoActualmente;
	}

	public void setSiguiendoActualmente(Boolean siguiendoActualmente) {
		this.siguiendoActualmente = siguiendoActualmente;
	}
	
	@Transient
	public Boolean isSiguiendoActualmente() {
		return siguiendoActualmente;
	}
}