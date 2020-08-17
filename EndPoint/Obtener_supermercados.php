<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require 'Supermercado.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar peticion GET
    $supermercados = supermercado::getAll();
    
    echo json_encode($supermercados);
    
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
