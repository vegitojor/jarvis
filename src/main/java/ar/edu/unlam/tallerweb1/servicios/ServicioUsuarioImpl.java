package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

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
			String password, Boolean administrador) {

		Usuario usuario = null;
		Date fechaDeNacimientoDate =  FechaHelper.convertirFechaADate(fechaDeNacimiento);

		if (id!=null) {
			usuario = usuarioDao.obtenerUsuarioPorId(id);
		} else {
			usuario = new Usuario();
		}

		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setFechaDeNacimiento( new Timestamp(fechaDeNacimientoDate.getTime()) );
		usuario.setPais( paisDao.obtenerPaisPorId(idPais) );
		usuario.setAdministrador(administrador);

		usuarioDao.guardarUsuario(usuario);

		return usuario;
	}
}
