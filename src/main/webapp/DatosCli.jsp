<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/estilos.css">
    <title>Datos Usuarios</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div id="container">
	<!-- variables globales -->
	<%!String cedula_cliente="", direccion_cliente="", email_cliente="", nombre_cliente="", telefono_cliente=""; %>
	
	<%
	if(request.getParameter("cedula_cliente")!=null)
	{
	
		cedula_cliente=request.getParameter("cedula_cliente"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
		telefono_cliente=request.getParameter("telefono_cliente");
		nombre_cliente=request.getParameter("nombre_cliente");
		email_cliente=request.getParameter("email_cliente");
		direccion_cliente=request.getParameter("direccion_cliente");
		
	}
	
	if(request.getParameter("men")!=null)
	{
		String mensaje= request.getParameter("men");
		out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
		cedula_cliente=""; telefono_cliente=""; nombre_cliente=""; email_cliente=""; direccion_cliente="";
	} 
	%>
	
		<header class="principal">
	        <div>
	            <h1>Formulario Clientes</h1>
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
	    	<form class="formulario" action="Cliente" method="post"> <!-- action donde se dirige lo que se solicita al Usuario.java -->
		    	<tr>
		    		<td><div><label for="cedula_cliente">Cédula</label></td>
		    		<td><input type="text" autofocus name="cedula_cliente" value ="<%=cedula_cliente%>"></div></td>	    		
		    		<td><div><label for="telefono_cliente">Teléfono</label></td>
		        	<td><input type="text" name="telefono_cliente" value ="<%=telefono_cliente%>"></div></td>    		
		    	</tr>	    	
		    	<tr>
		    		<td><div><label for="nombre_cliente">Nombre Completo</label></td>
		    		<td><input type="text" autofocus name="nombre_cliente" value ="<%=nombre_cliente%>"></div></td>
		    		<td><div><label for="email_cliente">Correo Electrónico </label></td>
		        	<td><input type="email_cliente" autofocus name="email_cliente" value ="<%=email_cliente%>"></div></td>  <!-- oculata los datos de la contraseña -->		
		    	</tr>
		    	<tr>
		    		<td><div><label for="direccion_cliente">Dirección</label></td>
		    		<td><input id="name" type="text" autofocus name="direccion_cliente" value ="<%=direccion_cliente%>"></div></td>
		    		
		    	</tr>
		    	<tr>
		    	
		    		<!-- <td><input type= "submit" name= "consultar" value="Consultar"></td> -->
					<td><input type= "submit" name= "crear" value="Crear"></td>
					<td><input type= "submit" name= "actualizar" value="Actualizar"></td>
					<td><input type= "submit" name= "borrar" value="Borrar"></td>
		    	</tr>
		
		    </form> 
				<!-- formulario 2  consultar-->
		    		<form action="Cliente" method="post">
					<fieldset>
						<legend>Consultar Cédula</legend>
						<div><label>Cedula: </label><input type="text" name="cedula_cliente">
						<input type= "submit" name= "consultar" value="Consultar"></div>
					</fieldset>
				</form>
	  
	    </table>
</div>
</body>
</html>