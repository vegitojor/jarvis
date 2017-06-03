package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Editorial;

@Controller
public class ControladorEditorial {
	
	@RequestMapping("/editoriales")
	public ModelAndView verEditoriales(){
		ModelMap modelo = new ModelMap();
		List <Editorial> listaEditoriales = new ArrayList<Editorial>();
//		Editorial editorial1 = new Editorial(1L,"DC","dc.jpg");
//		Editorial editorial2 = new Editorial(2L,"Marvel","marvel.jpg");
//		Editorial editorial3 = new Editorial(3L,"Vertigo","vertigo.jpg");
//		Editorial editorial4 = new Editorial(4L,"Image","image.jpg");
//		Editorial editorial5 = new Editorial(5L,"Dark Horse","darkhorse.jpg");
//		
//		listaEditoriales.add(editorial1);
//		listaEditoriales.add(editorial2);
//		listaEditoriales.add(editorial3);
//		listaEditoriales.add(editorial4);
//		listaEditoriales.add(editorial5);
		
		modelo.put("editoriales", listaEditoriales);
		
		return new ModelAndView ("editoriales", modelo);
	}

}
