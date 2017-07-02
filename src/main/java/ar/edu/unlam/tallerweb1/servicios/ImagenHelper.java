package ar.edu.unlam.tallerweb1.servicios;

public class ImagenHelper {

	public static String normalizarNombreArchivo(String nombre) {
		String nombreArchivo = nombre.replaceAll("�", "a").replaceAll("�", "e").replaceAll("�", "i")
				.replaceAll("�", "o").replaceAll("�", "u").replaceAll("�", "n").replaceAll("�", "A")
				.replaceAll("�", "E").replaceAll("�", "I").replaceAll("�", "O").replaceAll("�", "U")
				.replaceAll("�", "N").replaceAll("&", "y").replaceAll("%", "").replaceAll("$", "").replaceAll("#", "")
				.replaceAll("-", "").replaceAll("_", "-").replaceAll("/", "").replaceAll("=", "").replaceAll("@", "")
				.replaceAll("\\(", "").replaceAll("\\)", "");

		nombreArchivo = nombreArchivo.trim().replace(" ", "-").replace(".", "_");

		return nombreArchivo;
	}
}
