$(document).ready(function() {

	$(".btn-ver-mas").bind("click", function(){
		// OBTENEMOS LOS DATOS DESDE LOS ATRIBUTOS DEL BOTON
		var pathImagen = $(this).attr("pathImagen");
		var titulo = $(this).attr("titulo");
		var fechaPublicacion = $(this).attr("fechaPublicacion");
		var autor = $(this).attr("autor");
		var cantidadDePaginas = $(this).attr("cantidadDePaginas");
		var isbn = $(this).attr("isbn");
		var pvp = $(this).attr("pvp");
		var usuarioComicFecha = $(this).attr("usuarioComicFecha");
		
		vaciarDatosModalComic();
		
		$("#comicImagen").attr('src', pathImagen);
		$("#comicTitulo").html(titulo);
		$("#comicFechaPublicacion").html(fechaPublicacion);
		$("#comicAutor").html(autor);
		$("#comicCantidadDePaginas").html(cantidadDePaginas);
		$("#comicISBN").html(isbn);
		$("#comicPVP").html(pvp);
		$("#usuarioComicFecha").text(usuarioComicFecha)
		
		$("#modalComic").modal("show");
	});
});

function vaciarDatosModalComic() {
	$("#comicTitulo").html("");
	$("#comicFechaPublicacion").html("");
	$("#comicAutor").html("");
	$("#comicCantidadDePaginas").html("");
	$("#comicISBN").html("");
	$("#comicPVP").html("");
	$("#comicImagen").attr('src', '');
	$("#usuarioComicFecha").text("")
}