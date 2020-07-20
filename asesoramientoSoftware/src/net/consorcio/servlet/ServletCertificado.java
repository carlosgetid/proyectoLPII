package net.consorcio.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.consorcio.entidad.Certificado;
import net.consorcio.service.CertificadoService;

@WebServlet("/ServletCertificado")
@MultipartConfig
public class ServletCertificado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CertificadoService servicioCertificado;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       
    public ServletCertificado() {
        super();
        servicioCertificado = new CertificadoService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("REGISTRAR"))
			try {
				registrar(request,response);
			} catch (IOException | ServletException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		List<Certificado> lista=servicioCertificado.listAll();
		//crear un objeto que contenga todo el JSON
		JsonArrayBuilder arreglo=Json.createArrayBuilder();
		//bucle
		//getDescripcion()
		for(Certificado bean: lista) {
			//crear cada fila
			JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
													  add("fechaHora",(JsonValue) bean.getFechaHora()).
													  add("url", bean.getUrl()).
													  add("nombreArchivo", bean.getNombreArchivo()).build();
													  
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

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
//		String fecHor,url,nom;
		Part doc;
//		fecHor=request.getParameter("fechaHora");
//		url=request.getParameter("url");
//		nom=request.getParameter("nombreArchivo");
		doc=request.getPart("documento");

		InputStream idoc =doc.getInputStream();
		
//		Convertir una cadena a Date.util y luego lo convierte Date.sql
		Date sqlFecIn = new Date(sdf.parse("2001-01-01").getTime());

		
		Certificado bean=new Certificado();
		
		bean.setFechaHora(sqlFecIn);
		bean.setUrl("asdsad");
		bean.setNombreArchivo("saddsa");
		bean.setDocumento(idoc);
		
		//invocar al m�todo registrarDocente
		int salida=servicioCertificado.save(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");
		//direccionar a la p�gina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/certificado.jsp").forward(request, response);

}

}	
