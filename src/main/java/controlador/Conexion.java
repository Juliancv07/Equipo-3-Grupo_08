package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

//conexion a la BD de worckbench

public class Conexion {
	
	private String bd="tienda_generica";
	private String url="jdbc:mysql://localhost:3306/"+bd;  
	private String user="root";       //usuario con privilegios
	private String pass="";     //cuando se cree en la nube se pone contraseña, ahora esta vacia
	Connection con=null;
	
	public Connection Conecta() {   //Creacion clase conexion 
			
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,user,pass);
			JOptionPane.showMessageDialog(null, "Conexion BD ok");
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error al conectar BD" + e);
			}
			return con;
		}
}
