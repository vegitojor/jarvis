package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Formato;

public interface ServicioFormato {

	public List<Formato> listarFormatos();
	
	public Formato buscarFormatoPorNombre(String nombre);
}
