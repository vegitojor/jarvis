$(document).ready(function(){
	$("#nombre").focus();
	
	// AL HACER CLICK EN EL BOTON PARA CAMBIAR IMAGEN, CAMBIAMOS ATRIBUTOS Y ABRIMOS LA VENTANA PARA ELEGIR ARCHIVOS
	$("#btnCambiarImagen").click(function(){
		$("#imagenFileCargada").removeAttr('disabled');
		$("#imagenFileCargada").attr('name', 'imagenFile');
		$("#imagenFileCargada").prop('required', true);
		$("#imagenFileCargada").click();
		$(this).parents("div#botones").hide();
	});

	$("#verImagen").bind("click", function(){
		var pathImagen = $(this).attr("pathImagen");
		$("#imagen").attr('src', 'img/colecciones/'+pathImagen);
		$('#imagenColeccion').modal('show');
	});
	
});