package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPais;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioPais servicioPais;
	@Inject
	private ServicioUsuario servicioUsuario;
	
	
	@RequestMapping(path = "/registro-usuario", method = RequestMethod.GET)
	public ModelAndView irARegistroUsuario() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		
		modelo.put("paises", servicioPais.listarPaises());
		modelo.put("usuario", usuario);
		modelo.put("titulo", "Registro de usuario");
		return new ModelAndView("registroUsuario", modelo);
	}
	
	@RequestMapping(path = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario usuario){
		
		servicioUsuario.registrarUsuario(usuario);
		
		return new ModelAndView ("login");
	}
}
