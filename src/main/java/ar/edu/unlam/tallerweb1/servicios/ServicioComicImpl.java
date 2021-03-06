
package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AutorDao;
import ar.edu.unlam.tallerweb1.dao.ColeccionDao;
import ar.edu.unlam.tallerweb1.dao.ComicDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioComicDao;
import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service("servicioComic")
@Transactional
public class ServicioComicImpl implements ServicioComic {
	
	@Inject
	private AutorDao autorDao;
	@Inject
	private ComicDao comicDao;
	@Inject
	private ColeccionDao coleccionDao;
	@Inject
	private UsuarioComicDao usuarioComicDao;
	
	@Override
	public Comic buscarComic(Long id){
		return comicDao.buscarComic(id);
	}

	@Override
	public List<Comic> listarComics() {
		return comicDao.listarComics();
	}

	@Override
	public Comic guardarComic(Long id, String numero, Long idColeccion, Long idAutor, String fechaPublicacion, String isbn,
			Integer cantidadDePaginas, Double pvp, String pathImagen) {
		
		Comic comic = null;
		Date fechaPublicacionDate = FechaHelper.convertirFechaADate(fechaPublicacion);
		
		if ( id!=null ) {
			comic = comicDao.buscarComic(id);
		} else {
			comic = new Comic();
		}
		
		comic.setNumero(numero);
		comic.setColeccion( coleccionDao.buscarColeccion(idColeccion) );
		if ( idAutor!=null ) {
			comic.setAutor(autorDao.buscarAutor(idAutor));
		}
		comic.setFechaPublicacion( new Timestamp(fechaPublicacionDate.getTime()) );
		if ( isbn!=null && isbn!="" ) {
			comic.setIsbn(isbn);
		}
		if ( cantidadDePaginas!=null ) {
			comic.setCantidadDePaginas(cantidadDePaginas);
		}
		if ( pvp!=null ) {
			comic.setPvp(pvp);
		}
		if ( pathImagen!=null && pathImagen!="" ) {
			comic.setPathImagen(pathImagen);
		}
		
		if ( id!=null ) {
			comicDao.guardarComic(comic);
		} else {
			comicDao.guardarNuevoComic(comic);
		}
		
		return comic;
	}

	@Override
	public List<Comic> listarSugerencias(Long idUsuario) {
		return comicDao.listarSugerencias(idUsuario);
	}
}