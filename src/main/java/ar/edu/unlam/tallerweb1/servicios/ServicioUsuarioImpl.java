package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioUsuario")
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	@Inject
	private UsuarioDao usuarioDao;
	@Override
	public void registrarUsuario(Usuario usuario) {
		
		usuarioDao.registrarUsuario(usuario);
		
	}

}
