package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import modelo.ClienteDTO;

public class ClienteDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;	
	
	//metodo crear
	
	public boolean Crear_Cliente(ClienteDTO cli)
	{
			
			boolean result=false;			// se crea la variable para verificar si si  se inserto en la VISTA
			
			try
			{
				
				String sql="insert into clientes values(?,?,?,?,?)";		//insertar datos en la tabla usuarios en este caso son 5 parametros (se representa ?)
				ps=con.prepareStatement(sql);							//pase a la conexion esa consulta sql, se pasa el resto de parametros (?), para que la consulta los resconozca
				ps.setString(1, cli.getCedula_cliente());
				ps.setString(2, cli.getTelefono_cliente());
				ps.setString(3, cli.getNombre_cliente());
				ps.setString(4, cli.getEmail_cliente());
				ps.setString(5, cli.getDireccion_cliente());
				
				
				
				
				
				
				result=ps.executeUpdate()>0;							// se utiliza executeUpdate por que se modifica la tabla (inserto actualizo elimino)
																		// executeQuery se utiliza para consultar
			} 
			catch (SQLException ex)
			{
				JOptionPane.showMessageDialog(null, "No se registró cliente"+ ex);
			}
			return result;
		}
	
	//metodo consultar o buscar usuario
	
public ClienteDTO Buscar_Cedula(String cedula_cliente)
{
		
		ClienteDTO cli=null;
		try 
		{
			String sql="select* from clientes where cedula_cliente=?"; //debe ir el nombre del campo de la BD
			ps=con.prepareStatement(sql);
			ps.setString(1, cedula_cliente);
			res=ps.executeQuery();
			while(res.next()) 
			{
				cli=new ClienteDTO(res.getString(1),res.getString(5),res.getString(4),res.getString(3),res.getString(2));
				
			}
			
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,"Error al consultar Cedula del Cliente"+ ex);
		}
		return cli;
	}
//metodo Actualizar
	public boolean Actualizar_Cliente(ClienteDTO cli) 
	{
	    boolean resul=false;
	    try
	    {
	    String sql="update clientes set telefono_cliente=?, nombre_cliente=?, email_cliente=?, direccion_cliente=?  where cedula_cliente=?";
	    ps = con.prepareStatement(sql);
	    ps.setString(1, cli.getDireccion_cliente());
	    ps.setString(2, cli.getEmail_cliente());
	    ps.setString(3, cli.getNombre_cliente());
	    ps.setString(4, cli.getTelefono_cliente());   	    
	    ps.setString(5, cli.getCedula_cliente());
	    resul=ps.executeUpdate()>0;    
	    }
	    catch(SQLException ex)
	    {
	        JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
	    }
	    return resul;
	}
//metodo eliminar
	public boolean Eliminar_Cliente(String cedula_cliente)
	{
		boolean resul=false;
		try
		{
			String sql="delete from clientes where cedula_cliente=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, cedula_cliente);
			resul=ps.executeUpdate()>0;
				
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(null,"Error al Eliminiar Cliente"+ ex);
		}
		return resul;
	}
}
