package net.consorcio.servlet;

import java.io.IOException;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.consorcio.entidad.InformeInstalacion;
import net.consorcio.service.InformeInstalacionService;

@WebServlet("/ServletInformeInstalacion")
public class ServletInformeInstalacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InformeInstalacionService servicioInformeInstalacion;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	public ServletInformeInstalacion() {
		super();
		servicioInformeInstalacion = new InformeInstalacionService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		if (tipo.equals("REGISTRAR"))
			try {
				registrar(request, response);
			} catch (ServletException | IOException | ParseException e) {
				e.printStackTrace();
			}
		else if (tipo.equals("ACTUALIZAR"))
			actualizar(request, response);
		else if (tipo.equals("ELIMINAR"))
			eliminar(request, response);
		else if (tipo.equals("BUSCAR"))
			buscar(request, response);
		else if (tipo.equals("LISTAR"))
			listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<InformeInstalacion> lista = servicioInformeInstalacion.listar();
		
		JsonArrayBuilder arreglo = Json.createArrayBuilder();
		
		for(InformeInstalacion bean:lista) {
			JsonObject obj = Json.createObjectBuilder().add("codigo", bean.getCodigo()).
														add("lugar", bean.getLugar()).
														add("area", bean.getNombreArea()).
														add("fechaInstalacion", sdf.format(bean.getFechaInstalacion())).
														add("horaInstalacion", sdf.format(bean.getHoraInstalacion())).
														add("estado", bean.getEstado()).build();
			arreglo.add(obj);
		}
		
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter salida = response.getWriter();
		salida.println(arreglo.build());
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		InformeInstalacion bean;
		String cod;
		cod = request.getParameter("codigo");
		bean = servicioInformeInstalacion.buscar(Integer.parseInt(cod));
		request.setAttribute("InformeInstalacion", bean);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
//		String cod, lug, area, fecIn, horIn;
//		cod = request.getParameter("codigo");
//		lug = request.getParameter("lugar");
//		area = request.getParameter("area");
//		fecIn = request.getParameter("fechaInstalacion");
//		horIn = request.getParameter("horaInstalacion");
//		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String lug, area, fecIn, horIn;
		lug = request.getParameter("lugar");
		area = request.getParameter("area");
		fecIn = request.getParameter("fechaInstalacion");
		horIn = request.getParameter("horaInstalacion");


//		Convertir una cadena a Date.util y luego lo convierte Date.sql
		Date sqlFecIn = new Date(sdf.parse(fecIn).getTime());

//		Convertir una cadena a Date.util y luego lo convierte Time.sql
		Time sqlHorIn = new Time(sdf2.parse(horIn).getTime());

		InformeInstalacion bean = new InformeInstalacion();

		bean.setLugar(lug);
		bean.setNombreArea(area);
		bean.setFechaInstalacion(sqlFecIn);
		bean.setHoraInstalacion(sqlHorIn);

		int salida = servicioInformeInstalacion.registrar(bean);
		if (salida != -1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");

		request.getRequestDispatcher("/informeInstalacion.jsp").forward(request, response);
	}

}
