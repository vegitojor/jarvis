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
public class UsuarioComicComentario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_usuario_comic" )
	private UsuarioComic usuarioComic;
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn( name="id_usuario" )
	private Usuario usuario;
	private Timestamp fecha;
	private String comentario;
	private Boolean disponible;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UsuarioComic getUsuarioComic() {
		return usuarioComic;
	}
	public void setUsuarioComic(UsuarioComic usuarioComic) {
		this.usuarioComic = usuarioComic;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	@Transient
	public Boolean isDisponible() {
		return disponible;
	}
}