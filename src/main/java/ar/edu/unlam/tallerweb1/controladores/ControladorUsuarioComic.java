package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComic;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;

@Controller
public class ControladorUsuarioComic {

	@Inject
	private ServicioComic servicioComic;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;
	
	@RequestMapping(path="/guardar-usuario-comic", method=RequestMethod.POST)
    public @ResponseBody String guardarComicUsuario(@RequestParam (value="comic") Long idComic, HttpServletRequest request){
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		servicioUsuarioComic.guardarUsuarioComic(usuario.getId(), idComic);
		
		return "OK";
	}
}
