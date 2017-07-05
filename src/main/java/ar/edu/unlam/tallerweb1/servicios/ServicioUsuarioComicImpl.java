package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ComicDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioComicDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;

@Service("servicioUsuarioComic")
@Transactional
public class ServicioUsuarioComicImpl implements ServicioUsuarioComic {

	@Inject
	private UsuarioComicDao usuarioComicDao;
	@Inject
	private ComicDao comicDao;
	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public UsuarioComic guardarUsuarioComic(UsuarioComic usuarioComic) {
		Date fechaDate = new Date();

		usuarioComicDao.guardarUsuarioComic(usuarioComic);
		usuarioComicDao.guardarNuevoUsuarioComic(usuarioComic);
		
		return usuarioComic;
	}
}