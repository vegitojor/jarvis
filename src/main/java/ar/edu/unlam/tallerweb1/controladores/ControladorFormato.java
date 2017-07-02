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
import ar.edu.unlam.tallerweb1.modelo.Formato;
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
	public ModelAndView administrarFormatos(){
		ModelMap modelo = new ModelMap();
		modelo.put("formatos", servicioFormato.listarFormatos());
		return new ModelAndView("administrarFormatos", modelo);
	}
	
	@RequestMapping("/nuevo-formato")
	public ModelAndView nuevoFormato(){
		ModelMap modelo = new ModelMap();
		modelo.put("formato", new Formato());
		return new ModelAndView("formularioFormato", modelo);
	}
	
	@RequestMapping("/editar-formato")
	public ModelAndView editarFormato(@RequestParam (value="formato") Long idFormato){
		ModelMap modelo = new ModelMap();
		modelo.put("formato", servicioFormato.buscarFormato(idFormato));
		return new ModelAndView("formularioFormato", modelo);
	}
	
	@RequestMapping(path="/guardar-formato", method=RequestMethod.POST)
	public ModelAndView guardarFormato(@ModelAttribute("formato") Formato formato) {
		servicioFormato.guardarFormato(formato);
		return new ModelAndView("redirect:/administrar-formatos?mensaje=El formato ha sido guardado.");
	}
}
