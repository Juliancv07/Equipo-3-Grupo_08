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
		    				<td><input type="text" autofocus name="cedula_cliente" value ="<%=cedula_cliente%>"></td>	
			    			<td><input type= "submit" name= "consultar" value="Consultar" id="boton"></td>
		    				<td><input type="text" autofocus name="nombre_cliente" value ="<%=nombre_cliente%>"></td>
			    			<td><label>Consec: </label><input type="text" name="consec"></td>
								
							<!--  <td><label>Cliente: </label><input type="text" name="cliente"></td>
							-->
						</tr>
					</fieldset>
				
				</form>
				 <fieldset style="border:0px groove #ccc; background-color: #FFFFFF80;">  
	<legend style="font-weight:bold; color:black;">Formulario Ventas</legend>
        <table>
            <form action="">
                <thead>
                    <tr>
                        <th>Cod.Producto</th>
                        <th></th>
                        <th>Nombre Producto</th>
                        <th>Cant.</th>
                        <th>Vlr. Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><!-- se compara codigo de consultar de usuarios y se agregan la lineas que faltaban-->
                        <td><input type="text" name="codigo_producto"></td>
                        <td><input type="submit" name="Consultar1" value="Consultar" id="boton" ></td> <!-- cambiar el name consultar 1, 2, 3 -->
                        <!-- traer el codigo de consultar de usuarios -->
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                   
                    <tr>
  						<td><input type="text" name="codigo_producto"></td>
                        <td><input type="submit" name="Consultar2" value="Consultar" id="boton" ></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
						<td><input type="text" name="codigo_producto"></td>
                        <td><input type="submit" name="Consultar3" value="Consultar" id="boton" ></td>
                        <td><input type="text" value></td>
                        <td><input type="text"></td>
                        <td><input type="text"></td>
                    </tr>
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
            </form>
        </table>

</fieldset>
                   
                    
</div>
</body>
</html>