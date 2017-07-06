package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorAutor;
import ar.edu.unlam.tallerweb1.controladores.ControladorColeccion;
import ar.edu.unlam.tallerweb1.controladores.ControladorComic;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorUsuario;
import ar.edu.unlam.tallerweb1.dao.EditorialDao;
import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Formato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioComic;
import ar.edu.unlam.tallerweb1.servicios.ServicioEditorial;
import ar.edu.unlam.tallerweb1.servicios.ServicioFormato;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ControladorTest {

	@Test
	public void sePruebaControladorUsuarioMetodovalidarLoginCorrecto() {

		Usuario usuarioFake = mock(Usuario.class);
		ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		HttpServletResponse responseFake = mock(HttpServletResponse.class);
		ServicioEditorial servicioEditorialFake = mock(ServicioEditorial.class);
		
		when(servicioLoginFake.consultarUsuario(usuarioFake)).thenReturn(usuarioFake);
		when(request.getSession()).thenReturn(session);
		ControladorLogin controlLogin = new ControladorLogin();
		
		
		controlLogin.setServicioLogin(servicioLoginFake);
		controlLogin.setServicioEditorial(servicioEditorialFake);
		
		ModelAndView modeloVista = controlLogin.validarLogin(usuarioFake, request, responseFake);
		
		assertThat(modeloVista.getViewName()).isEqualTo("redirect:/home");   
		
	}
		@Test
	public void queUnUsuarioNoAdministradorNoPuedaCargarColecciones() {
		Usuario usuarioFake = mock(Usuario.class);
		ControladorColeccion controladorColleccionFake = new ControladorColeccion();
		List<Formato> listaFormatosFake = new ArrayList<Formato>();
		List<Editorial> listaEditorialesFake = new ArrayList<Editorial>();
		ServicioColeccion servicioColeccionFake = mock(ServicioColeccion.class);
		ServicioEditorial servicioEditorialFake = mock(ServicioEditorial.class);
		ServicioFormato servicioFormatoFake = mock(ServicioFormato.class);
			
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		
	
		when(request.getSession()).thenReturn(session);
		when(usuarioFake.isAdministrador()).thenReturn(false);
		when(session.getAttribute("usuario")).thenReturn(usuarioFake);
		when(servicioEditorialFake.listarEditoriales()).thenReturn(listaEditorialesFake);
		when(servicioFormatoFake.listarFormatos()).thenReturn(listaFormatosFake);
		
		controladorColleccionFake.setServicioColeccion(servicioColeccionFake);
		controladorColleccionFake.setServicioEditorial(servicioEditorialFake);
		controladorColleccionFake.setServicioFormato(servicioFormatoFake);
		
		
		ModelAndView modeloVista = controladorColleccionFake.nuevaColeccion(request);
		
		assertThat(modeloVista.getViewName()).isEqualTo("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");   
		
	}
	
	@Test
	public void queUnUsuarioAdminPuedeAgregarUnComic(){
		Usuario usuarioFake =mock(Usuario.class);
		ControladorComic controladorComicFake = new ControladorComic();
		HttpServletRequest requestFake = mock(HttpServletRequest.class);
		HttpSession sessionFake = mock(HttpSession.class);
		ServicioColeccion servicioColeccionFake = mock(ServicioColeccion.class);
		ServicioAutor servicioAutorFake = mock(ServicioAutor.class);
		ServicioComic servicioComicFake = mock(ServicioComic.class);
		

		when(requestFake.getSession()).thenReturn(sessionFake);
		when(usuarioFake.isAdministrador()).thenReturn(true);
		when(sessionFake.getAttribute("usuario")).thenReturn(usuarioFake);
		
		controladorComicFake.setServicioAutor(servicioAutorFake);
		controladorComicFake.setServicioColeccion(servicioColeccionFake);
		controladorComicFake.setServicioComic(servicioComicFake);
		ModelAndView modeloVista = controladorComicFake.nuevoComic(requestFake);
		
		assertThat(modeloVista.getViewName()).isEqualTo("formularioComic");
	}
	
	@Test
	public void sePruebaControladorLoginVerTodasLasColecciones(){
		ModelMap modelo = new ModelMap();
		String nombre = "nombre";
		Long idEditorial = 1L;
		Long idFormato = 1L;
		Editorial e1 = mock(Editorial.class);
		Editorial e2 = mock(Editorial.class);
		List<Editorial> listaEditoriales = new ArrayList<>();
		Formato f1 = mock(Formato.class);
		Formato f2 = mock(Formato.class);
		List<Formato> listaFormatos =  new ArrayList<>();
		listaEditoriales.add(e1);
		listaEditoriales.add(e2);
		listaFormatos.add(f1);
		listaFormatos.add(f2);
		
		ControladorColeccion controladorColeccionFake = new ControladorColeccion();
		ServicioColeccion servicioColeccionFake = mock(ServicioColeccion.class);
		ServicioFormato servicioFormatoFake = mock(ServicioFormato.class);
		ServicioEditorial servicioEditorialFake = mock(ServicioEditorial.class);
		
		when(servicioColeccionFake.coleccionesFiltradas(nombre, idEditorial, idFormato)).thenReturn(modelo);
		when(servicioEditorialFake.listarEditoriales()).thenReturn(listaEditoriales);
		when(servicioFormatoFake.listarFormatos()).thenReturn(listaFormatos);
		
		controladorColeccionFake.setServicioColeccion(servicioColeccionFake);
		controladorColeccionFake.setServicioEditorial(servicioEditorialFake);
		controladorColeccionFake.setServicioFormato(servicioFormatoFake);
		ModelAndView miVista = controladorColeccionFake.verTodasLasColecciones(nombre, idEditorial, idFormato);
		
		assertThat(miVista.getViewName()).isEqualTo("colecciones");	
		
	}
	
	@Test
	public void sePruebaQueSePuedanListarTodosLosAutores(){
		Autor a1 = mock(Autor.class);
		Autor a2 = mock(Autor.class);
		List<Autor> listaAutores = new ArrayList<Autor>();
		listaAutores.add(a1);
		listaAutores.add(a2);
		
		ControladorAutor controladorAutorFake = new ControladorAutor();
		ServicioAutor servicioAutorFake = mock(ServicioAutor.class);
		
		when(servicioAutorFake.listarAutores()).thenReturn(listaAutores);
		
		controladorAutorFake.setServicioAutor(servicioAutorFake);
		ModelAndView miVista = controladorAutorFake.verListaAutores();
		
		assertThat(miVista.getViewName()).isEqualTo("autores");
	}
	
	@Test
	public void sePruebaQueSePuedanListarTodosLosComicsDeUnAutor(){
		Long idAutor = Long.parseLong("1");
		Comic c1 = mock(Comic.class);
		Comic c2 = mock(Comic.class);
		List<Comic> listaComicsDeAutor = new ArrayList<Comic>();
//		listaComicsDeAutor.add(c1);
//		listaComicsDeAutor.add(c2);
		Autor autor = new Autor();
		autor.setId(idAutor);
		autor.setNombre("nombre");
	
		
		ControladorAutor controladorAutorFake = new ControladorAutor();
		ServicioAutor servicioAutorFake = mock(ServicioAutor.class);
		
		when(servicioAutorFake.listarComicsPorAutor(idAutor)).thenReturn(listaComicsDeAutor);
		when(servicioAutorFake.buscarAutor(idAutor)).thenReturn(autor);
		
		controladorAutorFake.setServicioAutor(servicioAutorFake);
		ModelAndView miVista = controladorAutorFake.verListaDeComicsPorAutor(idAutor);
		
		assertThat(miVista.getViewName()).isEqualTo("comicsDeAutor");
	}

}
