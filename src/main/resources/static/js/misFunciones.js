function traerDatosCategoria(){
    $.ajax({
        url:  "http://150.136.138.63:8080/api/Category/all",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            pintarDatos(respuesta);
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");

        }
    })
}

function pintarDatos(datos){
    let html="";
    html += "<tr>";
    Object.keys(datos[0]).forEach(elemento =>{
        html+="<th>"+elemento+"</th>";
    });
    html += "</tr>";
    $("#tabla").empty();
    $("#tabla").append(html);
}

