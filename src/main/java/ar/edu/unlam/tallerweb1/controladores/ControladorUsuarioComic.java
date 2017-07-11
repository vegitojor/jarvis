package ar.edu.unlam.tallerweb1.controladores;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;
import ar.edu.unlam.tallerweb1.modelo.UsuarioComicComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComicComentario;

@Controller
public class ControladorUsuarioComic {

	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;
	@Inject
	private ServicioUsuarioComicComentario servicioUsuarioComicComentario;

	@RequestMapping(path="/guardar-usuario-comic", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@RequestParam (value="comic") Long idComic, @RequestParam (value="usuario") Long idUsuario,
			@RequestParam (value="siguiendoActualmente") Boolean siguiendoActualmente) {

		servicioUsuarioComic.guardarUsuarioComic(idUsuario, idComic, siguiendoActualmente);
		return new ModelAndView("redirect:/home?mensaje=Se ha actualizado tu lista de comics.");
	}

	@RequestMapping(path="/consultar-usuario-comic", method=RequestMethod.POST)
	public @ResponseBody String validarUsuarioComic(@RequestParam (value="usuario") Long idUsuario, @RequestParam (value="comic") Long idComic){
		try{
			UsuarioComic usuarioComic = servicioUsuarioComic.consultarUsuarioComic(idUsuario, idComic);

			return Boolean.toString(usuarioComic!=null);
		}catch(Exception e){
			return "false";
		}
	}

	@RequestMapping(value="/guardar-comentario", method=RequestMethod.POST)
	protected @ResponseBody String guardarComentarioComic(@RequestParam (value="usuarioComic") Long idUsuarioComic, @RequestParam (value="usuario") Long idUsuario,
			@RequestParam (value="comentario") String comentario, 
			HttpServletRequest request) {

		servicioUsuarioComicComentario.guardarUsuarioComicComentario(idUsuarioComic, idUsuario, comentario);

		return "OK";
	}

	@RequestMapping("/obtener-comentarios-comic")
	public @ResponseBody void obtenerDatosComic(@RequestParam (value="usuarioComic") Long idUsuarioComic, HttpServletResponse response) throws IOException{

		List<UsuarioComicComentario> comentarios = servicioUsuarioComicComentario.listarUsuarioComicComentarios(idUsuarioComic);

		response.setContentType("application/x-json");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().print(new Gson().toJson(comentarios));
	}
	
	@RequestMapping(value="/notificaciones", method=RequestMethod.GET)
	public ModelAndView notificaciones(HttpServletRequest request) {
		
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			ModelMap modelo = new ModelMap();
			modelo.put( "notificaciones", servicioUsuario.listarNotificaciones( usuario.getId() ) );
			modelo.put("titulo", "Notificaciones");
			
			return new ModelAndView("notificaciones", modelo);
		}
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value="/marcar-notoficacion-leida", method=RequestMethod.GET)
	public ModelAndView notificaciones(@RequestParam (value="notificacion") Long idUsuarioComicComentario) {
		
		servicioUsuarioComicComentario.marcarComentarioLeido(idUsuarioComicComentario);
		
		return new ModelAndView("redirect:/notificaciones?mensaje=Tu notificacion ha sido marcada como leida.");
	}
}