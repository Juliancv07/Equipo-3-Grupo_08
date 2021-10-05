package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class VentasDAO 
{
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
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
	
/*buscar el producto*/
	public ProductoDTO Buscar_Producto(String codigo_producto)
	{
			
			ProductoDTO pro=null;
			try 
			{
				String sql="select* from productos where codigo_producto=?"; //debe ir el nombre del campo de la BD
				ps=con.prepareStatement(sql);
				ps.setString(1, codigo_producto);
				
				res=ps.executeQuery();
				while(res.next()) 
				{
					pro=new ProductoDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
												
				}
				
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,"Error al consultar el codigo del producto"+ ex);
			}
			return pro;
		}
	
	
	public boolean Inserta_venta(VentasDTO v) {//v=venta
		
		boolean resul=false;
		
		try {
			
			String sql="insert into ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, v.getCedula_cliente());
			//ps.setString(2, v.getCedula_usuario());//sobran
			//ps.setDouble(3, v.getIvaventa());//sobran
			//ps.setDouble(4, v.getTotal_venta());//sobran
			//ps.setDouble(5, v.getValor_venta());//sobran
			resul=ps.executeUpdate()>0;
			
			if(resul) {
				sql="select codigo_venta from ventas order by codigo_ventas desc limit 1";
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				int cod=0;
				while(res.next()) {
					cod=res.getInt(1);
				}
				
			    //registrar detalle_venta con codigo_producto, 
				//codigo_venta ya esta consultado, cantidad, se pude tomar el precio de producto y el iva
		    	
				int valor_venta=cantidad_producto*valor_venta //crear otro DTO con las variable que se necesiten para realizar los calculos y poderlas llamar
		    	
				sql="inser into detalles_ventas (cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva) values (?,?,?,?,?,?)"
				ps=con.prepareStatement(sql);//preparar la consulta
				ps.setInt(1, cod);
						    	
		    	ps.setInt(1, precio);//primer ? precio
		    	ps.setInt(2, v.getCant());//segundo ? cantidad
		    	ps.setInt(3, cod);// el ? de codigo del producto
		    	resul=ps.executeUpdate()>0;
		    	
		    	//actualizar ventas  suma de las 3 ventas, total ventas y el iva
		    	sql="update ventas set total_venta=total_venta+(?*?) where codigo_producto=?";
	    		ps=con.prepareStatement(sql);
	    		ps.setInt(1, precio);
	    		ps.setInt(2, v.getCant());
	    		ps.setDouble(3, v.getValor_venta());	    			
	    		resul=ps.executeUpdate()>0;
			    
			    }
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "No se registró la venta"+ ex);
		}
		return resul;
	}

}
