package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import modelo.UsuarioDTO;

public class UsuarioDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;	
	
	//metodo crear
	
	public boolean crear_usuario(UsuarioDTO usu) {
			
			boolean result=false;			// se crea la variable para verificar si si  se inserto en la VISTA
			
			try {
				
				String sql="insert into usuarios values(?,?,?,?,?)";		//insertar datos en la tabla usuarios en este caso son 5 parametros (se representa ?)
				ps=con.prepareStatement(sql);							//pase a la conexion esa consulta sql, se pasa el resto de parametros (?), para que la consulta los resconozca
				ps.setString(1, usu.getCedula_usuario());
				ps.setString(2, usu.getEmail_usuario());
				ps.setString(3, usu.getNombre_usuario());
				ps.setString(4, usu.getPassword());
				ps.setString(5, usu.getUsuario());
				
				result=ps.executeUpdate()>0;							// se utiliza executeUpdate por que se modifica la tabla (inserto actualizo elimino)
																		// executeQuery se utiliza para consultar
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "No se registró usuario"+ ex);
			}
			return result;
		}
	
	//metodo consultar o buscar usuario
	
public UsuarioDTO Buscar_Cedula(String cedula) {
		
		UsuarioDTO usu=null;
		try {
			String sql="select* from usuarios where cedula_usuario=?"; //debe ir el nombre del campo de la BD
			ps=con.prepareStatement(sql);
			ps.setString(1, cedula);
			res=ps.executeQuery();
			while(res.next()) {
				usu=new UsuarioDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
				
			}
			
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"Error al consultar Cedula"+ ex);
		}
		return usu;
	}
//metodo Actualizar
	public boolean Actualizar_Usuario(UsuarioDTO usu) {
	    boolean resul=false;
	    try {
	    String sql="update usuarios set email_usuarios=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
	    ps = con.prepareStatement(sql);
	    ps.setString(1, usu.getEmail_usuario());
	    ps.setString(2, usu.getNombre_usuario());
	    ps.setString(3, usu.getPassword());
	    ps.setString(4, usu.getUsuario());
	    ps.setString(5, usu.getCedula_usuario());
	    resul=ps.executeUpdate()>0;    
	    }catch(SQLException ex) {
	        JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
	    }
	    return resul;
	}
//metodo eliminar
	public boolean Eliminar_Usuario(String cedula) {
		boolean resul=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, cedula);
			resul=ps.executeUpdate()>0;
				
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null,"Error al Eliminiar Usuario"+ ex);
		}
		return resul;
	}
}
