package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pais;

public interface PaisDao {
	
	Pais consultarPais(Pais pais);
	
	List<Pais> listarPaises();
}