package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface AutorDao {
	
	Autor buscarAutor(Long id);
	
	List<Autor> listarAutores();
	
	List<Comic> listarComicsPorAutor(Long id);
	
	void guardarNuevoAutor(Autor autor);
	
	void guardarAutor(Autor autor);
}