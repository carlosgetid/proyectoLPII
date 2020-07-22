package net.consorcio.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.consorcio.entidad.InformeTecnico;
import net.consorcio.entidad.Usuario;
import net.consorcio.service.InformeService;
import net.consorcio.utils.MySqlBDConexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


@WebServlet("/ServletInforme")
public class ServletInforme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //
	private InformeService servicioInforme;
	
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
   
    public ServletInforme() {
        super();
       servicioInforme=new InformeService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("NUEVO"))
			nuevo(request,response);
		else if(tipo.equals("REGISTRAR"))
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
		
		File reportfile = new File (application.getRealPath("informeTecnico.jasper"));
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


	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod=request.getParameter("codigo");
		request.setAttribute("codigoRequerimiento", cod);
		request.getRequestDispatcher("/informeTecnico.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//crear un objeto de tipo arreglo de objeto de la clase Distrito
				List<InformeTecnico> lista=servicioInforme.listar();
				//crear un objeto que contenga todo el JSON
				JsonArrayBuilder arreglo=Json.createArrayBuilder();
				//bucle
				for(InformeTecnico bean: lista) {
					//crear cada fila
					JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
															  add("introduccion", bean.getIntroduccion()).
															  add("fecha", formatter.format(bean.getFecha())).
															  add("nombreEstado", bean.getNombreEstado()) .build();
					//enviar el objeto "obj" al arreglo
					arreglo.add(obj);
				}
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter salida=response.getWriter();
				salida.println(arreglo.build());
		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InformeTecnico bean;
		String cod;
		cod=request.getParameter("codigo");
		bean=servicioInforme.buscar(Integer.parseInt(cod));
		request.setAttribute("informe", bean);
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizarInforme.jsp").forward(request, response);
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod;
		cod=request.getParameter("codigo");
		
		int salida=servicioInforme.eliminar(Integer.parseInt(cod));
		
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro eliminado correctamente");
		else
			request.setAttribute("MENSAJE", "Error en la eliminacionr del registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/listaInformeTecnicoTec.jsp").forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
				String cod,intr,ant,ana,con,rec,est;
				cod=request.getParameter("codigo");
				intr=request.getParameter("introduccion");
				ant=request.getParameter("antecedentes");
				ana=request.getParameter("analisis");
				con=request.getParameter("conclusiones");
				rec=request.getParameter("recomendaciones");
				est=request.getParameter("nombreEstado");
				
				int nest = Integer.parseInt(est);
				
				//crear un objeto de la clase Docente
				InformeTecnico bean=new InformeTecnico();
				//setear los atributos del objeto "bean"
				bean.setCodigo(Integer.parseInt(cod));
				bean.setIntroduccion(intr);
				bean.setAntecedentes(ant);
				bean.setAnalisis(ana);
				bean.setConclusiones(con);
				bean.setRecomendaciones(rec);
				bean.setCodigoEstado(nest);
				
				//invocar al m�todo registrarDocente
				int salida=servicioInforme.actualizar(bean);
				if(salida!=-1)
					request.setAttribute("MENSAJE", "Registro actualizado correctamente");
				else
					request.setAttribute("MENSAJE", "Error al actualizar el registro");
				//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
				request.getRequestDispatcher("/actualizarInforme.jsp").forward(request, response);
				
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String intr,ant,ana,con,rec,codReq;
		intr=request.getParameter("introduccion");
		ant=request.getParameter("antecedentes");
		ana=request.getParameter("analisis");
		con=request.getParameter("conclusiones");
		rec=request.getParameter("recomendaciones");
		codReq=request.getParameter("codigoRequerimiento");
		
		//objeto tipo sesion
        HttpSession session=request.getSession();
		
		//recuperar el atributo usuario
        Usuario usu=(Usuario) session.getAttribute("usuario");
		
		//crear un objeto de la clase Docente
		InformeTecnico bean=new InformeTecnico();
		//setear los atributos del objeto "bean"
		bean.setIntroduccion(intr);
		bean.setAntecedentes(ant);
		bean.setAnalisis(ana);
		bean.setConclusiones(con);
		bean.setRecomendaciones(rec);
		bean.setCodigoUsuario(usu.getCodigo());
		bean.setCodigoRequerimiento(Integer.parseInt(codReq));
		
		//invocar al m�todo registrarDocente
		int salida=servicioInforme.registrar(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/informeTecnico.jsp").forward(request, response);
		
	}

}
