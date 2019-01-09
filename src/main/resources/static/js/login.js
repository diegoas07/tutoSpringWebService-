var login = ( function() {
	return {
		login(){
			var name = $("#user").val();
			var pws = $("#pass").val();
			
			if (name === "") {
				$("#mensajeFalta").text("por favor ingrese el usuario");
				$("#divError").show();
			}else if(pws === "") {
				$("#mensajeFalta").text("por favor ingrese la contraseña");
				$("#divError").show();
			}else{
                $("#divError").hide();
                $("#envio").attr('disabled', true);
                
                var promesa = apiClient.login(name, pws);
                promesa.then(              
                		function(datos){
            				name = $("#user").val("");
                			pws = $("#pass").val("");              			
                			sessionStorage.setItem("nombres",datos.nombre);
                			sessionStorage.setItem("token",datos.token);
                            $("#envio").attr('disabled', true);
            				$("#mensajeFalta").text("Inicio Correcto");
            				$("#divError").show();

                		},
                        function () {
                            $("#mensajeFalta").text(promesa.responseText);
                            $("#divError").show();
                            $("#envio").attr('disabled', false);
                        });
			}
			
		}
	};
}());