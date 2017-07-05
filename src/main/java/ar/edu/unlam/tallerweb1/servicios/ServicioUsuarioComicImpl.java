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
	public UsuarioComic guardarUsuarioComic(Long idUsuario, Long idComic) {
		Date fechaDate = new Date();
		UsuarioComic usuarioComic = usuarioComicDao.consultarUsuarioComic(idUsuario, idComic);
		
		if ( usuarioComic != null ) {
			if ( !usuarioComic.isSiguiendoActualmente() ) {
				usuarioComic.setFechaCreacion( new Timestamp(fechaDate.getTime()) );
				usuarioComic.setSiguiendoActualmente(true);
				
				usuarioComicDao.guardarUsuarioComic(usuarioComic);
			}
		} else {
			usuarioComic = new UsuarioComic();
			usuarioComic.setUsuario(usuarioDao.obtenerUsuarioPorId(idUsuario));
			usuarioComic.setComic(comicDao.buscarComic(idComic));
			usuarioComic.setFechaCreacion( new Timestamp(fechaDate.getTime()) );
			usuarioComic.setSiguiendoActualmente(true);
			
			usuarioComicDao.guardarNuevoUsuarioComic(usuarioComic);
		}
		
		return usuarioComic;
	}
}
