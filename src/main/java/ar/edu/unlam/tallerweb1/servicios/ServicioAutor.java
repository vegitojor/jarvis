package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ServicioAutor {
	
	public Autor buscarAutor(Long id);
	
	public List<Autor> listarAutores();
	
	public List<Comic> listarComicsPorAutor(Long idAutor);
	
	public void guardarAutor(Autor autor);
	
}
