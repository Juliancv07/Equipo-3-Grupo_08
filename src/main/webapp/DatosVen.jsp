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
<!-- variables globales -->
<%!String cedula_cliente="", nombre_cliente="",	codigo_producto1="", nombre_producto1="", codigo_producto2="", nombre_producto2="",
codigo_producto3="", nombre_producto3="";%>

<!-- %!int 	cantidad_producto1, cantidad_producto2, cantidad_producto3;%>-->

		
	<%
	if(request.getParameter("cedula_cliente")!=null)
	{
	
		cedula_cliente=request.getParameter("cedula_cliente"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
		nombre_cliente=request.getParameter("nombre_cliente");

	}
	
	if(request.getParameter("men")!=null)
	{
		String mensaje= request.getParameter("men");
		out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
		cedula_cliente=""; nombre_cliente=""; 
	} 
	%>
	
<!-- variables globales para buscar producto -->
	<%
	if(request.getParameter("codigo_producto1")!=null)
	{
	
		codigo_producto1=request.getParameter("codigo_producto1"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
		nombre_producto1=request.getParameter("nombre_producto1");

	}
	
	if(request.getParameter("men")!=null)
	{
		String mensaje= request.getParameter("men");
		out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
		codigo_producto1=""; nombre_producto1="";
	} 

	%>
	
	<!-- consulta prod 2 -->
	<%
	if(request.getParameter("codigo_producto2")!=null)
	{
	
		codigo_producto2=request.getParameter("codigo_producto2"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
		nombre_producto2=request.getParameter("nombre_producto2");
	
	}
	
	if(request.getParameter("men")!=null)
	{
		String mensaje= request.getParameter("men");
		out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
		codigo_producto2=""; nombre_producto2="";
	} 

	%>
	
	<!-- consulta prod 3 -->
	<%
	if(request.getParameter("codigo_producto3")!=null)
	{
	
		codigo_producto3=request.getParameter("codigo_producto3"); //los nombres debe ser como estan en Usuario.java response.sendRedirect
		nombre_producto3=request.getParameter("nombre_producto3");
	}
	
	if(request.getParameter("men")!=null)
	{
		String mensaje= request.getParameter("men");
		out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
		codigo_producto3=""; nombre_producto3="";
	} 

	%>
		

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

    <!-- formulario  Consultar cliente cedula-->
	<form action="Ventas" method="post">
	
		<fieldset style="border:0px groove #ccc; background-color: #FFFFFF80;"><!-- estilo al borde y fondo del cuadro  -->
			
			<legend style="font-weight:bold; color:black;">Consultar Cédula</legend><!-- estilo para la letra  -->
			<tr>	
				<td><label for="cedula_cliente">Cédula</label></td>
   				<td><input type="text"  name="cedula_cliente" value ="<%=cedula_cliente%>"></td>	
    			<td><input type= "submit" name= "consultar" value="Consultar" id="boton"></td>
   				<td><input type="text"  name="nombre_cliente" value ="<%=nombre_cliente%>"></td>
    			<td><label>Consec: </label><input type="text" name="consec"></td>

			</tr>
		</fieldset>
				
		<fieldset style="border:0px groove #ccc; background-color: #FFFFFF80;">  
			<legend style="font-weight:bold; color:black;">Formulario Ventas</legend>
		        <table>
		
		                <thead>
				                  	<tr>
				                        <th>Cod.Producto</th>
				                        <th></th>
				                        <th>Nombre Producto</th>
				                        <th>Cant.</th>
				                        <th>Vlr. Total</th>
				                    </tr>
		                	
		                	<tr>
				    				<td><input type="text"  name="codigo_producto1" value ="<%=codigo_producto1%>"></td>	
					    			<td><input type= "submit" name= "consultar1" value="Consultar" id="boton"></td>
					    			<td><input type="text"  name="nombre_producto1" value ="<%=nombre_producto1%>"></td>
					    			<td><input type="number" name= "cantidad1"></td>
		                       		<td><input type="text"></td>
							</tr>  
							
							
							<tr>
			                        <td><input type="text"  name="codigo_producto2" value ="<%=codigo_producto2%>"></td>	
						    		<td><input type= "submit" name= "consultar2" value="Consultar" id="boton"></td>
						    		<td><input type="text"  name="nombre_producto2" value ="<%=nombre_producto2%>"></td>
			                        <td><input type="number" name= "cantidad2"></td>
			                        <td><input type="text"></td>
		                    </tr>  
		                    
		                    <tr>
			                        <td><input type="text"  name="codigo_producto3" value ="<%=codigo_producto3%>"></td>	
						    		<td><input type= "submit" name= "consultar3" value="Consultar" id="boton"></td>
						    		<td><input type="text"  name="nombre_producto3" value ="<%=nombre_producto3%>"></td>
			                        <td><input type="number" name= "cantidad3"></td>
			                        <td><input type="text"></td>
		                    </tr>
		          
		                  
		                </thead>
		                
		                <tbody>
		
		                    <tr>
		                        <td colspan="3" rowspan="3"><input type="submit" name="Confirmar" value="Confirmar" id="boton"></td>
		                        <td>Total Venta</td>
		                        <td><input type="text"></td>
		                    </tr>
		                    <tr>
		                        
		                        <td>Total IVA</td>
		                        <td><input type="text"></td>
		                    </tr>
		                    <tr>
		                        
		                        <td>Total Con IVA</td>
		                        <td><input type="text"></td>
		                    </tr>
		                </tbody>
		            
		        </table>
		
		</fieldset>
     </form>                 
                    
</div>
</body>
</html>