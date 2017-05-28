package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comic;

@Controller
public class ControladorComic {
	
	@RequestMapping ("/comic")
	public ModelAndView verComic (){
		
		ModelMap modelo = new ModelMap();
		Comic comic = new Comic(1L,"12345","01",null,null,"17,95","24",null, null, null);
		modelo.put("comic", comic);
		return new ModelAndView ("comic", modelo);
	}

}