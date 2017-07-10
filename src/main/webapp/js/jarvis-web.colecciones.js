$(document).ready(function(){
	$("#nombre").autocomplete({
		source: "buscar-colecciones-por-nombre",
		minLength: 2,
		select: function( event, ui ){
			$("#nombre").val( ui.item.value );
		}
	});	
});