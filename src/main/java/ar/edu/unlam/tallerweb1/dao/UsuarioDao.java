package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	
	List<Usuario> obtenerUsuarioConCriterion();
	
	Usuario obtenerUsuarioPorMail(String email);
	
	void registrarUsuario(Usuario usuario);

}
