package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ComicDao {
	
	Comic agregarNuevoComic(Long id);
	
	Comic buscarComic(Long id);

}
