package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

public interface ColeccionDao {
	
	Coleccion buscarColeccion(Long id);
	
	List<Coleccion> listarColecciones();
	
	List<Coleccion> listarColeccionesPorCriterion(Criterion criterion);
	
	void guardarNuevaColeccion(Coleccion coleccion);
	
	void guardarColeccion(Coleccion coleccion);
}