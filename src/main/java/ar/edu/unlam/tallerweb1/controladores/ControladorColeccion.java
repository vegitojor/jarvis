package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.Editorial;
import ar.edu.unlam.tallerweb1.modelo.Formato;
import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;

@Controller
public class ControladorColeccion {

	@Inject
	private ServicioColeccion servicioColeccion;
	@RequestMapping("/coleccion")
	public ModelAndView mostrarColeccion(){
		ModelMap model = new ModelMap();
		
		Editorial editorial1 = new Editorial(1L, "edit");
		Formato formato1 = new Formato(1L, "form");
		Personaje personaje1 = new Personaje(1L, "pers", "onaje");
		Coleccion coleccion1 = new Coleccion(1L, "coleccion1", "holamundo", "imagen", editorial1, formato1, personaje1, true);
		
		List<Comic> lista = servicioColeccion.buscarComic(coleccion1.getId());
		
		model.put("listaFiltrada", lista);
		
		return new ModelAndView("vistaColeccion", model);
		
	}
}
