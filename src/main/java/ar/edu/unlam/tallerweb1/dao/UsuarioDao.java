package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	
	List<Usuario> obtenerUsuarioConCriterion();
	
	Usuario obtenerUsuarioPorId(Long id);
	
	Usuario obtenerUsuarioPorMail(String email);
	
	void guardarUsuario(Usuario usuario);

}
