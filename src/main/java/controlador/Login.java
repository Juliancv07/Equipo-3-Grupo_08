package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

/*formulario de ingreso administrador*/
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Ingresar")!= null) {
			String usuario,contraseña;
			usuario=request.getParameter("usuario"); //datos traídos desde el formulario
			contraseña=request.getParameter("contraseña");//datos traídos desde el formulario
			
			if(usuario.equals("admininicial") && contraseña.equals("123456")){
				JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
				response.sendRedirect("Menu.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				response.sendRedirect("Login.jsp");
			}
		}
	}

}
