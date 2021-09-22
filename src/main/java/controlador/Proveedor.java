package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;

/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProveedorDAO provDAO=new ProveedorDAO();
		if (request.getParameter("crear")!=null) {
			
			String nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor;
			nitproveedor=request.getParameter("nitproveedor");
			ciudad_proveedor=request.getParameter("ciudad_proveedor");
			direccion_proveedor=request.getParameter("direccion_proveedor");
			nombre_proveedor=request.getParameter("nombre_proveedor");
			telefono_proveedor=request.getParameter("telefono_proveedor");
			
			ProveedorDTO prov=new ProveedorDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
			
			if(provDAO.Inserta_prov(prov)) {
				JOptionPane.showMessageDialog(null, "Registro exitoso del proveedor");
				response.sendRedirect("DatosProv.jsp");
				
			}else {
				JOptionPane.showMessageDialog(null, "No se registró el proveedor");
				response.sendRedirect("DatosProv.jsp");
			}
		}
		if (request.getParameter("consultar")!=null) {
			String nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor;
			nitproveedor=request.getParameter("nitproveedor");
			ProveedorDTO prov=provDAO.Buscar_Proveedor(nitproveedor);
			
			if (prov!=null)
			{
			nitproveedor=prov.getNitproveedor();
			ciudad_proveedor=prov.getCiudad_proveedor();
			direccion_proveedor=prov.getDireccion_proveedor();
			nombre_proveedor=prov.getNombre_proveedor();
			telefono_proveedor=prov.getTelefono_proveedor();
			response.sendRedirect("DatosProv.jsp?nitproveedor="+nitproveedor+"&&ciudad_proveedor="+ciudad_proveedor+"&&direccion_proveedor="+direccion_proveedor +"&&nombre_proveedor="+ nombre_proveedor+ "&&telefono_proveedor="+telefono_proveedor);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "No se encontró el proveedor");
				response.sendRedirect("DatosProv.jsp?men= El Proveedor no se encontro.");
			}
		}
		
        if(request.getParameter("actualizar")!=null) {
			String nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor;
            nitproveedor = request.getParameter("nitproveedor");
            ciudad_proveedor = request.getParameter("ciudad_proveedor");
            direccion_proveedor = request.getParameter("direccion_proveedor");
            nombre_proveedor = request.getParameter("nombre_proveedor");
            telefono_proveedor = request.getParameter("telefono_proveedor");
            ProveedorDTO provDto_Act = new ProveedorDTO(nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor);
        
        if(provDAO.Actualizar_Proveedor(provDto_Act))
        {
            JOptionPane.showMessageDialog(null, "Proveedor se Actualizo Exitosamente.");
            response.sendRedirect("DatosProv.jsp?men=Proveedor Actualizado Exitosamente.");
        }else {
            JOptionPane.showMessageDialog(null, "El Proveedor no se Modifico.");
            response.sendRedirect("DatosProv.jsp?men=El Proveedor no se Modifico.");
        }
}	
        if(request.getParameter("borrar")!=null) {
            String nitproveedor;
            nitproveedor = request.getParameter("nitproveedor");
            int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Proveedor NIT: "+nitproveedor);
            if(op==0) {
	            if(provDAO.Eliminar_Proveedor(nitproveedor))
	            {
	                response.sendRedirect("DatosProv.jsp?men=Proveedor  Eliminado");
	            }
	            else 
	            {
                response.sendRedirect("DatosProv.jsp?men=Proveedor no se elimino");
	            }
            }
            else {
                response.sendRedirect("DatosProv.jsp");
            }
        }        
 	}
}