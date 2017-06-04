package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.servicios.ServicioEditorial;

@Controller
public class ControladorEditorial {
	
	@Inject
	private ServicioEditorial servicioEditorial;
	
	@RequestMapping("/editoriales")
	public ModelAndView listarEditoriales(){
		ModelMap modelo = new ModelMap();
		modelo.put("editoriales", servicioEditorial.listarEditoriales());
		return new ModelAndView ("editoriales", modelo);
	}
	
	@RequestMapping("/verEditorial")
	public ModelAndView verEditorial(@RequestParam(value="id") Long id){
		ModelMap modelo = new ModelMap();
		Editorial editorial = (Editorial) servicioEditorial.buscarEditorial(id);
		modelo.put("editorial", editorial);
		modelo.put("titulo", editorial.getNombre());
		return new ModelAndView ("editorial", modelo);
	}
	
}