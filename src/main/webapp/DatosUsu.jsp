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
</head>
<body>
<!-- variables globales -->
<%!String cedula="", Email="", Password="", Usuario="", Nombresusuario=""; %>

<%
if(request.getParameter("cedula")!=null){

	cedula=request.getParameter("cedula"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
	Email=request.getParameter("email");
	Password=request.getParameter("password");
	Usuario=request.getParameter("usuario");
	Nombresusuario=request.getParameter("Nombreusuario");
	
}

if(request.getParameter("men")!=null){
	String mensaje= request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
	cedula=""; Email=""; Password=""; Usuario=""; Nombresusuario="";
	} 
%>

	<header class="principal">
        <div>
            <h1>Formulario Usuarios</h1>
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
    	<form class="formulario" action="Usuario" method="post"> <!-- action donde se dirige lo que se solicita al Usuario.java -->
	    	<tr>
	    		<td><div><label for="Cedula">Cédula</label></td>
	    		<td><input type="text" autofocus name="cedula_usuario" value ="<%=cedula%>"></div></td>	    		
	    		<td><div><label for="Usuario">Usuario</label></td>
	        	<td><input type="text" name="usuario" value ="<%=Usuario%>"></div></td>    		
	    	</tr>	    	
	    	<tr>
	    		<td><div><label for="Nombresusuario">Nombre Completo</label></td>
	    		<td><input type="text" autofocus name="nombre_usuario" value ="<%=Nombresusuario%>"></div></td>
	    		<td><div><label for="Password">Contraseña </label></td>
	        	<td><input type="Password" name="password" value ="<%=Password%>"></div></td>  <!-- oculata los datos de la contraseña -->		
	    	</tr>
	    	<tr>
	    		<td><div><label for="Email">Correo Electronico</label></td>
	    		<td><input id="name" type="text" autofocus name="email_usuarios" value ="<%=Email%>"></div></td>
	    		
	    	</tr>
	    	<tr>
	    		<td><input type= "submit" name= "consultar" value="Consultar"></td>
				<td><input type= "submit" name= "crear" value="Crear"></td>
				<td><input type= "submit" name= "actualizar" value="Actualizar"></td>
				<td><input type= "submit" name= "borrar" value="Borrar"></td>
	    	</tr>
	
	    </form> 
	    
	    <!-- formulario 2  consultar-->
			<form action="Usuario" method="post">
				<fieldset>
					<legend>Consultar Cédula</legend>
					<div><label>Cedula: </label><input type="text" name="cedula">
					<input type= "submit" name= "consultar" value="Consultar"></div>
				</fieldset>
			</form>
			
  
    </table>

</body>
</html>