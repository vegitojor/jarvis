$(document).ready(function() {

	$("#seguirSinLogin").click(function(){
		bootbox.alert("<strong>Debes ingresar para marcar tu comic.</strong>", function(){
			window.location.href="login";
		});
	});
});