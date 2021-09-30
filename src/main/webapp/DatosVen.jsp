<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/estilos.css">
    <title>Datos Ventas</title>
</head>
<body>
<div id="container">
	<header class="principal">
        <div>
            <h1>Formulario Ventas</h1>
        </div>
    </header>
     <div class="menu">
        <nav>
        	<ul>
	        	<li><a href="DatosUsu.jsp" style="text-decoration:none">Usuarios</a></li><!-- el signo # representa un link a cualquier parte -->
	            <li><a href="DatosCli.jsp" style="text-decoration:none">Clientes</a></li>
	            <li><a href="DatosProv.jsp" style="text-decoration:none">Proveedores</a></li>
	            <li><a href="DatosProd.jsp" style="text-decoration:none">Productos</a></li>
	            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
	            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        	</ul>
        </nav>
    </div>

    <div class="formulario">
    	<label for="Cedula">Cédula</label><input type="text" autofocus name="Cedula"  required>
    	<label for="Cliente">Cliente</label><input type="text" autofocus name="Cliente"  required>
    	<label for="Consecutivo">Consecutivo</label><input type="text" autofocus name="Consecutivo"  required>
    	<label for="Cod. Producto">Cod. Producto</label><input type="text" autofocus name="Cod. Producto"  required>
    	<label for="Nombre Producto">Nombre Producto</label><input type="text" autofocus name="Nombre Producto"  required>
    	<label for="Cantidad">Cantidad</label><input type="text" autofocus name="Cantidad"  required>
    	<label for="Vlr Total">Vlr Total</label><input type="int" autofocus name="Vlr Total"  required>
    	
    	<p><label for="Total Venta">Total Venta</label><input type="text" autofocus name="Total Venta" required></p>
    	<p><label for="Total IVA">Total IVA</label><input type="text" autofocus name="Total IVA" required></p>
    	<p><label for="Total con IVA">Total con IVA</label><input type="text" autofocus name="Total con IVA" required></p>
    	
 	</div>
</div>
</body>
</html>