package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

public interface UsuarioComicComentarioDao {
	
	void guardarUsuarioComicComentario(UsuarioComicComentario usuarioComicComentario);
	
	List<UsuarioComicComentario> listarUsuarioComicComentarios(Long idUsuarioComic);
	
	List<UsuarioComicComentario> listarUsuarioComicComentarios(Criterion criterion);
}