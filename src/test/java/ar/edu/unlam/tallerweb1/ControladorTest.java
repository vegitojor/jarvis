package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
;public class ControladorTest {

	@Test
	public void sePruebaControladorUsuarioMetodovalidarLoginCorrecto() {
		Usuario usuarioFake = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioFake)).thenReturn(usuarioFake);
		when(request.getSession()).thenReturn(session);
		ControladorLogin controlLogin = new ControladorLogin();
		
		controlLogin.setServicioLogin(servicioLoginFake);
		
		ModelAndView modeloVista = controlLogin.validarLogin(usuarioFake, request);
		
		assertThat(modeloVista.getViewName()).isEqualTo("redirect:/home");   
		
	}

}
