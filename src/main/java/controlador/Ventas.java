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
import modelo.VentasDAO;



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
		
		VentasDAO venDao= new VentasDAO();
		ClienteDAO cliDao= new ClienteDAO();
		
		
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
				String codigo_producto1, nombre_producto1;
				codigo_producto1=request.getParameter("codigo_producto1");
				ProductoDTO pro=venDao.Buscar_Producto(codigo_producto1);
					if(pro!=null)
					{
						codigo_producto1=pro.getCodigo_producto();
						nombre_producto1=pro.getNombre_producto();
						response.sendRedirect("DatosVen.jsp?codigo_producto1="+codigo_producto1+"&&nombre_producto1="+nombre_producto1);

					}
					else
					{
						response.sendRedirect("DatosVen.jsp?men=El producto no se Encuentra");
					}
			}
			
			//consultar 2
			if(request.getParameter("consultar2")!=null)
			{
				String codigo_producto2, nombre_producto2;
				codigo_producto2=request.getParameter("codigo_producto2");
				ProductoDTO pro=venDao.Buscar_Producto(codigo_producto2);
					if(pro!=null)
					{
						codigo_producto2=pro.getCodigo_producto();
						nombre_producto2=pro.getNombre_producto();
						response.sendRedirect("DatosVen.jsp?codigo_producto2="+codigo_producto2+"&&nombre_producto2="+nombre_producto2);

					}
					else
					{
						response.sendRedirect("DatosVen.jsp?men=El producto no se Encuentra");
					}
			}
			
			//consultar 3

			if(request.getParameter("consultar3")!=null)
			{
				String codigo_producto3, nombre_producto3;
				codigo_producto3=request.getParameter("codigo_producto3");
				ProductoDTO pro=venDao.Buscar_Producto(codigo_producto3);
					if(pro!=null)
					{
						codigo_producto3=pro.getCodigo_producto();
						nombre_producto3=pro.getNombre_producto();
						response.sendRedirect("DatosVen.jsp?codigo_producto3="+codigo_producto3+"&&nombre_producto3="+nombre_producto3);

					}
					else
					{
						response.sendRedirect("DatosVen.jsp?men=El producto no se Encuentra");
					}
			}
			
	}

}
