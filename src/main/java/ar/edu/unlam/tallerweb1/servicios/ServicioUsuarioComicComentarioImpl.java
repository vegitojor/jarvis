package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioComicComentarioDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioComicDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

@Service("servicioUsuarioComicComentario")
@Transactional
public class ServicioUsuarioComicComentarioImpl implements ServicioUsuarioComicComentario {

	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private UsuarioComicDao usuarioComicDao;
	@Inject
	private UsuarioComicComentarioDao usuarioComicComentarioDao;

	@Override
	public UsuarioComicComentario guardarUsuarioComicComentario(Long idUsuarioComic, Long idUsuario, String comentario) {
		
		Date fechaDate = new Date();
		UsuarioComicComentario usuarioComicComentario = new UsuarioComicComentario();
		usuarioComicComentario.setUsuarioComic(usuarioComicDao.buscarUsuarioComic(idUsuarioComic));
		usuarioComicComentario.setUsuario(usuarioDao.obtenerUsuarioPorId(idUsuario));
		usuarioComicComentario.setFecha( new Timestamp(fechaDate.getTime()) );
		if ( comentario!=null && comentario!="" ){
			usuarioComicComentario.setComentario(comentario);
		}
		usuarioComicComentario.setLeido(false);
		usuarioComicComentario.setDisponible(true);
		
		usuarioComicComentarioDao.guardarUsuarioComicComentario(usuarioComicComentario);
		
		return usuarioComicComentario;
	}

	@Override
	public List<UsuarioComicComentario> listarUsuarioComicComentarios(Long idUsuarioComic) {
		return usuarioComicComentarioDao.listarUsuarioComicComentarios(idUsuarioComic);
	}

	@Override
	public UsuarioComicComentario marcarComentarioLeido(Long idUsuarioComicComentario) {
		UsuarioComicComentario usuarioComicComentario = usuarioComicComentarioDao.obtenerUsuarioComicComentario(idUsuarioComicComentario);
		usuarioComicComentario.setLeido(true);
		
		return usuarioComicComentario;
	}

	@Override
	public Integer cantidadNotificacionesNoLeidas(Long idUsuario) {
		return usuarioComicComentarioDao.cantidadNotificacionesNoLeidas(idUsuario);
	}

}
