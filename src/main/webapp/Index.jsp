<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="CSS/estilos.css">

</head>
<body>
	<div id="container1">
			<!-- % 
			Conexion cnn=new Conexion();
			cnn.Conecta();
			% -->
			<table>
				<form>
					<tr><h1>Tienda Genérica</h1></tr>
					<tr><h2><a href="Login.jsp">Ingreso Administrador</a></h2></tr>
					
					<!-- linea para cambiar una imagen por otra cuando pase el puntero o mouse sobre ella -->
					<a href="Login.jsp"><img src="Imagenes/login2.png" width="150" height="150" onmouseover="this.src='Imagenes/login1.png'" onmouseout="this.src='Imagenes/login2.png'"/>

				</form>
			</table>
	</div>		
</body>
</html>

