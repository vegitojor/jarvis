package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioComic;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;

@Controller
public class ControladorUsuarioComic {
	
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;
	
	@RequestMapping(path="/guardar-usuario-comic", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@RequestParam (value="comic") Long idComic, @RequestParam (value="usuario") Long idUsuario,
			@RequestParam (value="siguiendoActualmente") Boolean siguiendoActualmente) {
		
		servicioUsuarioComic.guardarUsuarioComic(idUsuario, idComic, siguiendoActualmente);
		return new ModelAndView("redirect:/home?mensaje=Se ha actualizado tu lista de comics.");
	}
	
	@RequestMapping(path="/consultar-usuario-comic", method=RequestMethod.POST)
    public @ResponseBody String validarValorUnico(@RequestParam (value="usuario") Long idUsuario, @RequestParam (value="comic") Long idComic){
		try{
	    	UsuarioComic usuarioComic = servicioUsuarioComic.consultarUsuarioComic(idUsuario, idComic);
	    	
	    	return Boolean.toString(usuarioComic!=null);
		}catch(Exception e){
    		return "false";
    	}
	}
}
