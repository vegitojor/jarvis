package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ServicioComic {

	public List<Comic> listarComics();
	
	public List<Comic> listarSugerencias(Long idUsuario);
	
	public Comic buscarComic(Long id);
	
	public Comic guardarComic(Long id, String numero, Long idColeccion, Long idAutor, String fechaPublicacion, String isbn, Integer cantidadDePaginas, Double pvp, String pathImagen);
}
