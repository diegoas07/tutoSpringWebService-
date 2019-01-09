var apiClient =( function() {
	var equipoBackEnd = configuracion.getEquipoBackEnd();
	var version = configuracion.getVersion();
	
	return{
		login(name, psw){
			return $.ajax({
				url: equipoBackEnd+"/user/login",
				type: "POST",
				data: '{"name":"'+name+'" ,"psw":"'+psw+'"}', 
				contentType: "application/json",
			});
		},
		
		
        pruebaGet(txt){
            return $.ajax({
                url:  equipoBackEnd+version+"/user/hid/"+txt,
                type: "GET",                
                contentType: "application/json",
            });
        }
		
	};
}());