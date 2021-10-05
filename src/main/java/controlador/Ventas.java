package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;



/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO proDao= new ProductoDAO();
		ClienteDAO cliDao= new ClienteDAO();
		
		/*esto sobra porque ya esata el dela linea 51 en adelante*/
		
		/*consulta el libro y trae los datos
		if (request.getParameter("consultarProd")!=null) {
			String codigo_producto=request.getParameter("producto");
			//ProductoDAO proDao=new ProductoDAO(); //llamar el DAO del libro
			ProductoDTO pro=proDao.Buscar_Producto(codigo_producto);
			
			if(pro!=null) {
				String nombre_producto=pro.getNombre_producto();
				codigo_producto=pro.getCodigo_producto();
				response.sendRedirect("DatosVen.jsp?nombre_producto="+nombre_producto+"&&codigo_producto="+codigo_producto);
			}else {
				response.sendRedirect("DatosVen.jsp?men=El producto no se encontro");
			}
		}*/
		
			
		//consultar o buscar cedula cliente
		
		if(request.getParameter("consultar")!=null)
		{
			String cedula_cliente, nombre_cliente;
			cedula_cliente=request.getParameter("cedula_cliente");
			ClienteDTO cli=cliDao.Buscar_Cedula(cedula_cliente);
				if(cli!=null)
				{
					cedula_cliente=cli.getCedula_cliente();
					nombre_cliente=cli.getNombre_cliente();
					response.sendRedirect("DatosVen.jsp?cedula_cliente="+cedula_cliente+"&&nombre_cliente="+nombre_cliente);
				}
				else
				{
					response.sendRedirect("DatosVen.jsp?men=La Cedula no se Encuentra");
				}
		}
		
		//consultar producto
			if(request.getParameter("consultar1")!=null)
			{
				String codigo_producto, nombre_producto;
				codigo_producto=request.getParameter("codigo_producto");
				ProductoDTO pro=proDao.Buscar_Producto(codigo_producto);
					if(pro!=null)
					{
						codigo_producto=pro.getCodigo_producto();
						nombre_producto=pro.getNombre_producto();
						response.sendRedirect("DatosVen.jsp?codigo_producto="+codigo_producto+"&&nombre_producto="+nombre_producto);

					}
					else
					{
						response.sendRedirect("DatosVen.jsp?men=El producto no se Encuentra");
					}
			}
	}

}
