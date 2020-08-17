<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require 'Lista.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar peticion GET
    $lista = lista::getAll();
    
    echo json_encode($lista);
    
   /* if ($supermercados) {

        $datos["estado"] = 1;
        $datos["supermercados"] = "$supermercados";

       print json_encode($datos);
        
    } else {
            print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
        
        
    }*/
}