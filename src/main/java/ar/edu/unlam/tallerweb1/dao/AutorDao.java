package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;

public interface AutorDao {
	
	Autor buscarAutor(Long id);
	
	List<Autor> listarAutores();
	
	void guardarNuevoAutor(Autor autor);
	
	void guardarAutor(Autor autor);
}