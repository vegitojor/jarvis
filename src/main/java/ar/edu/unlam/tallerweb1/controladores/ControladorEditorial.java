package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.servicios.ServicioEditorial;

@Controller
public class ControladorEditorial {
	
	@Inject
	private ServicioEditorial servicioEditorial;
	
	@RequestMapping("/editorial-{nombreEditorial}")
	public ModelAndView coleccionesPorEditorial(@PathVariable ("nombreEditorial") String nombreEditorial){
		ModelMap modelo = new ModelMap();
		Editorial editorial = servicioEditorial.buscarEditorialPorNombre(nombreEditorial);
		
		modelo.put("editorial", editorial);
		modelo.put("titulo", editorial.getNombre());
		
		return new ModelAndView("coleccionesPorEditorial", modelo);
	}
	
	@RequestMapping("/administrar-editoriales")
	public ModelAndView administrarEditoriales(){
		ModelMap modelo = new ModelMap();
		modelo.put("editoriales", servicioEditorial.listarEditoriales());
		return new ModelAndView("administrarEditoriales", modelo);
	}
	
	@RequestMapping("/nueva-editorial")
	public ModelAndView nuevaEditorial(){
		ModelMap modelo = new ModelMap();
		modelo.put("editorial", new Editorial());
		return new ModelAndView("formularioEditorial", modelo);
	}
	
	@RequestMapping("/editar-editorial")
	public ModelAndView editarEditorial(@RequestParam (value="editorial") Long idEditorial){
		ModelMap modelo = new ModelMap();
		modelo.put("editorial", servicioEditorial.buscarEditorial(idEditorial));
		return new ModelAndView("formularioEditorial", modelo);
	}
	
	@RequestMapping(path="/guardar-editorial", method=RequestMethod.POST)
	public ModelAndView guardarEditorial(@ModelAttribute("editorial") Editorial editorial) {
		servicioEditorial.guardarEditorial(editorial);
		return new ModelAndView("redirect:/administrar-editoriales?mensaje=La editorial ha sido guardada.");
	}
}