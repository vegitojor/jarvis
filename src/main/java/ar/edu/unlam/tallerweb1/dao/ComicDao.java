package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ComicDao {
	
	Comic buscarComic(Long id);
	
	List<Comic> listarComics();
	
	List<Comic> listarSugerencias(Long idUsuario);
	
	List<Comic> listarComicsConCriterion(Criterion criterion);
	
	List<Comic> listarComicsDeColeccion(Long idColeccion);
	
	void guardarNuevoComic(Comic comic);
	
	void guardarComic(Comic comic);
}
