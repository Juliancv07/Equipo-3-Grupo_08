package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductoDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	
	public boolean Inserta_prod(ProductoDTO prod) {
		
		boolean result=false;
		
		try {
			
			String sql="insert into productos values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, prod.getCodigo_producto());
			ps.setString(2, prod.getIvacompra());
			ps.setString(3, prod.getNitproveedor());
			ps.setString(4, prod.getNombre_producto());
			ps.setString(5, prod.getPrecio_compra());
			ps.setString(6, prod.getPrecio_venta());
			result=ps.executeUpdate()>0;// por que se actualiza
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "No se registró el Producto"+ ex);
		}
		return result;
	}
	
public ProductoDTO Buscar_Producto(String nombre_producto) {
		
		ProductoDTO prod=null;

		try {
			String sql="Select * from productos where nombre_producto=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, nombre_producto);
			res=ps.executeQuery();
			while(res.next()) {
				prod=new ProductoDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar el producto" + ex);
		}
		return prod;
	}
public boolean Actualizar_Producto(ProductoDTO prod) {
    boolean resul=false;
    try {
    String sql="update productos set ivacompra=?, nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? where codigo_producto=?";
    ps = con.prepareStatement(sql);

    ps.setString(1, prod.getIvacompra());
    ps.setString(2, prod.getNitproveedor());
    ps.setString(3, prod.getNombre_producto());
    ps.setString(4, prod.getPrecio_compra());
    ps.setString(5, prod.getPrecio_venta());
    ps.setString(6, prod.getCodigo_producto());
    resul=ps.executeUpdate()>0;    
    }catch(SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al actualizar el producto: "+ex);
    }
    return resul;
}
public boolean Eliminar_Producto(String nombre_producto) {
    boolean resul=false;
    try {
    String sql="delete from productos where nombre_producto=?";
    ps = con.prepareStatement(sql);
    ps.setString(1, nombre_producto);
    resul=ps.executeUpdate()>0;    
    }catch(SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al eliminar el producto: "+ex);
    }
    return resul;
}
public boolean Cargar_Productos(String URL) {  //Metodo para cargar el archivo envía desde el servlett al ruta donde esta la url
	
	boolean result=false;  //empieza en false por que no se ha hecho el proceso
	try {
		String sql="Load data infile'"+URL+"'into table productos fields terminated by','lines terminated by '\r\n'";//concatena la variable url en libro campos terminados en coma(,) o puntos y comas depednde del archivo, fin de fila y salto de linea
		ps= con.prepareStatement(sql); //preparar consulta
		result=ps.executeUpdate()>0;   //ejecutar consulta y es update por que modifica datops en la tabla si es >=0 ejecutto es verdadero
	
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"Error al registrar los productos" + ex);
		
	}
	return result;
}
}