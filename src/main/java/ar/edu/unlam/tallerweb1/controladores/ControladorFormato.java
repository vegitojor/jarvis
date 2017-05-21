package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Formato;

@Controller
public class ControladorFormato {
	
	@RequestMapping("/lista-de-formato")
	public ModelAndView irAListaDeFormato(){
		ModelMap modelo = new ModelMap();
		Formato formato1 = new Formato(1L, "ISSUE");
		Formato formato2 = new Formato(2L, "TP");
		Formato formato3 = new Formato(3L, "HC");
		List <Formato> formatos = new LinkedList <Formato>();
		formatos.add(formato1);
		formatos.add(formato2);
		formatos.add(formato3);
		modelo.put("formatos", formatos);
		return new ModelAndView("listaDeFormatos",modelo);
	}

}
