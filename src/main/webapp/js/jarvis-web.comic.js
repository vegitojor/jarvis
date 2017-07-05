$(document).ready(function() {

	$("#seguirSinLogin").click(function(){
		bootbox.alert("<strong>Debes ingresar para marcar tu comic.</strong>", function(){
			window.location.href="login";
		});
	});

	$("#seguir").click(function(){
		// OBTENEMOS LOS DATOS PUESTOS EN LOS BOTONES
		var idComic = $(this).attr("idComic");
		
		$.ajax({
			url:"guardar-usuario-comic",
			method:"POST",
			data:"comic="+idComic,
			dataType: "json",
			success: function(){
				window.location.href="home?mensaje=Has marcado un nuevo comic.";
			}
		});
	});

});