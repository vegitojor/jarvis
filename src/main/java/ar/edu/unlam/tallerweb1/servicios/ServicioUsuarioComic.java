package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

public interface ServicioUsuarioComic {
	
	public UsuarioComic guardarUsuarioComic(Long idUsuario, Long idComic, Boolean siguiendoActualmente);
	
	public List<UsuarioComic> listarUsuarioComics(Long idUsuario);
	
	public UsuarioComic consultarUsuarioComic(Long idUsuario, Long idComic);
}
