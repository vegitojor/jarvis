package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Comic;

public interface ServicioColeccion {
	
	public List<Comic> buscarComic(Long id);

}
