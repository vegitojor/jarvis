package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioDao.registrarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorMail(String email) {
		return usuarioDao.obtenerUsuarioPorMail(email);
	}
	
	
}
