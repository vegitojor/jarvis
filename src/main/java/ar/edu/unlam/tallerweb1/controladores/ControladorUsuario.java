package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioPais;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioPais servicioPais;
	
	@RequestMapping(path = "/registro-usuario", method = RequestMethod.GET)
	public ModelAndView irARegistroUsuario() {
		ModelMap modelo = new ModelMap();
		
		modelo.put("paises", servicioPais.listarPaises());
		
		modelo.put("titulo", "Registro de usuario");
		return new ModelAndView("registroUsuario", modelo);
	}
}
