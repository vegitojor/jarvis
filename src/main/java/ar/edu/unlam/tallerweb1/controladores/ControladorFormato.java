package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
