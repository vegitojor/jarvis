$(document).ready(function() {

	$(".btn-ver-mas").unbind("click");
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

		// DATO REQUERIDO PARA LOS COMENTARIOS DE LA PUBLICACION
		var idUsuarioComic = $(this).attr("idUsuarioComic");

		vaciarDatosModalComic();

		$("#comicImagen").attr('src', pathImagen);
		$("#comicTitulo").html(titulo);
		$("#comicFechaPublicacion").html(fechaPublicacion);
		$("#comicAutor").html(autor);
		$("#comicCantidadDePaginas").html(cantidadDePaginas);
		$("#comicISBN").html(isbn);
		$("#comicPVP").html(pvp);
		$("#usuarioComicFecha").text(usuarioComicFecha);

		$("#usuarioComic").val(idUsuarioComic);

		// CREAMOS UNA FUNCION PARA CARGAR TODOS LOS COMENTARIOS DE LA PUBLICACION
		cargarComentarios( idUsuarioComic );

		$("#btnEnviarComentario").unbind("click");
		$("#btnEnviarComentario").bind("click", function(){
			enviarComentario( idUsuarioComic );
		});

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
	$("#usuarioComicFecha").text("");

	$("#usuarioComic").val("");
	
	$("#comentarios").hide();
	$("#comentarios").empty();
}

function cargarComentarios( idUsuarioComic ) {
	$.getJSON( "obtener-comentarios-comic?usuarioComic="+idUsuarioComic, function( usuarioComicComentarios ) {
		if ( usuarioComicComentarios.length > 0 ) {
			$.each(usuarioComicComentarios, function(indice, comentario) {
				
				var _date = new Date(comentario.fecha)
				// CALCULAMOS EL DIA
				var dia = (_date.getDate()<10)?'0'+_date.getDate():_date.getDate();
				var mes = ((_date.getMonth()+1)<10)?'0'+(_date.getMonth()+1):(_date.getMonth()+1);
				var ano = _date.getFullYear();
				var diaComentario = dia + "/" + mes + "/" + ano;
				// CALCULAMOS LA HORA
				var hora = (_date.getHours()<10)?'0'+_date.getHours():_date.getHours();
				var minutos = (_date.getMinutes()<10)?'0'+_date.getMinutes():_date.getMinutes();
				var horaComentario = hora + ":" + minutos;
				
				var divComentario = " <div class='panel panel-default panel-comentario'> " +
									" 	<div class='panel-body comentario'> " +
									" 		<p><a href='comunidad-vista-usuario?usuario="+comentario.usuario.id+"'><strong>"+comentario.usuario.nombre+"</strong></a> - <small>El "+ diaComentario +" a las "+ horaComentario +" hs.</small></p> " +
									"		<hr class='comentario-divider'>" +
									" 		<p class='text'>"+comentario.comentario+"</p> " +
									" 	</div> " +
									" </div> " ;
				
				$("#comentarios").append(divComentario);
				
			});
			
			$("#comentarios").show();
		}
	});
} 

function enviarComentario( idUsuarioComic ) {
	if ( $("#comentario").val() != "" ) {

		$.ajax({
			url: "guardar-comentario",
			type: "POST",
			contentType: "application/x-www-form-urlencoded;charset=ISO-8859-1",
			data: 'usuarioComic='+idUsuarioComic+"&usuario="+$("#usuario").val()+"&comentario="+$("#comentario").val(),
			success: function(){
				$("#comentario").val("");
				$("#modalComic").modal("hide");
				$('.alert-info').html("<p>Tu comentario ha sido enviado</p>");
				$('.alert-info').fadeIn();
				setTimeout("$('.alert-info').fadeOut()","3000");
				//bootbox.alert("Se envio el comentario");
			}
		});
	}
}