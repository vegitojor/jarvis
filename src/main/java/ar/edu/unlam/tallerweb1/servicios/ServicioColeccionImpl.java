package ar.edu.unlam.tallerweb1.servicios;

import static com.wagnerandade.coollection.Coollection.from;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import ar.edu.unlam.tallerweb1.dao.ColeccionDao;
import ar.edu.unlam.tallerweb1.dao.ComicDao;
import ar.edu.unlam.tallerweb1.dao.EditorialDao;
import ar.edu.unlam.tallerweb1.dao.FormatoDao;
import ar.edu.unlam.tallerweb1.modelo.Coleccion;

@Service("servicioColeccion")
@Transactional
public class ServicioColeccionImpl implements ServicioColeccion {

	@Inject
	private ComicDao comicDao;
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
	public ModelMap coleccionesFiltradas(String nombre, Long idEditorial, Long idFormato) {
		ModelMap modelo = new ModelMap();
		
		Criterion criterion = Restrictions.ge("id", 1L);
		
		if ( nombre!=null && nombre!="" ) {
			criterion = Restrictions.and(criterion, Restrictions.ilike("nombre", "%"+nombre+"%"));
		}
		if ( idEditorial!=null ) {
			criterion = Restrictions.and(criterion, Restrictions.eq("editorial.id", idEditorial));
		}
		if ( idFormato!=null ) {
			criterion = Restrictions.and(criterion, Restrictions.eq("formato.id", idFormato));
		}
		
		modelo.put("nombre", nombre);
		modelo.put("idEditorial", idEditorial);
		modelo.put("idFormato", idFormato);
		
		modelo.put("colecciones", coleccionDao.listarColeccionesPorCriterion(criterion));
		
		return modelo;
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

	@Override
	public ModelMap datosColeccion(Long idColeccion) {
		ModelMap modelo = new ModelMap();
		Coleccion coleccion = coleccionDao.buscarColeccion(idColeccion);
		
		modelo.put("coleccion", coleccion);
		modelo.put("comics", comicDao.listarComicsDeColeccion(idColeccion));
		
		modelo.put("titulo", coleccion.getNombre());
		
		return modelo;
	}
}
