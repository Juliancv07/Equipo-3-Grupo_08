package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProveedorDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_prov(ProveedorDTO prov) {
		
		boolean result=false;
		
		try {
			
			String sql="insert into proveedores values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, prov.getNitproveedor());
			ps.setString(2, prov.getCiudad_proveedor());
			ps.setString(3, prov.getDireccion_proveedor());
			ps.setString(4, prov.getNombre_proveedor());
			ps.setString(5, prov.getTelefono_proveedor());
			result=ps.executeUpdate()>0;// por que se actualiza
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "No se registró el Proveedor"+ ex);
		}
		return result;
	}
public ProveedorDTO Buscar_Proveedor(String nitproveedor) {
		
		ProveedorDTO prov=null;

		try {
			String sql="Select * from proveedores where nitproveedor=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, nitproveedor);
			res=ps.executeQuery();
			while(res.next()) {
				prov=new ProveedorDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al consultar el proveedor" + ex);
		}
		return prov;
	}
    public boolean Actualizar_Proveedor(ProveedorDTO prov) {
        boolean resul=false;
        try {
        String sql="update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nitproveedor=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, prov.getCiudad_proveedor());
        ps.setString(2, prov.getDireccion_proveedor());
        ps.setString(3, prov.getNombre_proveedor());
        ps.setString(4, prov.getTelefono_proveedor());
        ps.setString(5, prov.getNitproveedor());
        resul=ps.executeUpdate()>0;    
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar el proveedor: "+ex);
        }
        return resul;
    }
    public boolean Eliminar_Proveedor(String nitproveedor) {
        boolean resul=false;
        try {
        String sql="delete from proveedores where nitproveedor=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, nitproveedor);
        resul=ps.executeUpdate()>0;    
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar el proveedor: "+ex);
        }
        return resul;
    }
}