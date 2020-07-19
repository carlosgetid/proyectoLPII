package net.consorcio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.service.RequerimientoService;


@WebServlet("/ServletRequerimiento")
public class ServletRequerimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //
	private RequerimientoService servicioRequerimiento;
    
    public ServletRequerimiento() {
        super();
       servicioRequerimiento=new RequerimientoService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tipo=request.getParameter("accion");
		if(tipo.equals("REGISTRAR"))
			registrar(request,response);
		else if(tipo.equals("ACTUALIZAR"))
			actualizar(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request,response);
		else if(tipo.equals("BUSCAR"))
			buscar(request,response);
		else if(tipo.equals("LISTAR"))
			listar(request,response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//crear un objeto de tipo arreglo de objeto de la clase Distrito
				List<Requerimiento> lista=servicioRequerimiento.listar();
				//crear un objeto que contenga todo el JSON
				JsonArrayBuilder arreglo=Json.createArrayBuilder();
				//bucle
				//getDescripcion()
				for(Requerimiento bean: lista) {
					//crear cada fila
					JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
															  add("descripcion",bean.getDescripcion()).
															  add("origen", bean.getOrigen()).
															  add("area", bean.getArea()).
															  add("criticidad", bean.getCriticidad()).build();
															  
					//enviar el objeto "obj" al arreglo
					arreglo.add(obj);
				}
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter salida=response.getWriter();
				salida.println(arreglo.build());
		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requerimiento bean;
		String cod;
		cod=request.getParameter("codigo");
		bean=servicioRequerimiento.buscar(Integer.parseInt(cod));
		request.setAttribute("requerimiento", bean);
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cod;
		cod=request.getParameter("codigo");
		
		int salida=servicioRequerimiento.eliminar(Integer.parseInt(cod));
		
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro eliminado correctamente");
		else
			request.setAttribute("MENSAJE", "Error en la eliminacionr del registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String cod,des,ori,are,cri,est;
		cod=request.getParameter("codigo");
		des=request.getParameter("descripcion");
		ori=request.getParameter("origen");
		are=request.getParameter("area");
		cri=request.getParameter("criticidad");
//		est=request.getParameter("estado");
		//crear un objeto de la clase Docente
		Requerimiento bean=new Requerimiento();
		//setear los atributos del objeto "bean"
		bean.setCodigo(Integer.parseInt(cod));
		bean.setDescripcion(des);
		bean.setOrigen(ori);
		bean.setArea(are);
		bean.setCriticidad(cri);
//		bean.setEstado(est);
		
		//invocar al m�todo registrarDocente
		int salida=servicioRequerimiento.actualizar(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro actualizado correctamente");
		else
			request.setAttribute("MENSAJE", "Error al actualizar el registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				
				//invocar al m�todo registrarDocente
				int salida=servicioRequerimiento.registrar(bean);
				if(salida!=-1)
					request.setAttribute("MENSAJE", "Se registro correctamente");
				else
					request.setAttribute("MENSAJE", "Error en el registro");
				//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
				request.getRequestDispatcher("/requerimiento.jsp").forward(request, response);
		
	}

}
