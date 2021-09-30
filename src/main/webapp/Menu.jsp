<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
<script type="text/javascript" language="javascript" src="lytebox_v5.5/lytebox.js"></script>
<link rel="stylesheet" type="text/css" href="lytebox_v5.5/lytebox.css">
<link rel="stylesheet" href="CSS/estilos.css">
<link rel="stylesheet" type="text/css" href="airstream_regular_macroman/stylesheet.css">

</head>
<body>
	<div id="container">
		<form action="Datosprov" class="" method="post"></form><!-- cambio por prueba -->
			<header class="principal">
		        <div>
		            <h1>Menú Principal</h1>
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
		        <section>        
        	
	        		is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard 
	        		dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a 
	        		type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, 
	        		remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing 
	        		Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of 
	        		Lorem Ipsum
       	
       			</section>
       		
       			<aside>
       				<h3>Galeria</h3>
			       	<!-- la imagen 1 queda fija, no se oculta, las demas tiene el atributo hidden que las oculta y al dar click sobre la primera, se habilita la galeria" -->
					<a href="Galeria/alimentos2.jpg"class="lytebox" data-lyte-options="group:marvel" data-title="alimentos"><img src="Galeria/alime1.jpg" width="640" height="310"></a><!--deben estar en el mismo group para poder avanzar y retroceder-->
			        <a href="Galeria/alimentos4.jpg"class="lytebox" data-lyte-options="group:marvel" data-title="alimentos" ><img src="Galeria/alime3.jpg" width="500" height="200" hidden="true"></a>
			        <a href="Galeria/alimentos6.jpg"class="lytebox" data-lyte-options="group:marvel" data-title="alimentos" ><img src="Galeria/alime5.jpg" width="500" height="200" hidden="true"></a>
			        <a href="Galeria/alimentos8.jpg"class="lytebox" data-lyte-options="group:marvel" data-title="alimentos" ><img src="Galeria/alime7.jpg" width="500" height="200" hidden="true"></a>
       				
       			</aside>

		    </div>
		    <footer>
       		 	puede ir la direccion, correo electronico y numeros de contacto
       		 </footer>
	</div>
 
</body>
</html> 