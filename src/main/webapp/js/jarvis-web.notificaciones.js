var tone = new Audio("tone/tone.mp3");
// UTILIZAMOS ESTA VARIABLE PARA QUE EL ALERTA SUENE SOLO CUANDO LA CANTIDAD DE NOTIFICACIONES NO LEIDAS AUMENTE
var played;

$(document).ready(function() {

	verificarCantidadNotificaciones();
	setInterval('verificarCantidadNotificaciones()', '5000');

});

function verificarCantidadNotificaciones() {

	$.getJSON( "obtener-cantidad-notificaciones", function( cantidadNotificaciones ) {
		mostrarBadgeNotificaciones( cantidadNotificaciones );
	});

}

function mostrarBadgeNotificaciones( cantidadActual ) {
	var cantidadAnterior = $("#badge-notificaciones").text();

	if ( cantidadActual != "" && cantidadActual > 0 ) {
		$("#badge-notificaciones").text( cantidadActual );
		$("#badge-notificaciones").fadeIn();
		if ( cantidadActual > cantidadAnterior && played==false ) {
			tone.play();
			played = true;
		} else {
			played = false;
		}
	} else {
		$("#badge-notificaciones").text(0);
		$("#badge-notificaciones").fadeOut();
	}
}