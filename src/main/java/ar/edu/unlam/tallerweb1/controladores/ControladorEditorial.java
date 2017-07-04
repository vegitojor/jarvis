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

import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioEditorial;

@Controller
public class ControladorEditorial {

	@Inject
	private ServicioEditorial servicioEditorial;
	
	@Inject
	private ServicioColeccion servicioColeccion;

	@RequestMapping("/editorial-{nombreEditorial}")
	public ModelAndView coleccionesPorEditorial(@PathVariable ("nombreEditorial") String nombreEditorial){
		ModelMap modelo = new ModelMap();
		Editorial editorial = servicioEditorial.buscarEditorialPorNombre(nombreEditorial);

		modelo.put("editorial", editorial);
		modelo.put("titulo", editorial.getNombre());
		modelo.put("colecciones", servicioColeccion.listarColeccionesPorEditorial(editorial.getId()));

		return new ModelAndView("coleccionesPorEditorial", modelo);
	}

	@RequestMapping("/administrar-editoriales")
	public ModelAndView administrarEditoriales(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("editoriales", servicioEditorial.listarEditoriales());
				return new ModelAndView("administrarEditoriales", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/nueva-editorial")
	public ModelAndView nuevaEditorial(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				Editorial editorial = new Editorial();
				editorial.setActivo(true);
				modelo.put("editorial", editorial);

				return new ModelAndView("formularioEditorial", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/editar-editorial")
	public ModelAndView editarEditorial(@RequestParam (value="editorial") Long idEditorial, HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("editorial", servicioEditorial.buscarEditorial(idEditorial));
				return new ModelAndView("formularioEditorial", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path="/guardar-editorial", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@ModelAttribute("editorial") Editorial editorial) {
		servicioEditorial.guardarEditorial(editorial);
		return new ModelAndView("redirect:/administrar-editoriales?mensaje=La editorial ha sido guardada.");
	}

	@RequestMapping("/activar-editorial")
	public ModelAndView activarEditorial(@RequestParam (value="editorial") Long idEditorial){
		servicioEditorial.cambiarEstadoEditorial(idEditorial, true);
		return new ModelAndView("redirect:/administrar-editoriales?mensaje=La editorial "+idEditorial+" ha sido activada.");
	}

	@RequestMapping("/desactivar-editorial")
	public ModelAndView desactivarEditorial(@RequestParam (value="editorial") Long idEditorial){
		servicioEditorial.cambiarEstadoEditorial(idEditorial, false);
		return new ModelAndView("redirect:/administrar-editoriales?mensaje=La editorial "+idEditorial+" ha sido desactivada.");
	}
}