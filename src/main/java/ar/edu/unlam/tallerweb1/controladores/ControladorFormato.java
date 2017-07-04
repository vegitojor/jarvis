package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Formato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFormato;

@Controller
public class ControladorFormato {

	@Inject
	private ServicioFormato servicioFormato;

	@RequestMapping("/formatos")
	public ModelAndView irAListaDeFormato(){
		ModelMap modelo = new ModelMap();

		modelo.put("formatos", servicioFormato.listarFormatos());
		modelo.put("titulo", "Formatos");

		return new ModelAndView("formatos", modelo);
	}

	@RequestMapping("/formato-{nombreFormato}")
	public ModelAndView coleccionesPorFormato(@PathVariable ("nombreFormato") String nombreFormato){
		ModelMap modelo = new ModelMap();
		Formato formato = servicioFormato.buscarFormatoPorNombre(nombreFormato);

		modelo.put("formato", formato);
		modelo.put("titulo", "Formato "+formato.getNombre());

		return new ModelAndView("coleccionesPorFormato", modelo);
	}

	@RequestMapping("/administrar-formatos")
	public ModelAndView administrarFormatos(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("formatos", servicioFormato.listarFormatos());
				return new ModelAndView("administrarFormatos", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/nuevo-formato")
	public ModelAndView nuevoFormato(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				Formato formato = new Formato();
				formato.setActivo(true);
				modelo.put("formato", formato);

				return new ModelAndView("formularioFormato", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/editar-formato")
	public ModelAndView editarFormato(@RequestParam (value="formato") Long idFormato, HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("formato", servicioFormato.buscarFormato(idFormato));
				return new ModelAndView("formularioFormato", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path="/guardar-formato", method=RequestMethod.POST)
	public ModelAndView guardarFormato(@ModelAttribute("formato") Formato formato) {
		servicioFormato.guardarFormato(formato);
		return new ModelAndView("redirect:/administrar-formatos?mensaje=El formato ha sido guardado.");
	}

	@RequestMapping("/activar-formato")
	public ModelAndView activarFormato(@RequestParam (value="formato") Long idFormato){
		servicioFormato.cambiarEstadoFormato(idFormato, true);
		return new ModelAndView("redirect:/administrar-formatos?mensaje=El formato "+idFormato+" ha sido activado.");
	}

	@RequestMapping("/desactivar-formato")
	public ModelAndView desactivarFormato(@RequestParam (value="formato") Long idFormato){
		servicioFormato.cambiarEstadoFormato(idFormato, false);
		return new ModelAndView("redirect:/administrar-formatos?mensaje=El formato "+idFormato+" ha sido desactivado.");
	}
}
