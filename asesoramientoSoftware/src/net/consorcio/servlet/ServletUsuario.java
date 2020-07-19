package net.consorcio.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.consorcio.entidad.Menu;
import net.consorcio.entidad.Usuario;
import net.consorcio.service.UsuarioService;


@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService servicioUsuario;
       
    
    public ServletUsuario() {
        super();
        servicioUsuario=new UsuarioService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo=request.getParameter("accion");
		if(tipo.equals("INICIAR"))
			sesionUsuario(request,response);
		if(tipo.equals("CERRAR"))
			cerrarSesion(request,response);
		
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// obtener la sesion actual
		HttpSession session=request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	private void sesionUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String pass=request.getParameter("clave");
		//
		Usuario bean=servicioUsuario.iniciarSesion(login, pass);
		//validar el objeto bean
		if(bean==null) {
			request.setAttribute("MENSAJE", "Usuario y/o clave incorrecta");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			//traer los menus segun el codigo del usuario
			List<Menu> listaMenus=servicioUsuario.traerMenuPorUsuario(bean.getCodigo());
			HttpSession session=request.getSession();
			session.setAttribute("lista", listaMenus);
			
			session.setAttribute("usuario", bean);
			
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}
		
	}

}
