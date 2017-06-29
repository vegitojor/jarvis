package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Editorial;

public interface ServicioEditorial {
	
	public Editorial buscarEditorial(Long id);
	
	public Editorial buscarEditorialPorNombre(String nombre);
	
	public List<Editorial> listarEditoriales();
}
