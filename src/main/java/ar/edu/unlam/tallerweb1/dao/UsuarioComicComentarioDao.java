package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

public interface UsuarioComicComentarioDao {
	
	UsuarioComicComentario obtenerUsuarioComicComentario(Long id);
	
	void guardarUsuarioComicComentario(UsuarioComicComentario usuarioComicComentario);
	
	List<UsuarioComicComentario> listarUsuarioComicComentarios(Long idUsuarioComic);
	
	List<UsuarioComicComentario> listarNotificaciones(Long idUsuario);
	
	List<UsuarioComicComentario> listarNotificaciones(Long idUsuario, Criterion criterion);
	
	List<UsuarioComicComentario> listarUsuarioComicComentarios(Criterion criterion);
	
	Integer cantidadNotificacionesNoLeidas(Long idUsuario);
}