package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		if (servicioLogin.consultarUsuario(usuario) != null) {
			
			//se inserta el usuario en un servlet para llamarlo en cada metodo de controlador
			request.getSession().setAttribute("user", usuario);
			
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
					
		}
		return new ModelAndView("registroUsuario", model);
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}
