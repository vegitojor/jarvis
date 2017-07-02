package ar.edu.unlam.tallerweb1.servicios;

public class ImagenHelper {

	public static String normalizarNombreArchivo(String nombre) {
		String nombreArchivo = nombre.replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i")
				.replaceAll("ó", "o").replaceAll("ú", "u").replaceAll("ñ", "n").replaceAll("Á", "A")
				.replaceAll("É", "E").replaceAll("Í", "I").replaceAll("Ó", "O").replaceAll("Ú", "U")
				.replaceAll("Ñ", "N").replaceAll("&", "y").replaceAll("%", "").replaceAll("$", "").replaceAll("#", "")
				.replaceAll("-", "").replaceAll("_", "-").replaceAll("/", "").replaceAll("=", "").replaceAll("@", "")
				.replaceAll("\\(", "").replaceAll("\\)", "");

		nombreArchivo = nombreArchivo.trim().replace(" ", "-").replace(".", "_");

		return nombreArchivo;
	}
}
