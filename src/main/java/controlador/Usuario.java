package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

/*configuracion del borton crear usuario*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usuDao= new UsuarioDAO();
		if (request.getParameter("crear")!=null){
			String Cedula, Email, Password, Usuario, Nombresusuario;
			Cedula=request.getParameter("cedula_usuario");		//es el mismo nombre de la BD workbench
			Email=request.getParameter("email_usuarios");
			Password=request.getParameter("password");
			Usuario=request.getParameter("usuario");
			Nombresusuario=request.getParameter("nombre_usuario");			
			
			UsuarioDTO usu=new UsuarioDTO(Cedula, Email, Nombresusuario, Password, Usuario);

				if(usuDao.crear_usuario(usu)) {											//si esto es verdadero se registra
					//JOptionPane.showMessageDialog(null, "Registro Exitoso");
					response.sendRedirect("DatosUsu.jsp?men=Registro Exitoso");
					//response.sendRedirect("DatosUsu.jsp");							//redirecciona a formulario DatosUsu.jsp
					
				}else {																//si no es verdadero 
					//JOptionPane.showMessageDialog(null, "Registro Fallido");
					response.sendRedirect("DatosUsu.jsp?men=Registro Exitoso");
					//response.sendRedirect("DatosUsu.jsp");
			}
		}
		//consultar o buscar
		
		if(request.getParameter("consultar")!=null) {
			String cedula, email, password, usuario, nombresusuario;
			cedula=request.getParameter("cedula");
			UsuarioDTO usu=usuDao.Buscar_Cedula(cedula);
			if(usu!=null) {
				cedula=usu.getCedula_usuario();
				email=usu.getEmail_usuario();
				password=usu.getPassword();
				usuario=usu.getUsuario();
				nombresusuario=usu.getNombre_usuario();
				response.sendRedirect("DatosUsu.jsp?cedula="+cedula+"&&email="+email+"&&password="+password+"&&usuario="+usuario+
						"&&Nombreusuario="+nombresusuario);
		}else {
			response.sendRedirect("DatosUsu.jsp?men=La Cedula no se Encuentra");
		}
	}
			//Actualizar, configuracion de boton
        if(request.getParameter("actualizar")!=null) {
        String cedula, email, password, usuario, nombresusuario;
        cedula = request.getParameter("cedula_usuario");
        email = request.getParameter("email_usuarios");
        password = request.getParameter("password");
        usuario = request.getParameter("usuario");
        nombresusuario =request.getParameter("nombre_usuario");
        UsuarioDTO usuDto_Act = new UsuarioDTO(cedula, email, nombresusuario, password, usuario );
        
        if(usuDao.Actualizar_Usuario(usuDto_Act)) {
            JOptionPane.showMessageDialog(null, "El usuario se actualizo Exitosamente.");
            response.sendRedirect("DatosUsu.jsp?men=Usuario Actualizado Exitosamente.");
        }else {
            JOptionPane.showMessageDialog(null, "El Usuario no se Modifico.");
            response.sendRedirect("DatosUsu.jsp?men=El Usuario no se Modifico.");
        }
}

		// eliminar
		if(request.getParameter("borrar")!=null) {
			String cedula;
			cedula=request.getParameter("cedula_usuario");
			int op=JOptionPane.showConfirmDialog(null, "Desea eliminar Cedula CC: "+cedula);
			if(op==0) {
				if(usuDao.Eliminar_Usuario(cedula)) {
					response.sendRedirect("DatosUsu.jsp?men=Usuario Eliminado");
				}else {
					response.sendRedirect("DatosUsu.jsp?men=Usuario no se Elimino");
				}
			}else {
				response.sendRedirect("DatosUsu.jsp");
			}
		}			
	}
}	

