package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;

@Controller
public class ControladorColeccion {

	@Inject
	private ServicioColeccion servicioColeccion;
	
	@RequestMapping("/coleccion-{nombreColeccion}")
	public ModelAndView mostrarColeccion(@PathVariable ("nombreColeccion") String nombreColeccion){
		ModelMap model = new ModelMap();
		return new ModelAndView("vistaColeccion", model);
	}
	
	@RequestMapping("/administrar-colecciones")
	public ModelAndView administrarColecciones(){
		ModelMap modelo = new ModelMap();
		modelo.put("colecciones", servicioColeccion.listarColecciones());
		return new ModelAndView("administrarColecciones", modelo);
	}
}
