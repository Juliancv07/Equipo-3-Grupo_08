<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/estilos.css">
</head>
<body>
<header class="Principal">
<div><h1 class= "Titulo">Bienvenidos a la Tienda Genérica</h1></div>

    <table border="0">
    <form action="Login" method="post">
        <tr>
        	<td><div><label for="">usuario</label></td>
        	<td><input type="text" name="usuario"></div></td>
    	</tr>
    	<tr>
       		<td><div><label for="">contraseña</label></td></td>
        	<td><input type="password" name="contraseña"></div></td>

    	</tr>
     	<tr>
     		<div>
        		<td><div><input type= "submit" name="Ingresar" value="Aceptar"></div></td>
        		<td><a href="Index.jsp"><input type="button" name= "cancela" value="Cancelar"></a></td>
        	</div>
    	</tr>
    </form>
    </table>

</header>
</body>
</html>

