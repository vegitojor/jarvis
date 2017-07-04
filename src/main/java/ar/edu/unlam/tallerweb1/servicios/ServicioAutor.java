package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Autor;

public interface ServicioAutor {
	
	public Autor buscarAutor(Long id);
	
	public List<Autor> listarAutores();
	
	public void guardarAutor(Autor autor);
	
}
