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
	<% 
	Conexion cnn=new Conexion();
	cnn.Conecta();
	%>
<h1>Tienda Genérica</h1>
<div><h2><a href="Login.jsp">Ingreso Administrador</a></h2></div>
<form action="prueba"></form>
</body>
</html>

