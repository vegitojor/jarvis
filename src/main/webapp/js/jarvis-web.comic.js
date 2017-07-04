$(document).ready(function() {
	
	$("#seguir").click(function(){
		// OBTENEMOS LOS DATOS PUESTOS EN LOS BOTONES
		var idComic = $(this).attr("idComic");
		var idUsuario = $(this).attr("idUsuario");
		
		if ( idUsuario!="" ) {
			// TODO Terminar la funcionalidad de seguir comic
			bootbox.alert(idComic+" "+idUsuario);
		} else {
			bootbox.alert("<strong>Debes ingresar para marcar tu comic.</strong>", function(){
				window.location.href="login";
			});
		}
	});
	
});