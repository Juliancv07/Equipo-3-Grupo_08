package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class VentasDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_venta(VentasDTO v) {//v=venta
		
		boolean resul=false;
		
		try {
			
			String sql="insert into ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, v.getCedula_cliente());
			ps.setString(2, v.getCedula_usuario());
			ps.setDouble(3, v.getIvaventa());
			ps.setDouble(4, v.getTotal_venta());
			ps.setDouble(5, v.getValor_venta());
			resul=ps.executeUpdate()>0;// por que se actualiza
			
			if(resul) {
				sql="select codigo_venta from ventas order by codigo_ventas desc limit 1";
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				int cod=0;
				while(res.next()) {
					cod=res.getInt(1);
				}
				
				//traer el precio del libro con la sentencia sql
	    		sql="select precio_venta from productos where codigo_producto=?";
	    		ps=con.prepareStatement(sql);
	    		ps.setDouble(1, v.getValor_venta());
	    		res=ps.executeQuery();
		    	int precio=0;//guarda el precio
			    while(res.next()) {
			    	precio=res.getInt(1);
			    }
			    	
			    //actualizar el campo total	
		    	sql="update detalle_ventas set valor_total=?*? where codigo_producto=?"; //total=?*? es decir total=precio*cantidad donde id_prestamo=? aqui esta el codigo del libro
		    	ps=con.prepareStatement(sql);//preparar la consulta	
		    	ps.setInt(1, precio);//primer ? precio
		    	ps.setInt(2, v.getCant());//segundo ? cantidad
		    	ps.setInt(3, cod);// el ? de codigo del producto
		    	resul=ps.executeUpdate()>0;
		    	
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
