package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;
import modelo.ProductoDTO;


/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   ProductoDAO prodDAO=new ProductoDAO();
		   
		   if (request.getParameter("crear")!=null) {
				
				String codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra, precio_venta;
				codigo_producto=request.getParameter("codigo_producto");
				ivacompra=request.getParameter("ivacompra");
				nitproveedor=request.getParameter("nitproveedor");
				nombre_producto=request.getParameter("nombre_producto");
				precio_compra=request.getParameter("precio_compra");
				precio_venta=request.getParameter("precio_venta");
				
				ProductoDTO prod=new ProductoDTO(codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra, precio_venta);
				
				if(prodDAO.Inserta_prod(prod)) {
					//JOptionPane.showMessageDialog(null, "Registro exitoso del producto");
					response.sendRedirect("DatosProd.jsp?men=Registro exitoso del producto");
					
				}else {
					//JOptionPane.showMessageDialog(null, "No se registró el producto");
					response.sendRedirect("DatosProd.jsp?men=Registro exitoso del producto");
				}
		   }

		if (request.getParameter("consultar")!=null) {
			String codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta;
			nombre_producto=request.getParameter("nombre_producto");
			ProductoDTO prod=prodDAO.Buscar_Producto(nombre_producto);
			
			if (prod!=null)
			{
			codigo_producto=prod.getCodigo_producto();
			ivacompra=prod.getIvacompra();
			nitproveedor=prod.getNitproveedor();
			nombre_producto=prod.getNombre_producto();
			precio_compra=prod.getPrecio_compra();
			precio_venta=prod.getPrecio_venta();
			response.sendRedirect("DatosProd.jsp?codigo_producto="+codigo_producto+"&&ivacompra="+ivacompra+"&&nitproveedor="+nitproveedor +"&&nombre_producto="+ nombre_producto+ "&&precio_compra="+precio_compra+ "&&precio_venta="+precio_venta);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "No se encontró el producto");
				response.sendRedirect("DatosProd.jsp?men= El Producto no se encontro.");
			}
		}
        if(request.getParameter("actualizar")!=null) {
        	String codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta;
        	codigo_producto = request.getParameter("codigo_producto");
        	ivacompra = request.getParameter("ivacompra");
        	nitproveedor = request.getParameter("nit_proveedor");
        	nombre_producto = request.getParameter("nombre_producto");
        	precio_compra = request.getParameter("precio_compra");
        	precio_venta= request.getParameter("precio_venta");
            ProductoDTO prodDto_Act = new ProductoDTO(codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta);
        
        if(prodDAO.Actualizar_Producto(prodDto_Act))
        {
            JOptionPane.showMessageDialog(null, "Producto Actualizado.");
            response.sendRedirect("DatosProd.jsp?men=Producto Actualizado Exitosamente.");
        }else {
            JOptionPane.showMessageDialog(null, "El Producto no se Modifico.");
            response.sendRedirect("DatosProd.jsp?men=El Producto no se Modifico.");
        }
}	
        if(request.getParameter("borrar")!=null) {
            String nombre_producto;
            nombre_producto = request.getParameter("nombre_producto");
            int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Producto: "+nombre_producto +"?");
            if(op==0) {
	            if(prodDAO.Eliminar_Producto(nombre_producto))
	            {
	                response.sendRedirect("DatosProd.jsp?men=Producto  Eliminado");
	            }
	            else 
	            {
                response.sendRedirect("DatosProd.jsp?men=El producto no se elimino");
	            }
            }
            else {
                response.sendRedirect("DatosProd.jsp");
}
}
		if(request.getParameter("cargar")!=null) {
			
			Part archivo= request.getPart("archivo");
			//String Url="C:\\Users\\vivis\\eclipse-workspace\\Prestamos_08\\src\\main\\webapp\\Documentos\\";
			//En Mysql: show variables like 'secure_file_priv'
			//String tipo= archivo.getContentType();    // esta linea para preguntar que tipo de archivos acepta
			//JOptionPane.showMessageDialog(null, tipo);  // esta linea para preguntar que tipo de archivos acepta
			String Url="C:/xampp/mysql/data";
			
			if(archivo.getContentType().equals("application/vnd.ms-excel")) {  //tipo de archivo csv
			try {
			InputStream file= archivo.getInputStream();
			File copia= new File(Url+"Prueba01_Tienda_Generica.csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num=file.read();
			while(num !=-1) {
				escribir.write(num);
				num=file.read();
			}
			file.close();
			escribir.close();
			JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
			if(prodDAO.Cargar_Productos(Url+"Prueba01_Tienda_Generica.csv")) {
				response.sendRedirect("DatosProd.jsp?men=Se registro los productos correctamente");
			}else
			{
				response.sendRedirect("DatosProd.jsp?men=No se registraron productos");
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo: "+e);
				response.sendRedirect("Datosprod.jsp?men=Error al cargar el archivo: ");
				
			}
			}else
			{
				response.sendRedirect("DatosProd.jsp?men=Formato de Archivo no permitido");
}
}
}
}