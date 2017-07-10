package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PaisDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private PaisDao paisDao;
	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public Usuario obtenerUsuarioPorMail(String email) {
		return usuarioDao.obtenerUsuarioPorMail(email);
	}

	@Override
	public Usuario guardarUsuario(Long id, String nombre, String fechaDeNacimiento, Long idPais, String email,
			String password, Boolean administrador, String pathImagen) {

		Usuario usuario = null;
		Date fechaDeNacimientoDate =  FechaHelper.convertirFechaADate(fechaDeNacimiento);

		if (id!=null) {
			usuario = usuarioDao.obtenerUsuarioPorId(id);
		} else {
			usuario = new Usuario();
		}

		usuario.setEmail(email.toLowerCase());
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setFechaDeNacimiento( new Timestamp(fechaDeNacimientoDate.getTime()) );
		usuario.setPais( paisDao.obtenerPaisPorId(idPais) );
		usuario.setAdministrador(administrador);
		if ( pathImagen!=null && pathImagen!="" ) {
			usuario.setPathImagen(pathImagen);
		}

		usuarioDao.guardarUsuario(usuario);

		return usuario;
	}

	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioDao.obtenerTodosLosUsuariosRegistrados();
	}

	@Override
	public Usuario buscarUsuario(Long idUsuario) {
		return usuarioDao.obtenerUsuarioPorId(idUsuario);
	}

	@Override
	public List<Usuario> listarUsuariosComunidad(Long idUsuario, Long idPais) {
		Criterion criterion = Restrictions.ne("administrador", true);
		
		if (idUsuario != null) {
			criterion = Restrictions.and(criterion, Restrictions.ne("id", idUsuario));
		}
		if (idPais != null) {
			criterion = Restrictions.and(criterion, Restrictions.eq("pais.id", idPais));
		}
		
		return usuarioDao.obtenerUsuarioConCriterion(criterion);
	}
}
