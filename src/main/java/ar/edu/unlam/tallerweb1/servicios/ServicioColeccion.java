package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.ui.ModelMap;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;

public interface ServicioColeccion {
	
	public Coleccion buscarColeccion(Long id);
	
	public List<Coleccion> listarColecciones();
	
	public ModelMap coleccionesFiltradas(String nombre, Long idEditorial, Long idFormato);
	
	public List<Coleccion> listarColeccionesPorEditorial(Long idEditorial);
	
	public ModelMap datosColeccion(Long idColeccion);
	
	public Coleccion guardarColecion(Long id, String nombre, String descripcion, String pathImagen, Long idEditorial, Long idFormato, String volumen, Boolean enCurso);
}
