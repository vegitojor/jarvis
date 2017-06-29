$(document).ready(function(){
	$("#nombre").focus();
	
	$("#email").blur(function(){
		// VALIDAMOS QUE NO EXISTA UN MAIL YA INGRESADO ANTERIORMENTE
		if ( $("#email").val() != "" ) {
			$.ajax({
				url:"validar-unico-mail-usuario",
				data:"email="+$("#email").val(),
				dataType: "json",
				success: function(exists){
					if (exists==true || exists=="true"){
						$("#email").val("");
						bootbox.alert("Ya existe una cuenta para el E-Mail ingresado.", function(){
							$("#email").focus();
						});
					}
				}

			});
		}
	});

	$("#confirm").blur(function(){
		if ( $("#confirm").val() != $("#password").val() && $("#confirm").val() != "" ) {
			bootbox.alert("Los passwords no coinciden.", function(){
				$("#confirm").val("");
				$("#confirm").focus();
			});
		} 
	});
});