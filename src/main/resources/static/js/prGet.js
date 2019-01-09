var prget = ( function() {
	return {
		prget(){
			var name = $("#user").val();
			
			if (name === "") {
				$("#mensajeFalta").text("por favor ingrese el usuario");
				$("#divError").show();
			}else{
                $("#divError").hide();
                $("#envio").attr('disabled', true);
                
                var promesa = apiClient.pruebaGet(name);
                promesa.then(              
                		function(datos){
            				name = $("#user").val("");
                			alert(datos);
            				$("#mensajeFalta").text("Inicio Correcto");
            				$("#divError").show();

                		},
                        function () {
                            $("#mensajeFalta").text(promesa.responseText);
                            $("#divError").show();
                        });
			}
			
		}
	};
}());