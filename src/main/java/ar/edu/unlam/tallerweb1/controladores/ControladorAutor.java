package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Autor;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;

@Controller
public class ControladorAutor {
	
	@Inject
	private ServicioAutor servicioAutor;
	
	@RequestMapping ("/autores")
	public ModelAndView  verListaAutores(){
		ModelMap modelo = new ModelMap();
		modelo.put("autores", servicioAutor.listarAutores());
		return new ModelAndView("autores", modelo);
	}
	
	@RequestMapping ("/comics-de-autor")
	public ModelAndView verListaDeComicsPorAutor(@RequestParam (value="autor") Long idAutor){
		ModelMap modelo = new ModelMap();
		Autor autor = servicioAutor.buscarAutor(idAutor);
		modelo.put("comics", servicioAutor.listarComicsPorAutor(idAutor));
		modelo.put("autor", autor);
		modelo.put("titulo", autor.getNombre());
		return new ModelAndView ("comicsDeAutor", modelo);
	}

	public void setServicioAutor(ServicioAutor servicioAutor) {
		this.servicioAutor = servicioAutor;
		
	}

}
