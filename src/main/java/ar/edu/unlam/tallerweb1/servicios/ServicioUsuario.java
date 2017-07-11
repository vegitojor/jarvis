package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;

public interface ServicioUsuario {
	
	Usuario guardarUsuario(Long id, String nombre, String fechaDeNacimiento, Long idPais, String email, String password, Boolean administrador, String pathImagen);
	
	Usuario obtenerUsuarioPorMail(String email);
	
	Usuario buscarUsuario (Long idUsuario);
	
	public List<Usuario> listarTodosLosUsuarios();
	
	public List<Usuario> listarUsuariosComunidad(Long idUsuario, Long idPais);
	
	public List<UsuarioComicComentario> listarNotificaciones(Long idUsuario);
}
