package net.asesoramiento.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.asesoramiento.entidad.Requerimiento;
import net.asesoramiento.service.RequerimientoService;


@WebServlet("/ServletRequerimiento")
public class ServletRequerimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //declarar atributo de la clase DocenteService
	private RequerimientoService servicioRequerimiento;
    
    public ServletRequerimiento() {
        super();
        //
        servicioRequerimiento= new RequerimientoService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener la acción que va a realizar el servlet
				String tipo=request.getParameter("accion");
				//validar
				if(tipo.equals("REGISTRAR"))
					registrarRequerimiento(request,response);
				else if(tipo.equals("LISTAR"))
					listarRequerimiento(request,response);
	}

	private void listarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//crear un objeto de tipo arreglo de objeto de la clase Docente
		List<Requerimiento> lista=servicioRequerimiento.listarRequerimientos();
		//crear un atributo que almacene el valor de lista
		request.setAttribute("docentes", lista);
		//direccionar a la pàgina listaDocente.jsp para que reciba el atributo "docentes"
		request.getRequestDispatcher("/listaDocente.jsp").forward(request, response);
	}
	private void registrarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String des,ori,are,cri;
		des=request.getParameter("descripcion");
		ori=request.getParameter("origen");
		are=request.getParameter("area");
		cri=request.getParameter("criticidad");
		//crear un objeto de la clase Docente
		Requerimiento bean=new Requerimiento();
		//setear los atributos del objeto "bean"
		bean.setDescripcion(des);
		bean.setOrigen(ori);
		bean.setArea(are);		
		bean.setCriticidad(cri);
		
		//invocar al mètodo registrarRequerimiento
		servicioRequerimiento.registrarRequerimiento(bean);
		//direccionar a la página docente.html
		response.sendRedirect("requerimiento.jsp");
	}
}
