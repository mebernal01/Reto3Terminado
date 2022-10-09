
function traerDatosBarcos(){
    alert("Bienvenidos a la lista de barcos")
    $.ajax({
        url:  'https://localhost:8080/api/Category/all',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "name", "boat");
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");

        }
    })
}

function traerDatosClientes(){
    alert("Bienvenidos a la lista de Clientes")
    $.ajax({
        url:  'https://localhost:8080/api/Category/all',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "name", "client");
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");

        }
    })
}

function traerDatosMessage(){
    alert("Bienvenidos a la lista de Message")
    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "messagetext", "message");
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");

        }
    })
}

function guardarBarco(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'brand':$("#brand").val(),
        'model': $('#model').val(),
        'name': $('#name').val(),
        'category_id': $("#category_id").val()
    };

    $.ajax({
        url:  'https://localhost:8080/api/Category/all',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con éxito!");
            traerDatosBarcos();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });
}

function guardarCliente(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'name':$("#name").val(),
        'email': $('#email').val(),
        'age': $("#age").val()
    };

    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con éxito!");
            traerDatosClientes();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });
}

function guardarMessage(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'messagetext':$("#messagetext").val(),
    };

    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con éxito!");
            traerDatosMessage();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });
}

function guardarIdyTipo(id, tipo){
    sessionStorage.setItem('id', id);
    sessionStorage.setItem('tipo', tipo);
    location.href='detalles.html';
}

function mostrarDetalle(){
    alert("Bienvenidos a la lista de Detalle")
    let id = sessionStorage.getItem('id');
    let tipo = sessionStorage.getItem('tipo');

    $.ajax({
        url:  'https://localhost:8080/api/Category/all'+tipo+'/'+tipo+'/'+id,
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosDetalle(respuesta.items);
            pintarEntradaDetalle(respuesta.items);
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");
        }
    });
}

function pintarDatosGeneral(datos, titulo, tipoTabla){
    let htmlParaInsertar ="";
    htmlParaInsertar+="<tr>";
    htmlParaInsertar+="<th>Titulo</th>"
    htmlParaInsertar+="</tr>";

    for(let i=0; i<datos.length; i++){
        htmlParaInsertar+="<tr>";

        htmlParaInsertar+="<td><a href='#' onclick='guardarIdyTipo("+datos[i].id+", \""+tipoTabla+"\");'>"+datos[i][titulo]+"</a></td>";

        htmlParaInsertar+="</tr>";

        $("#resultado").empty();
        $("#resultado").append(htmlParaInsertar);

    }
}


function pintarDatosDetalle(datos){
    let htmlParaInsertar ="";
    htmlParaInsertar+="<tr>";
    Object.keys(datos[0]).forEach(elemento => htmlParaInsertar+="<th>"+elemento+"</th>");
    htmlParaInsertar+="</tr>";

    for(let i=0; i<datos.length; i++){
        htmlParaInsertar+="<tr>";


        Object.values(datos[i]).forEach(elemento => htmlParaInsertar+="<td><input value='"+elemento+"'></td>");


        htmlParaInsertar+="</tr>";


    }

    $("#resultado").empty();
    $("#resultado").append(htmlParaInsertar);

}

function pintarEntradaDetalle(datos){
    let htmlParaInsertar ="";
    Object.keys(datos[0]).forEach(elemento => htmlParaInsertar+="<input id='"+elemento+"' placeholder='"+elemento+"'><br><br>");
    $("#formulario").empty();
    $("#formulario").append(htmlParaInsertar);

}

function actualizarDetalles(){
    let id = sessionStorage.getItem('id');
    let tipo = sessionStorage.getItem('tipo');

    if(tipo=="boat"){
        actualizarBarco();
    }else if(tipo=="client"){
        actualizarCliente();
    }else if(tipo=="message"){
        actualizarMessage();
    }

}

function actualizarBarco(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'brand':$("#brand").val(),
        'model': $('#model').val(),
        'name': $('#name').val(),
        'category_id': $("#category_id").val()
    };

    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/boat/boat',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido actualizado con éxito!");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });
}


function actualizarCliente(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'name':$("#name").val(),
        'email': $('#email').val(),
        'age': $("#age").val()
    };

    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido actualizado con éxito!");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });
}

function actualizarMessage(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'messagetext':$("#messagetext").val(),
    };

    $.ajax({
        url:  'https://gbc877c5e8ec869-j29jjtmijhjlvfye.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido actualizado con éxito!");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de petición");
        }

    });

}

function borrarDetalle(){
    let id = sessionStorage.getItem('id');
    let tipo = sessionStorage.getItem('tipo');

    let datosPorMandar = {
        'id': id
    }

    $.ajax({
        url:  'https://localhost:8080/api/Category/all'+tipo+'/'+tipo,
        type: 'DELETE',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El elemento ha sido eliminado");
            location.href='index.html';
        },
        error: function(respuesta, xhr){
            alert("Error de petición!");
        }
    });
}

function valorPordefecto (){
    document.getElementById("id").value=""
}

