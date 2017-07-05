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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ImagenHelper;
import ar.edu.unlam.tallerweb1.servicios.ServicioAutor;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioComic;

@Controller
public class ControladorComic {

	@Inject
	private ServicioAutor servicioAutor;
	@Inject
	private ServicioColeccion servicioColeccion;
	@Inject
	private ServicioComic servicioComic;
	
	public ServicioAutor getServicioAutor() {
		return servicioAutor;
	}

	public void setServicioAutor(ServicioAutor servicioAutor) {
		this.servicioAutor = servicioAutor;
	}

	public ServicioColeccion getServicioColeccion() {
		return servicioColeccion;
	}

	public void setServicioColeccion(ServicioColeccion servicioColeccion) {
		this.servicioColeccion = servicioColeccion;
	}

	public ServicioComic getServicioComic() {
		return servicioComic;
	}

	public void setServicioComic(ServicioComic servicioComic) {
		this.servicioComic = servicioComic;
	}

	@RequestMapping ("/comic")
	public ModelAndView verComic (){

		ModelMap modelo = new ModelMap();
		Comic comic = new Comic();
		modelo.put("comic", comic);
		return new ModelAndView ("comic", modelo);
	}

	@RequestMapping("/administrar-comics")
	public ModelAndView administrarComics(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("comics", servicioComic.listarComics());
				return new ModelAndView("administrarComics", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");
			}
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/nuevo-comic")
	public ModelAndView nuevoComic(HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");

			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();
				modelo.put("autores", servicioAutor.listarAutores());
				modelo.put("colecciones", servicioColeccion.listarColecciones());

				return new ModelAndView("formularioComic", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");	
			}
		}
		return new ModelAndView("redirect:/login");
	}



	@RequestMapping("/editar-comic")
	public ModelAndView editarComic(@RequestParam (value="comic") Long idComic, HttpServletRequest request){
		if ( request.getSession().getAttribute("usuario") != null ){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			if ( usuario.isAdministrador() ) {
				ModelMap modelo = new ModelMap();

				modelo.put("comic", servicioComic.buscarComic(idComic));
				modelo.put("autores", servicioAutor.listarAutores());
				modelo.put("colecciones", servicioColeccion.listarColecciones());

				return new ModelAndView("formularioComic", modelo);
			} else {
				return new ModelAndView("redirect:/home?mensaje=No tienes permiso para acceder a esa informacion.");	
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path="/guardar-comic", method=RequestMethod.POST)
	public ModelAndView guardarComic(@RequestParam (required=false, value="id") Long id, @RequestParam (value="numero") String numero,
			@RequestParam (value="coleccion") Long idColeccion, @RequestParam (value="autor") Long idAutor, @RequestParam (required=false, value="fechaPublicacion") String fechaPublicacion,
			@RequestParam (required=false, value="isbn") String isbn, @RequestParam (required=false, value="cantidadDePaginas") Integer cantidadDePaginas, @RequestParam (required=false, value="pvp") Double pvp,
			@RequestParam (required=false, value="imagenFile") MultipartFile imagenFile,
			HttpServletRequest request){

		String nombreArchivoImagen = null;
		String extensionArchivoImagen = null;
		String pathImagen = null;

		try {
			if (imagenFile != null && !imagenFile.isEmpty()) {
				nombreArchivoImagen = ImagenHelper.normalizarNombreArchivo("coleccion"+idColeccion+"-"+numero);
				extensionArchivoImagen = imagenFile.getOriginalFilename().substring(imagenFile.getOriginalFilename().lastIndexOf(".") + 1);

				File logo = new File(request.getRealPath("/img/comics") + "/" + nombreArchivoImagen + extensionArchivoImagen);
				imagenFile.transferTo(logo);

				BufferedImage imagen = ImageIO.read(logo);
				BufferedImage thumbnail = Scalr.resize(imagen, 950);
				File outputfileThumbnail = new File(request.getRealPath("/img/comics") + "/" + nombreArchivoImagen + "." + extensionArchivoImagen);
				ImageIO.write(thumbnail, extensionArchivoImagen, outputfileThumbnail);

				pathImagen = nombreArchivoImagen+"."+extensionArchivoImagen;
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		servicioComic.guardarComic(id, numero, idColeccion, idAutor, fechaPublicacion, isbn, cantidadDePaginas, pvp, pathImagen);

		return new ModelAndView("redirect:/administrar-comics?mensaje=El comic ha sido guardado.");
	}
}