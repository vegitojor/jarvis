package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFormato;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioFormato servicioFormato;

	@RequestMapping("/login")
	public ModelAndView irALogin(@RequestParam (value="email", required=false) String email) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		if (email!=null && email!="")
			usuario.setEmail(email);
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuarioFromLogin,
			HttpServletRequest request, HttpServletResponse response) {
		
		ModelMap modelo = new ModelMap();
		
		Usuario usuario = servicioLogin.consultarUsuario(usuarioFromLogin);
		
		if ( usuario!=null ) {
			request.getSession().setAttribute("usuario", usuario);
			
			/* LISTAMOS TODOS LOS FORMATOS PARA MOSTRARLOS EN EL NAVBAR */
			request.getSession().setAttribute("formatos", servicioFormato.listarFormatos());
			
			return new ModelAndView("redirect:/home");
		} else {
			modelo.put("error", "Usuario o clave incorrecta.");
		}
		
		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		
		if ( request.getSession().getAttribute("usuario") != null )
			return new ModelAndView("home");
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("usuario");
		return new ModelAndView("redirect:/login");
	}
}
