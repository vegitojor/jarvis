$(document).ready(function(){
	$("#nombre").focus();

	$("#confirm").blur(function(){
		if ( $("#confirm").val() != $("#password").val() && $("#confirm").val() != "" ) {
			bootbox.alert("Los passwords no coinciden.", function(){
				$("#confirm").val("");
				$("#confirm").focus();
			});
		} 
	});
});