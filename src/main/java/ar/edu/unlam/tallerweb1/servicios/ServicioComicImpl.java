package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.ComicDao;
import ar.edu.unlam.tallerweb1.modelo.Comic;

@Service("servicioComic")
public class ServicioComicImpl implements ServicioComic {
	
	@Inject
	private ComicDao comicDao;
	
	@Override
	public void agregarUnNuevoComic(){
		// ¿es innecesario este metodo ya que al crearse el objeto se persiste?
	}
	
	@Override
	public Comic buscarComic(Long id){
		return comicDao.buscarComic(id);
	}
	
	

}
