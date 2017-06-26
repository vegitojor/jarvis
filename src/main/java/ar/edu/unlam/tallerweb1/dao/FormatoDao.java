package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Formato;

public interface FormatoDao {
	List<Formato> listarFormatos();
	
	Formato buscarFormatoPorNombre(String nombre);
}
