package net.consorcio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.List;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.SolicitudCertificado;
import net.consorcio.entidad.Usuario;
import net.consorcio.service.SolicitudService;
import net.sf.jasperreports.engine.JRException;

@WebServlet("/ServletSolicitud")
public class ServletSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //
	private SolicitudService servicioSolicitud;
	
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public ServletSolicitud() {
        super();
        servicioSolicitud=new SolicitudService();
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
		List<SolicitudCertificado> lista=servicioSolicitud.listar();
		//crear un objeto que contenga todo el JSON
		JsonArrayBuilder arreglo=Json.createArrayBuilder();
		//bucle
		//getDescripcion()
		for(SolicitudCertificado bean: lista) {
			//crear cada fila
			JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
													  add("objetivo",bean.getObjetivo()).
													  add("monto", bean.getMonto()).
													  add("area", bean.getArea()).
													  add("fecha", formatter.format(bean.getFecha())).
													  add("nombreEstado", bean.getNombreEstado()).build();
													  
			//enviar el objeto "obj" al arreglo
			arreglo.add(obj);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(arreglo.build());

		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod;
		cod=request.getParameter("codigo");
		
		int salida=servicioSolicitud.eliminar(Integer.parseInt(cod));
		
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro eliminado correctamente");
		else
			request.setAttribute("MENSAJE", "Error en la eliminacionr del registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/").forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String obj,mon,are,codCot;
		
		//objeto tipo sesion
        HttpSession session=request.getSession();
		
		//recuperar el atributo usuario
        Usuario usu=(Usuario) session.getAttribute("usuario");
		
		obj=request.getParameter("objetivo");
		mon=request.getParameter("monto");
		are=request.getParameter("area");
		codCot=request.getParameter("codigoCotizacion");
		
		
		//crear un objeto de la clase Docente
		SolicitudCertificado bean=new SolicitudCertificado();
		//setear los atributos del objeto "bean"
		bean.setObjetivo(obj);
		bean.setMonto(Double.parseDouble(mon));
		bean.setArea(are);
		bean.setCodigoUsuario(usu.getCodigo());
		bean.setCodigoCotizacion(Integer.parseInt(codCot));
		
		//invocar al m�todo registrarDocente
		int salida=servicioSolicitud.registrar(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/SolicitudCertificado.jsp").forward(request, response);
		
	}
		
		
	}
	



