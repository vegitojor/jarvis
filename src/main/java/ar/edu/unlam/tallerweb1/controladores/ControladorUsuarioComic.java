package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;

@Controller
public class ControladorUsuarioComic {
	
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;
	
	@RequestMapping(path="/guardar-usuario-comic", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@ModelAttribute("usuarioComic") UsuarioComic usuarioComic) {
		servicioUsuarioComic.guardarUsuarioComic(usuarioComic);
		return new ModelAndView("redirect:/home?mensaje=Has marcado un nuevo comic.");
	}
}
