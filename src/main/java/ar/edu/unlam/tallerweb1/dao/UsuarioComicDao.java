package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

public interface UsuarioComicDao {
	
	void guardarNuevoUsuarioComic(UsuarioComic usuarioComic);
	
	void guardarUsuarioComic(UsuarioComic usuarioComic);
	
	UsuarioComic consultarUsuarioComic(Long idUsuario, Long idComic);
	
	List<Comic> comicsDelUsuario(Long idUsuario);
}