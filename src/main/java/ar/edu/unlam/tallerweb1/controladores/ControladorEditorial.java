package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Editorial;

public class ControladorEditorial {
	
	@RequestMapping("/editoriales")
	public ModelAndView verEditoriales(){
		ModelMap modelo = new ModelMap();
		Editorial editorial1 = new Editorial(1L,"DC",null,null,null);
		Editorial editorial2 = new Editorial(2L,"Marvel",null,null,null);
		Editorial editorial3 = new Editorial(3L,"Vertigo",null,null,null);
		Editorial editorial4 = new Editorial(4L,"Image",null,null,null);
		Editorial editorial5 = new Editorial(5L,"Dark Horse",null,null,null);
		modelo.put("editorial", editorial1);
		modelo.put("editorial", editorial2);
		modelo.put("editorial", editorial3);
		modelo.put("editorial", editorial4);
		modelo.put("editorial", editorial5);
		
		return new ModelAndView ("editorial", modelo);
	}

}