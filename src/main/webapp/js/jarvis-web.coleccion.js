$(document).ready(function() {

	$("#seguirSinLogin").click(function(){
		$("#modalComic").modal("hide");
		bootbox.alert("<p class='text-center'>Debes ingresar para marcar tu comic.</p><p class='text-center'>Si no tienes cuenta, haz click <a href='registro-usuario'>aqu&iacute;.</a></p>", function(){
			window.location.href="login";
		});
	});
	
	$(".btn-ver-mas").bind("click", function(){
		// OBTENEMOS LOS DATOS DESDE LOS ATRIBUTOS DEL BOTON
		var idComic = $(this).attr("idComic");
		var pathImagen = $(this).attr("pathImagen");
		var titulo = $(this).attr("titulo");
		var fechaPublicacion = $(this).attr("fechaPublicacion");
		var autor = $(this).attr("autor");
		var cantidadDePaginas = $(this).attr("cantidadDePaginas");
		var isbn = $(this).attr("isbn");
		var pvp = $(this).attr("pvp");
		
		vaciarDatosModalComic();
		
		$("#idComic").val(idComic);
		$("#comicImagen").attr('src', pathImagen);
		$("#comicTitulo").html(titulo);
		$("#comicFechaPublicacion").html(fechaPublicacion);
		$("#comicAutor").html(autor);
		$("#comicCantidadDePaginas").html(cantidadDePaginas);
		$("#comicISBN").html(isbn);
		$("#comicPVP").html(pvp);
		
		// VALIDAMOS LOS BOTONES QUE SE DEBEN MOSTRAR AL USUARIO
		validarBotonesParaElUsuario();
		
		$("#modalComic").modal("show");
	});
});

function vaciarDatosModalComic() {
	$("#idComic").val("");
	$("#comicTitulo").html("");
	$("#comicFechaPublicacion").html("");
	$("#comicAutor").html("");
	$("#comicCantidadDePaginas").html("");
	$("#comicISBN").html("");
	$("#comicPVP").html("");
	$("#comicImagen").attr('src', '');
	
	$("#saveUsuarioComic").removeClass("btn-primary");
	$("#saveUsuarioComic").removeClass("btn-danger");
	
	$("#icono").removeClass("glyphicon-list-alt");
	$("#icono").removeClass("glyphicon-trash");
}

function validarBotonesParaElUsuario() {
	if ( $("#idUsuario")!="" ) {

		$.ajax({
			url:"consultar-usuario-comic",
			method: "POST",
			data:"usuario="+$("#idUsuario").val()+"&comic="+$("#idComic").val(),
			dataType: "json",
			success: function(exists){
				if (exists==true || exists=="true"){
					$("#loTengo").show();
					$("#icono").addClass("glyphicon-trash");
					$("#siguiendoActualmente").val(false)
					$("#saveUsuarioComic").addClass("btn-danger");
					$("#textoBoton").text("Quitar de la lista");
				} else {
					$("#loTengo").hide();
					$("#siguiendoActualmente").val(true)
					$("#icono").addClass("glyphicon-list-alt");
					$("#saveUsuarioComic").addClass("btn-primary");
					$("#textoBoton").text("Marcar comic");
				}
			}

		});

	}
}