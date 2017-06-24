package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	private Usuario usuarioCreado;
	public Usuario getUsuarioCreado() {
		return usuarioCreado;
	}
	public void setUsuarioCreado(Usuario usuarioCreado) {
		this.usuarioCreado = usuarioCreado;
	}

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
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();

		if (servicioLogin.consultarUsuario(usuario) != null) {
			usuarioCreado = usuario;
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta.");
		}
		return new ModelAndView("login", model);
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
