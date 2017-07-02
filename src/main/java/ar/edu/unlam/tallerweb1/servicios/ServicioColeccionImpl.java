
package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ColeccionDao;
import ar.edu.unlam.tallerweb1.dao.EditorialDao;
import ar.edu.unlam.tallerweb1.dao.FormatoDao;
import ar.edu.unlam.tallerweb1.modelo.Coleccion;

@Service("servicioColeccion")
@Transactional
public class ServicioColeccionImpl implements ServicioColeccion {

	@Inject
	private ColeccionDao coleccionDao;
	@Inject
	private EditorialDao editorialDao;
	@Inject
	private FormatoDao formatoDao;
	
	@Override
	public Coleccion buscarColeccion(Long id) {
		return coleccionDao.buscarColeccion(id);
	}
	
	@Override
	public List<Coleccion> listarColecciones() {
		return coleccionDao.listarColecciones();
	}

	@Override
	public Coleccion guardarColecion(Long id, String nombre, String descripcion, String pathImagen,
			Long idEditorial, Long idFormato, String volumen, Boolean enCurso) {
		Coleccion coleccion = null;

		if (id!=null) {
			coleccion = coleccionDao.buscarColeccion(id);
		} else {
			coleccion = new Coleccion();
		}

		coleccion.setNombre(nombre);
		if (descripcion!=null && descripcion!="")
			coleccion.setDescripcion(descripcion);
		if (pathImagen!=null && pathImagen!="")
			coleccion.setPathImagen(pathImagen);

		coleccion.setEditorial( editorialDao.buscarEditorial(idEditorial) );
		coleccion.setFormato( formatoDao.buscarFormato(idFormato) );

		if (volumen!=null && volumen!="")
			coleccion.setVolumen(volumen);

		coleccion.setEnCurso(enCurso);

		if (id!=null){
			coleccionDao.guardarColeccion(coleccion);
		} else {
			coleccionDao.guardarNuevaColeccion(coleccion);
		}

		return coleccion;
	}
}
