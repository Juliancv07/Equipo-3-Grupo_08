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

  	    <!-- formulario 2  consultar-->
				<form action="Usuario" method="post">
				
					<fieldset style="border:0px groove #ccc; background-color: #FFFFFF80;"><!-- estilo al borde y fondo del cuadro  -->
						
						<legend style="font-weight:bold; color:black;">Consultar Cédula</legend><!-- estilo para la letra  -->
						<tr>	
							<td><label>Cedula: </label><input type="text" name="cedula">
								<input type= "submit" name= "consultar" value="Consultar" id="boton"></td>
							<td><label>Cliente: </label><input type="text" name="cliente"></td>
							<td><label>Consec: </label><input type="text" name="consec"></td>
						</tr>
					</fieldset>
				
				</form>
			
    
  <fieldset style="border:3px groove #ccc; background-color: #FFFFFF80;;">  
	
	<table border="0">
			<legend style="font-weight:bold; color:black;">Formulario</legend>	
	            <form action="" class="formulario">
	                <tr>
	                    <td>
	                        <div>
	                            <td><label for="">Cédula</label></td>
	                            <td><input type="text"></td>
	                            <td><label for="">Usuario</label></td>  
	                            <td><input type="text"></td>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <div>
	                            <td><label for="">Nombre Completo</label></td>
	                            <td><input type="text"></td>
	                            <td><label for="">Contraseña</label></td>
	                            <td><input type="password"></td>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <div>
	                            <td><label for="">Correo Electrónico</label></td>
	                            <td><input type="email"></td>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                        <div class="botones">
	                            <td><input type="submit" name="Consultar" value="Consultar" class="Boton"></td>
	                            <td><input type="submit" name="Crear" value="Crear" class="Boton"></td>
	                            <td><input type="submit" name="Actualizar" value="Actualizar" class="Boton"></td>
	                            <td><input type="submit" name="Borrar" value="Borrar" class="Boton"></td>
	                        </div>
	                    </td>
	                </tr>
	            </form>
	</table>
</fieldset>
</div>
</body>
</html>