package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

public interface ServicioUsuarioComicComentario {
	
	public UsuarioComicComentario guardarUsuarioComicComentario(Long idUsuarioComic, Long idUsuario, String comentario);
	
	List<UsuarioComicComentario> listarUsuarioComicComentarios(Long idUsuarioComic);
}
