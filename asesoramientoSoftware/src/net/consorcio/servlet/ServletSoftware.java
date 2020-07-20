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

import net.consorcio.entidad.Software;
import net.consorcio.service.SoftwareService;

@WebServlet("/ServletSoftware")
public class ServletSoftware extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SoftwareService servicioSoftware;
       
    public ServletSoftware() {
        super();
        servicioSoftware = new SoftwareService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if(tipo.equals("REGISTRAR"))
			registrar(request, response);
		else if(tipo.equals("ACTUALIZAR"))
			actualizar(request, response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request, response);
		else if(tipo.equals("BUSCAR"))
			buscar(request, response);
		else if(tipo.equals("LISTAR"))
			listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Software> lista = servicioSoftware.listar();
		
		JsonArrayBuilder arreglo = Json.createArrayBuilder();
		
		for(Software bean:lista) {
			JsonObject obj = Json.createObjectBuilder().add("codigo", bean.getCodigo()).
														add("nombre", bean.getNombre()).
														add("version", bean.getPrecio()).build();
			arreglo.add(obj);
		}
		
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter salida = response.getWriter();
		salida.println(arreglo.build());
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		Software bean;
		String cod;
		cod = request.getParameter("codigo");
		bean = servicioSoftware.buscar(Integer.parseInt(cod));
		request.setAttribute("software", bean);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom, pre;
		nom = request.getParameter("nombreSoftware");
		pre = request.getParameter("precio");
		
		Software bean = new Software();
		
		bean.setNombre(nom);
		bean.setPrecio(Double.parseDouble(pre));
		
		int salida = servicioSoftware.registrar(bean);
		if (salida != -1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");
		
		request.getRequestDispatcher("/software.jsp").forward(request, response);
	}
	
	

}
