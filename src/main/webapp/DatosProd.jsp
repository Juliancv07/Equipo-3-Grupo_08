<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/estilos.css">
    <title>Datos Productos</title>
</head>
<body>
<!-- variables globales -->
<%!String codigo_producto="", ivacompra="", nitproveedor="", nombre_producto="", precio_compra="",precio_venta=""; %>

<%
if(request.getParameter("nitproveedor")!=null)
{

	codigo_producto=request.getParameter("codigo_producto"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
	ivacompra=request.getParameter("ivacompra");
	nitproveedor=request.getParameter("nitproveedor");
	nombre_producto=request.getParameter("nombre_producto");
	precio_compra=request.getParameter("precio_compra");
	precio_venta= request.getParameter("precio_venta");
	
}

if(request.getParameter("men")!=null)
{
	String mensaje= request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
	String codigo_producto="", ivacompra="", nitproveedor="", nombre_producto="", precio_compra="",precio_venta="";
} 
%>

	<header class="principal">
        <div>
            <h1>Formulario Productos</h1>
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
    	<form class="formulario" action="Producto" method="post"> <!-- action donde se dirige lo que se solicita al Usuario.java -->
	    	<tr>
	    		<td><div></div><label for="codigo_producto">Codigo Producto</label></td>
	    		<td><input type="text" autofocus name="codigo_producto" value ="<%=codigo_producto%>"></div></td>	    		
	    		<td><div><label for="ivacompra">IVA</label></td>
	        	<td><input type="text" name="ivacompra" value ="<%=ivacompra%>"></div></td>    		
	    	</tr>	    	
	    	<tr>
	    		<td><div><label for="nitproveedor">NIT</label></td>
	    		<td><input type="text" autofocus name="nitproveedor" value ="<%=nitproveedor%>"></div></td>
	    		<td><div><label for="nombre_producto">Nombre Producto</label></td>
	        	<td><input type="text" autofocus name="nombre_producto" value ="<%=nombre_producto%>"></div></td>  <!-- oculta los datos de la contraseña -->		
	    	</tr>
	    	<tr>
	    		<td><div><label for="precio_compra">Precio compra</label></td>
	    		<td><input id="name" type="text" autofocus name="precio_compra" value ="<%=precio_compra%>"></div></td>
	    		
	    	</tr>
	    	<tr>
	    		<td><div><label for="precio_venta">Precio venta</label></td>
	    		<td><input id="name" type="text" autofocus name="precio_venta" value ="<%=precio_venta%>"></div></td>
	    		
	    	</tr>	    	

	    	<tr>
	    		<!-- <td><input type= "submit" name= "consultar" value="Consultar"></td> -->
				<td><input type= "submit" name= "crear" value="Crear"></td>
				<td><input type= "submit" name= "actualizar" value="Actualizar"></td>
				<!-- <td><input type= "submit" name= "borrar" value="Borrar"></td> -->
	    	</tr>
	
	    </form> 
	    
</form>
<hr>
<form action="Producto" method="post">
<fieldset>
<legend>Consultar producto</legend>
<div><label>nombre_producto:</label><input type="text" name="nombre_producto">
<input type="submit" name="consultar" Value="Consultar"></div>
</fieldset>
</form>

<form action="Producto" method="post" enctype="multipart/form-data"> <!-- indica multipart que se va a trabajar archivos -->
<div><label>Archivo:</label><input type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div><!--name archivo es llamado por el request// accept= tipo de archivos admitidos -->
<input type="submit" name="cargar" value="Cargar archivo">  <!-- el controlador recibe el archivo  -->
</form>
	    
<!-- Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git
Comentario prueba Git

 -->
</body>
</html>