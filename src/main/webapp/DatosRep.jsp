<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/estilos.css">
    <title>Datos Reportes</title>
</head>
<body>
<div id="container">
	<header class="principal">
        <div>
            <h1>Formulario Reportes</h1>
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
		<table borde="0">
			
			<form class="formulario" action="Usuario" method="post">
				<tr>
					<td>
						<label for="Listado Usuarios">Listado por Usuarios </label><input type="text" autofocus name="Listado Usuarios" >
						<input type= "submit" name= "Listado por Usuarios" value="Listado por Usuarios" id="boton">
					</td>
				</tr>
				<tr>
					<td>
						<label for="Listado Clientes">Listado por Clientes </label><input type="text" autofocus name="Listado Clientes" >
						<input type= "submit" name= "Listado por Clientes" value="Listado por Clientes" id="boton">
					</td>
				</tr>
				<tr>
					<td>
						<label for="Ventas por Cliente">Ventas por Cliente </label><input type="text" autofocus name="Ventas por Cliente" >
						<input type= "submit" name= "Ventas por Cliente" value="Ventas por Cliente" id="boton">
					</td>
				</tr>	
			</form>
		
		</table>
</div>
</body>
</html>