package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

public interface UsuarioComicDao {
	
	void guardarNuevoUsuarioComic(UsuarioComic usuarioComic);
	
	void guardarUsuarioComic(UsuarioComic usuarioComic);
	
	UsuarioComic buscarUsuarioComic(Long id);
	
	UsuarioComic consultarUsuarioComic(Long idUsuario, Long idComic);
	
	List<UsuarioComic> listarUsuarioComicsSiguiendoActualmente(Long idUsuario);
}