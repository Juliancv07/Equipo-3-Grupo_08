
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/estilos.css">
    <title>Datos Proveedores</title>
</head>
<body>
<!-- variables globales -->
<%!String nitproveedor="", ciudad_proveedor="", direccion_proveedor="", nombre_proveedor="", telefono_proveedor=""; %>

<%
if(request.getParameter("nitproveedor")!=null)
{

	nitproveedor=request.getParameter("nitproveedor"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
	ciudad_proveedor=request.getParameter("ciudad_proveedor");
	direccion_proveedor=request.getParameter("direccion_proveedor");
	nombre_proveedor=request.getParameter("nombre_proveedor");
	telefono_proveedor=request.getParameter("telefono_proveedor");
	
}

if(request.getParameter("men")!=null)
{
	String mensaje= request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
	nitproveedor=""; ciudad_proveedor=""; direccion_proveedor=""; nombre_proveedor=""; telefono_proveedor="";
} 
%>

	<header class="principal">
        <div>
            <h1>Formulario Proveedores</h1>
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

     <table border="0">
     
     	<!-- formulario 1  crear-->
    	<form class="formulario" action="Proveedor" method="post"> <!-- action donde se dirige lo que se solicita al Usuario.java -->
	    	<tr>
	    		<td><div><label for="nitproveedor">NIT</label></td>
	    		<td><input type="text" autofocus name="nitproveedor" value ="<%=nitproveedor%>"></div></td>	    		
	    		<td><div><label for="ciudad_proveedor">Ciudad</label></td>
	        	<td><input type="text" name="ciudad_proveedor" value ="<%=ciudad_proveedor%>"></div></td>    		
	    	</tr>	    	
	    	<tr>
	    		<td><div><label for="direccion_proveedor">Direccion</label></td>
	    		<td><input type="text" autofocus name="direccion_proveedor" value ="<%=direccion_proveedor%>"></div></td>
	    		<td><div><label for="nombre_proveedor">Nombre</label></td>
	        	<td><input type="text" autofocus name="nombre_proveedor" value ="<%=nombre_proveedor%>"></div></td>  <!-- oculata los datos de la contraseña -->		
	    	</tr>
	    	<tr>
	    		<td><div><label for="telefono_proveedor">Telefono</label></td>
	    		<td><input id="name" type="text" autofocus name="telefono_proveedor" value ="<%=telefono_proveedor%>"></div></td>
	    		
	    	</tr>
	    	<tr>
	    		<!-- <td><input type= "submit" name= "consultar" value="Consultar"></td> -->
				<td><input type= "submit" name= "crear" value="Crear"></td>
				<td><input type= "submit" name= "actualizar" value="Actualizar"></td>
				<td><input type= "submit" name= "borrar" value="Borrar"></td>
	    	</tr>
	
	    </form> 
	    
	    <!-- formulario 2  consultar-->
			<form action="Proveedor" method="post">
				<fieldset>
					<legend>Consultar NIT</legend>
					<div><label>NIT: </label><input type="text" name="nitproveedor">
					<input type= "submit" name= "consultar" value="Consultar"></div>
				</fieldset>
			</form>
			
  
    </table>

</body>
</html>