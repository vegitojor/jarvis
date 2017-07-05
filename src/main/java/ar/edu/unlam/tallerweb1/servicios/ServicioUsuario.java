package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {
	
	Usuario guardarUsuario(Long id, String nombre, String fechaDeNacimiento, Long idPais, String email, String password, Boolean administrador);
	
	Usuario obtenerUsuarioPorMail(String email);
	
	public List<Usuario> listarTodosLosUsuarios();
}
