package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ComicDao {
	
	Comic buscarComic(Long id);
	
	List<Comic> listarComics();
	
	List<Comic> listarComicsDeColeccion(Long idColeccion);
	
	void guardarNuevoComic(Comic comic);
	
	void guardarComic(Comic comic);
}
