package ar.edu.unlam.tallerweb1.controladores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ImagenHelper;
import ar.edu.unlam.tallerweb1.servicios.ServicioPais;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioComic;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioPais servicioPais;
	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject
	private ServicioUsuarioComic servicioUsuarioComic;

	@RequestMapping(path = "/registro-usuario", method = RequestMethod.GET)
	public ModelAndView irARegistroUsuario() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();

		modelo.put("paises", servicioPais.listarPaises());
		modelo.put("usuario", usuario);
		modelo.put("titulo", "Registro de usuario");
		return new ModelAndView("registroUsuario", modelo);
	}

	@RequestMapping(path="/registrar-usuario", method=RequestMethod.POST)
	public ModelAndView registrarUsuario(@RequestParam String nombre, @RequestParam String email, @RequestParam String fechaDeNacimiento,
			@RequestParam (value="pais") Long idPais, @RequestParam String password,
			@RequestParam (required=false, value="imagenFile") MultipartFile imagenFile, HttpServletRequest request){
		
		String nombreArchivoImagen = null;
		String extensionArchivoImagen = null;
		String pathImagen = null;
		
		try {
			if (imagenFile != null && !imagenFile.isEmpty()) {
				nombreArchivoImagen = ImagenHelper.normalizarNombreArchivo("profile-picture-"+nombre);
				extensionArchivoImagen = imagenFile.getOriginalFilename().substring(imagenFile.getOriginalFilename().lastIndexOf(".") + 1);

				File logo = new File(request.getRealPath("/img/usuarios") + "/" + nombreArchivoImagen + extensionArchivoImagen);
				imagenFile.transferTo(logo);

				BufferedImage imagen = ImageIO.read(logo);
				BufferedImage thumbnail = Scalr.resize(imagen, 950);
				File outputfileThumbnail = new File(request.getRealPath("/img/usuarios") + "/" + nombreArchivoImagen + "." + extensionArchivoImagen);
				ImageIO.write(thumbnail, extensionArchivoImagen, outputfileThumbnail);

				pathImagen = nombreArchivoImagen+"."+extensionArchivoImagen;
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		servicioUsuario.guardarUsuario(null, nombre, fechaDeNacimiento, idPais, email, password, false, pathImagen);

		return new ModelAndView("redirect:/registro-exitoso?username="+nombre+"&usermail="+email);
	}
	
	@RequestMapping(path="/registro-exitoso", method=RequestMethod.GET)
	public ModelAndView registroExitoso(@RequestParam (value="username") String nombre, @RequestParam (value="usermail") String email){
		ModelMap modelo = new ModelMap();
		modelo.put("username", nombre);
		modelo.put("usermail", email);
		return new ModelAndView("registroExitoso", modelo);
	}
	
	@RequestMapping("/validar-unico-mail-usuario")
    public @ResponseBody String validarValorUnico(@RequestParam String email){
		try{
	    	Usuario usuario = servicioUsuario.obtenerUsuarioPorMail(email);
	    	
	    	return Boolean.toString(usuario!=null);
		}catch(Exception e){
    		return "false";
    	}
	}
	
	@RequestMapping("/comunidad")
	public ModelAndView listaDeUsuarios(HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		Long idUsuario = null;
		if(request.getSession().getAttribute("usuario") != null){
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			idUsuario = usuario.getId();
		}
		modelo.put("usuarios", servicioUsuario.listarUsuariosComunidad(idUsuario));
		modelo.put("titulo", "Comunidad");
		return new ModelAndView ("comunidadUsuarios", modelo);
	}
	
	@RequestMapping("/comunidad-vista-usuario")
	public ModelAndView verUsuario(@RequestParam (value="usuario") Long idUsuario){
		ModelMap modelo = new ModelMap();
		Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);
		modelo.put("usuarioComics", servicioUsuarioComic.listarUsuarioComics(idUsuario));
		modelo.put("usuarioComunidad", usuario);
		modelo.put("titulo", usuario.getNombre());
		return new ModelAndView ("usuarioVistaExterna", modelo);
	}
}
