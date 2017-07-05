package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
	private ComicDao comicDao;
	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private UsuarioComicDao usuarioComicDao;
	
	@Override
	public UsuarioComic guardarUsuarioComic(Long idUsuario, Long idComic, Boolean siguiendoActualmente) {
		Date fechaRegistroDate = new Date();
		UsuarioComic usuarioComic = null;
		UsuarioComic usuarioComicExistente = usuarioComicDao.consultarUsuarioComic(idUsuario, idComic);
		
		if ( usuarioComicExistente != null ) {
			usuarioComic = usuarioComicExistente;
		} else {
			usuarioComic = new UsuarioComic();
			usuarioComic.setUsuario(usuarioDao.obtenerUsuarioPorId(idUsuario));
			usuarioComic.setComic(comicDao.buscarComic(idComic));
			
		}
		
		usuarioComic.setSiguiendoActualmente(siguiendoActualmente);
		usuarioComic.setFechaRegistro( new Timestamp(fechaRegistroDate.getTime()) );
		
		if ( usuarioComic.getId()!=null ) {
			usuarioComicDao.guardarUsuarioComic(usuarioComic);
		} else {
			usuarioComicDao.guardarNuevoUsuarioComic(usuarioComic);
		}
		
		return usuarioComic;
	}

	@Override
	public List<UsuarioComic> listarUsuarioComics(Long idUsuario) {
		return usuarioComicDao.listarUsuarioComicsSiguiendoActualmente(idUsuario);
	}

	@Override
	public UsuarioComic consultarUsuarioComic(Long idUsuario, Long idComic) {
		return usuarioComicDao.consultarUsuarioComic(idUsuario, idComic);
	}
}