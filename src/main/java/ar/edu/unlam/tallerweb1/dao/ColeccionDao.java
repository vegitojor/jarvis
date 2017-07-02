package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

public interface ColeccionDao {
	
	Coleccion buscarColeccion(Long id);
	
	List<Coleccion> listarColecciones();
	
	void guardarNuevaColeccion(Coleccion coleccion);
	
	void guardarColeccion(Coleccion coleccion);
}