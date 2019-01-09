var configuracion = (function () {
    var equipoBackEnd = "";
    var version = "";
    return {
        getEquipoBackEnd(){
            return equipoBackEnd;
        },
        getVersion(){
            return version;
        },
        init(){
             if ("undefined" === sessionStorage.getItem("token") || null === sessionStorage.getItem("token")) {
                //no inicio sesion
                alert("Para esta función, debe iniciar sesión primero.");
                window.location.href = "index.html";
            } 
        },
        cerrarSesion(){
            sessionStorage.clear();
            window.location.href = "index.html";
        }
    };
}());