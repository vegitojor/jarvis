package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(path="/registrar-usuario", method=RequestMethod.POST)
	public ModelAndView registrarUsuario(@RequestParam String nombre, @RequestParam String fechaDeNacimiento,
			@RequestParam (value="pais") Long idPais, @RequestParam String email, @RequestParam String password){
		
		servicioUsuario.guardarUsuario(null, nombre, fechaDeNacimiento, idPais, email, password);

		return new ModelAndView("redirect:/registro-exitoso?username="+nombre+"&usermail="+email);
	}
	
	@RequestMapping(path="/registro-exitoso", method=RequestMethod.GET)
	public ModelAndView registroExitoso(@RequestParam (value="username") String nombre, @RequestParam (value="usermail") String email){
		ModelMap modelo = new ModelMap();
		modelo.put("username", nombre);
		modelo.put("usermail", email);
		return new ModelAndView("registroExitoso", modelo);
	}
	
	@RequestMapping("/validar-unico-mail-usuario")
    public @ResponseBody String validarValorUnico(@RequestParam String email){
		try{
	    	Usuario usuario = servicioUsuario.obtenerUsuarioPorMail(email);
	    	
	    	return Boolean.toString(usuario!=null);
		}catch(Exception e){
    		return "false";
    	}
	}
}