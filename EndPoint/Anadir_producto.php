<?PHP
$hostname_localhost="localhost";
$database_localhost="paulojed_lcompras";
$username_localhost="paulojed_lcomprasadmin";
$password_localhost="bdLCppl1APLA21As";

$json=array();

	if(isset($_GET["Producto"]) && isset($_GET["Supermercado"]) && isset($_GET["Estadocompra"])){
		$producto=$_GET['Producto'];
		$supermercado=$_GET['Supermercado'];
		$estadocompra=$_GET['Estadocompra'];
		
		$conexion=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);
		
		$insert="INSERT INTO lista(Producto, Supermercado, Estadocompra) VALUES ('{$producto}','{$supermercado}','{$estadocompra}')";
		$resultado_insert=mysqli_query($conexion,$insert);
		
		if($resultado_insert){
			$consulta="SELECT * FROM lista WHERE Producto = '{$producto}'";
			$resultado=mysqli_query($conexion,$consulta);
			
			if($registro=mysqli_fetch_array($resultado)){
				$json['lista']=$registro;
			}
		mysqli_close($conexion);
		echo json_encode($json);
		}
		else{
			$resulta["producto"]=0;
			$resulta["supermercado"]='No Registra';
			$resulta["estadocompra"]='No Registra';
			$json['listaNoregistro'][]=$resulta;
			echo json_encode($json);
		}
		
	}
	else{
			$resulta["producto"]=0;
			$resulta["supermercado"]='WS No retorna';
			$resulta["estadocompra"]='WS No retorna';
			$json['listaProblemaWS'][]=$resulta;
			echo json_encode($json);
		}

?>

