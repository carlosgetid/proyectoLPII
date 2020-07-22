package net.consorcio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.Usuario;
import net.consorcio.service.RequerimientoService;
import net.consorcio.utils.MySqlBDConexion;

import java.io.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


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
		else if(tipo.equals("CONSULTAR"))
			try {
				consultar(request,response);
			} catch (JRException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	private void consultar(HttpServletRequest request, HttpServletResponse response) throws JRException, IOException {		
		ServletContext application=request.getServletContext();
		
		File reportfile = new File (application.getRealPath("requerimiento.jasper"));
		Map<String, Object> parameter = new HashMap<String, Object>();
		
		String valor = request.getParameter("codigo");
		
		int nvalor = Integer.parseInt(valor);
		
		parameter.put("cod",nvalor);
		
		Connection cn=MySqlBDConexion.getConexion();
		
		
		
		byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, cn);
		
//	 	indicar que la salida sera en formato pdf
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(bytes,0,bytes.length);
		
//	 	limpiar flujos de salida
		outputStream.flush();
		outputStream.close();
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
															  add("criticidad", bean.getCriticidad()).
															  add("nombreEstado", bean.getNombreEstado()).build();
															  
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
		request.getRequestDispatcher("/actualizarRequerimiento.jsp").forward(request, response);
		
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
		request.getRequestDispatcher("/listaRequerimientoEnc.jsp").forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String cod,des,ori,are,cri,est;
		cod=request.getParameter("codigo");
		des=request.getParameter("descripcion");
		ori=request.getParameter("origen");
		are=request.getParameter("area");
		cri=request.getParameter("criticidad");
		est=request.getParameter("nombreEstado");
		
		int nest = Integer.parseInt(est);
		
		//crear un objeto de la clase Docente
		Requerimiento bean=new Requerimiento();
		//setear los atributos del objeto "bean"
		bean.setCodigo(Integer.parseInt(cod));
		bean.setDescripcion(des);
		bean.setOrigen(ori);
		bean.setArea(are);
		bean.setCriticidad(cri);
		bean.setCodigoEstado(nest);
		
		//invocar al m�todo registrarDocente
		int salida=servicioRequerimiento.actualizar(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro actualizado correctamente");
		else
			request.setAttribute("MENSAJE", "Error al actualizar el registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizarRequerimiento.jsp").forward(request, response);
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
				String des,ori,are,cri;
				
				//objeto tipo sesion
		        HttpSession session=request.getSession();
				
				//recuperar el atributo usuario
		        Usuario usu=(Usuario) session.getAttribute("usuario");
				
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
				bean.setCodigoUsuario(usu.getCodigo());
				
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
