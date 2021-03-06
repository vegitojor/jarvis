package ar.edu.unlam.tallerweb1.controladores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.JsonAutocompleteObject;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
	
	public ServicioColeccion getServicioColeccion() {
		return servicioColeccion;
	}

	public void setServicioColeccion(ServicioColeccion servicioColeccion) {
		this.servicioColeccion = servicioColeccion;
	}

	public ServicioEditorial getServicioEditorial() {
		return servicioEditorial;
	}

	public void setServicioEditorial(ServicioEditorial servicioEditorial) {
		this.servicioEditorial = servicioEditorial;
	}

	public ServicioFormato getServicioFormato() {
		return servicioFormato;
	}

	public void setServicioFormato(ServicioFormato servicioFormato) {
		this.servicioFormato = servicioFormato;
	}

	@RequestMapping("/coleccion-{nombreColeccion}")
	public ModelAndView mostrarColeccion(@PathVariable ("nombreColeccion") String nombreColeccion){
		ModelMap model = new ModelMap();
		return new ModelAndView("vistaColeccion", model);
	}

	@RequestMapping("/colecciones")
	public ModelAndView verTodasLasColecciones(@RequestParam (required=false, value="nombre") String nombre,
			@RequestParam (required=false, value="editorial") Long idEditorial,
			@RequestParam (required=false, value="formato") Long idFormato){

		ModelMap modelo = servicioColeccion.coleccionesFiltradas(nombre, idEditorial, idFormato);

		modelo.put("editoriales", servicioEditorial.listarEditoriales());
		modelo.put("formatos", servicioFormato.listarFormatos());

		modelo.put("action", "colecciones");

		modelo.put("titulo", "Colecciones");

		return new ModelAndView("colecciones", modelo);
	}

	@RequestMapping("/administrar-colecciones")
	public ModelAndView administrarColecciones(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("colecciones", servicioColeccion.listarColecciones());
				return new ModelAndView("administrarColecciones", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/nueva-coleccion")
	public ModelAndView nuevaColeccion(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("editoriales", servicioEditorial.listarEditoriales());
				modelo.put("formatos", servicioFormato.listarFormatos());
			
				return new ModelAndView("formularioColeccion", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/editar-coleccion")
	public ModelAndView editarColeccion(@RequestParam (value="coleccion") Long idColeccion, HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();

				modelo.put("coleccion", servicioColeccion.buscarColeccion(idColeccion));
				modelo.put("editoriales", servicioEditorial.listarEditoriales());
				modelo.put("formatos", servicioFormato.listarFormatos());

				return new ModelAndView("formularioColeccion", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path="/guardar-coleccion", method=RequestMethod.POST)
	public ModelAndView guardarColeccion(@RequestParam (required=false, value="id") Long id, @RequestParam (value="nombre") String nombre,
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
				BufferedImage thumbnail = Scalr.resize(imagen, 950);
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
	
	@RequestMapping(path="/detalle-coleccion", method=RequestMethod.GET)
	public ModelAndView detalleColeccion(@RequestParam (value="coleccion") Long idColeccion){
		
		ModelMap modelo = servicioColeccion.datosColeccion(idColeccion);
		
		return new ModelAndView("coleccion", modelo);
	}
	
	@RequestMapping(value="/buscar-colecciones-por-nombre")
	public @ResponseBody void buscarColeccionesPorNombre(@RequestParam String term, HttpServletResponse response) throws IOException{
		
		List<Coleccion> colecciones = servicioColeccion.buscarColeccionesPorNombre(term);
		
		List<JsonAutocompleteObject> jsonAutocompleteObjects = new ArrayList<JsonAutocompleteObject>();
		for (Coleccion coleccion : colecciones) {
			JsonAutocompleteObject jsonAutocompleteObject = new JsonAutocompleteObject(coleccion.getNombre(), coleccion.getNombre());
			jsonAutocompleteObjects.add(jsonAutocompleteObject);
		}

		response.setContentType("application/x-json");
		response.setCharacterEncoding("ISO-8859-1");
		response.getWriter().print(new Gson().toJson(jsonAutocompleteObjects));
	}
}