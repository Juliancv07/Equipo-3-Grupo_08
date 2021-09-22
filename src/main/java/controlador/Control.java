package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")//vamos a inyectar un servicio de servlet para esta clase control
public class Control extends HttpServlet { // hereda de clase HttpServlett
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {   // clase control con los atributos de http servlett
        super();
        // TODO Auto-generated constructor stub
    }

/*pagina del login*/
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario,contraseña;
		usuario = request.getParameter("usuario");
		contraseña = request.getParameter("contraseña");
		
		/*if (request.getParameter("ingresar")!= null){
			usuario= request.getParameter("usuario");
			contraseña= request.getParameter("contraseña");
			
			if(usuario.equals("admininicial") && contraseña.equals("123456")) {
				JOptionPane.showMessageDialog(null, "Bienvenido! Administrador");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				response.sendRedirect("login.jsp");
			}
		}*/
	}
}

