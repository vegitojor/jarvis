package ar.edu.unlam.tallerweb1.controladores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ImagenHelper;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioEditorial;
import ar.edu.unlam.tallerweb1.servicios.ServicioFormato;

@Controller
public class ControladorColeccion {

	@Inject
	private ServicioColeccion servicioColeccion;
	@Inject
	private ServicioEditorial servicioEditorial;
	@Inject
	private ServicioFormato servicioFormato;
	
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
	
	@RequestMapping("/nueva-coleccion")
	public ModelAndView nuevaColeccion(){
		ModelMap modelo = new ModelMap();
		modelo.put("editoriales", servicioEditorial.listarEditoriales());
		modelo.put("formatos", servicioFormato.listarFormatos());
		
		return new ModelAndView("formularioColeccion", modelo);
	}
	
	@RequestMapping("/editar-coleccion")
	public ModelAndView editarColeccion(@RequestParam (value="coleccion") Long idColeccion){
		ModelMap modelo = new ModelMap();
		
		modelo.put("coleccion", servicioColeccion.buscarColeccion(idColeccion));
		modelo.put("editoriales", servicioEditorial.listarEditoriales());
		modelo.put("formatos", servicioFormato.listarFormatos());
		
		return new ModelAndView("formularioColeccion", modelo);
	}
	
	@RequestMapping(path="/guardar-coleccion", method=RequestMethod.POST)
	public ModelAndView guardarColeccion(@RequestParam (required=false, value="id") Long id, @RequestParam (required=false, value="nombre") String nombre,
			@RequestParam (required=false, value="imagenFile") MultipartFile imagenFile, @RequestParam (required=false, value="descripcion") String descripcion,
			@RequestParam (value="editorial") Long idEditorial, @RequestParam (value="formato") Long idFormato,
			@RequestParam (required=false, value="volumen") String volumen, @RequestParam (required=false, value="enCurso", defaultValue="false") Boolean enCurso,
			HttpServletRequest request){
		
		String nombreArchivoImagen = null;
		String extensionArchivoImagen = null;
		String pathImagen = null;

		try {
			if (imagenFile != null && !imagenFile.isEmpty()) {
				nombreArchivoImagen = ImagenHelper.normalizarNombreArchivo(nombre);
				extensionArchivoImagen = imagenFile.getOriginalFilename().substring(imagenFile.getOriginalFilename().lastIndexOf(".") + 1);

				File logo = new File(request.getRealPath("/img/colecciones") + "/" + nombreArchivoImagen + extensionArchivoImagen);
				imagenFile.transferTo(logo);

				BufferedImage imagen = ImageIO.read(logo);
				BufferedImage thumbnail = Scalr.resize(imagen, 900);
				File outputfileThumbnail = new File(request.getRealPath("/img/colecciones") + "/" + nombreArchivoImagen + "." + extensionArchivoImagen);
				ImageIO.write(thumbnail, extensionArchivoImagen, outputfileThumbnail);
				
				pathImagen = nombreArchivoImagen+"."+extensionArchivoImagen;
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		servicioColeccion.guardarColecion(id, nombre, descripcion, pathImagen, idEditorial, idFormato, volumen, enCurso);
		
		return new ModelAndView("redirect:/administrar-colecciones?mensaje=La coleccion ha sido guardada.");
	}
}
