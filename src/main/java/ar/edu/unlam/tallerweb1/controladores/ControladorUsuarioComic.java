package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;

@Controller
public class ControladorUsuarioComic {
	
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;
	
	@RequestMapping(path="/guardar-editorial", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@ModelAttribute("editorial") Editorial editorial) {
		servicioUsuarioComic.guardarUsuarioComic();
		return new ModelAndView("redirect:/home?mensaje=Has marcado un nuevo comic.");
	}
}
