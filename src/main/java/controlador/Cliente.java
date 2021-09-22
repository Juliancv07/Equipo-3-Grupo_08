package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO cliDao= new ClienteDAO();
		if (request.getParameter("crear")!=null)
		{
			String cedula_cliente, telefono_cliente, nombre_cliente, email_cliente, direccion_cliente;
			cedula_cliente=request.getParameter("cedula_cliente");		//es el mismo nombre de la BD workbench
			direccion_cliente=request.getParameter("direccion_cliente");
			email_cliente=request.getParameter("email_cliente");
			nombre_cliente=request.getParameter("nombre_cliente");
			telefono_cliente=request.getParameter("telefono_cliente");
			
						
			
			ClienteDTO cli=new ClienteDTO(cedula_cliente, direccion_cliente, email_cliente,  nombre_cliente, telefono_cliente);

				if(cliDao.Crear_Cliente(cli)) 
				{											//si esto es verdadero se registra
					//JOptionPane.showMessageDialog(null, "Registro Exitoso");
					response.sendRedirect("DatosCli.jsp?men=Registro Exitoso");
					//response.sendRedirect("DatosUsu.jsp");							//redirecciona a formulario DatosUsu.jsp
					
				}
				else 
				{																//si no es verdadero 
					//JOptionPane.showMessageDialog(null, "Registro Fallido");
					response.sendRedirect("DatosCli.jsp?men=Registro Exitoso");
					//response.sendRedirect("DatosUsu.jsp");
				}
		}
		//consultar o buscar
		
		if(request.getParameter("consultar")!=null)
		{
			String cedula_cliente, telefono_cliente, nombre_cliente, email_cliente, direccion_cliente;
			cedula_cliente=request.getParameter("cedula_cliente");
			ClienteDTO cli=cliDao.Buscar_Cedula(cedula_cliente);
			if(cli!=null)
			{
				cedula_cliente=cli.getCedula_cliente();
				telefono_cliente=cli.getTelefono_cliente();
				nombre_cliente=cli.getNombre_cliente();
				email_cliente=cli.getEmail_cliente();
				direccion_cliente=cli.getDireccion_cliente();
				response.sendRedirect("DatosCli.jsp?cedula_cliente="+cedula_cliente+"&&telefono_cliente="+telefono_cliente+"&&nombre_cliente="+nombre_cliente+"&&email_cliente="+email_cliente+
						"&&direccion_cliente="+direccion_cliente);
			}
			else
			{
				response.sendRedirect("DatosCli.jsp?men=La Cedula no se Encuentra");
			}
	}
			//Actualizar, configuracion de boton
        if(request.getParameter("actualizar")!=null)
        {
	        String cedula_cliente, telefono_cliente, nombre_cliente, email_cliente, direccion_cliente;
	        cedula_cliente = request.getParameter("cedula_cliente");
	        telefono_cliente = request.getParameter("telefono_cliente");
	        nombre_cliente = request.getParameter("nombre_cliente");
	        email_cliente = request.getParameter("email_cliente");
	        direccion_cliente =request.getParameter("direccion_cliente");
	        ClienteDTO cliDto_Act = new ClienteDTO(cedula_cliente, direccion_cliente, email_cliente,  nombre_cliente, telefono_cliente);
        
	        if(cliDao.Actualizar_Cliente(cliDto_Act)) 
	        {
	            //JOptionPane.showMessageDialog(null, "El cliente se actualizo Exitosamente.");
	            response.sendRedirect("DatosCli.jsp?men=Cliente Actualizado Exitosamente.");
	        }
	        else 
	        {
	            //JOptionPane.showMessageDialog(null, "El Cliente no se Modifico.");
	            response.sendRedirect("DatosUsu.jsp?men=El Cliente no se Modificó.");
	        }
        }

		// eliminar
		if(request.getParameter("borrar")!=null) 
		{
			String cedula_cliente;
			cedula_cliente=request.getParameter("cedula_cliente");
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar Cedula CC: "+cedula_cliente);
			if(op==0)
			{
				if(cliDao.Eliminar_Cliente(cedula_cliente))
				{
					response.sendRedirect("DatosCli.jsp?men=Cliente Eliminado");
				}
				else
				{
					response.sendRedirect("DatosCli.jsp?men=No se eliminó el Cliente");
				}
			}
			else
			{
				response.sendRedirect("DatosCli.jsp");
			}
		}			
	}
}	


