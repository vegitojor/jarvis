package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

public interface ServicioColeccion {
	
	public List<Coleccion> listarColecciones();
	
	public Coleccion guardarColecion(Long id, String nombre, String descripcion, String pathImagen, Long idEditorial, Long idFormato, String volumen, Boolean enCurso);
}
