package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Editorial;

public interface EditorialDao {
	
	Editorial buscarEditorial(Long id);
	
	List<Editorial> listarEditoriales();
	
	Editorial buscarEditorialPorNombre(String nombre);
	
	void guardarNuevaEditorial(Editorial editorial);
	
	void guardarEditorial(Editorial editorial);
}