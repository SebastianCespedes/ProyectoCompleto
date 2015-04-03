/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function llenarmodal(idOferta, producto, categoria, precio, fechaInicio, presentacion, promocion){
    document.getElementById("mdproducto").innerHTML=producto;
    document.getElementById("idOfertaSeleccionada").value=idOferta;
    document.getElementById("mdcategoria").value=categoria;
    document.getElementById("mdprecio").value=precio;
    document.getElementById("mdfechainicio").value=fechaInicio;
    document.getElementById("mdpresentacion").value=presentacion;
    document.getElementById("novedad").value=promocion;
    document.getElementById("mdfechafin").value="";
    
    
}


