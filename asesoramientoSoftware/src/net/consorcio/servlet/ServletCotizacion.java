package net.consorcio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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



import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;
import net.consorcio.entidad.Proveedor;
import net.consorcio.entidad.Software;
import net.consorcio.entidad.Usuario;
import net.consorcio.service.CotizacionService;


@WebServlet("/ServletCotizacion")
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private CotizacionService cotizacionService;
    public ServletCotizacion() {
     
    	super();
    	cotizacionService=new CotizacionService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo=request.getParameter("accion");
		if(tipo.equals("CONSULTA_PROVEEDOR"))
			consultaProveedor(request,response);
		else if(tipo.equals("CONSULTA_SOFTWARE"))
			consultaSoftware(request,response);
		else if(tipo.equals("ADICIONAR_SOFTWARE"))
			adicionarSoftware(request,response);
		else if(tipo.equals("REGISTRAR_COTIZACION"))
			registrarCotizacion(request,response);
	}


	private void registrarCotizacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod,rucPro,codUsu;
		double monto=0;
		//objeto tipo sesion
		HttpSession session=request.getSession();
		//recuperar el atributo usuario
		Usuario usu=(Usuario) session.getAttribute("usuario");
		cod=request.getParameter("numero");
		rucPro=request.getParameter("codigo"); 
	
		
		//crear un objeto de la clase boleta "CABECERA"
		Cotizacion cot=new Cotizacion();
		cot.setCodigo(Integer.parseInt(cod));
		cot.setRucPro(Long.parseLong(rucPro));
		cot.setCodUsu(usu.getCodigo());	
		
		
		//obtener la suma de importes   
		
		List<Detalle> lista=(List<Detalle>) session.getAttribute("detalle");
		for(Detalle det: lista) 
			monto+=det.getImporte();
			
		cot.setMonto(monto);
		//DETALLE
		//es el arreglo de objeto "lista"
		cotizacionService.adicionarCotizacion(cot, lista);
		//actualizar el atributo detalle
		lista.clear();
		session.setAttribute("detalle", lista);
		response.sendRedirect("cotizacion.jsp");
	}


	private void adicionarSoftware(HttpServletRequest request, HttpServletResponse response) throws IOException {
	//Objeto tipo sesion
		HttpSession session=request.getSession();
	String cod,nom,pre,can;
	cod=request.getParameter("codigo");
	nom=request.getParameter("nombre");
	pre=request.getParameter("precio");
	can=request.getParameter("cantidad");
	
	//declarar una lista de detalle
	List<Detalle> lista;
	//validar si existe el atributo detalle dentro de una sesion
	if(session.getAttribute("detalle")==null)
		//crear lista
		lista=new ArrayList<Detalle>();
	else
		//recuperar el valor del atributo detalle y enviar su contenido al arreglo lista
		lista=(List<Detalle>) session.getAttribute("detalle");
	
	//crear objeto de la clase detalle
	
	Detalle det= new Detalle();
	det.setCodigo(Integer.parseInt(cod));
	det.setNombre(nom);
	det.setPrecio(Double.parseDouble(pre));
	det.setCantidad(Integer.parseInt(can));
	
	//enviar objeto det a la lista
	 lista.add(det);
	 //crear o actualizar el atributo detalle
	 session.setAttribute("detalle", lista);
	 
	 JsonArrayBuilder arreglo=Json.createArrayBuilder();
		//bucle
		//getDescripcion()
		for(Detalle bean: lista) {
			//crear cada fila
			JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
													  add("nombre",bean.getNombre()).
													  add("precio", bean.getPrecio()).
													  add("cantidad", bean.getCantidad()).
													  add("importe", bean.getImporte()).build();
													  
			//enviar el objeto "obj" al arreglo
			arreglo.add(obj);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(arreglo.build());
		
		
	}


	private void consultaSoftware(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nom=request.getParameter("nombre");
		
		List<Software> lista=cotizacionService.listarSoftwareXNombre(nom);
		//crear un objeto que contenga todo el JSON
		JsonArrayBuilder arreglo=Json.createArrayBuilder();
		//bucle
		//getDescripcion()
		for(Software bean: lista) {
			//crear cada fila
			JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
													  add("nombre",bean.getNombre()).
													  add("precio", bean.getPrecio()).build();
													  
			//enviar el objeto "obj" al arreglo
			arreglo.add(obj);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(arreglo.build());
		 
	}


	private void consultaProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ape=request.getParameter("apellido");
		
				List<Proveedor> lista=cotizacionService.listarProveedorXApellido(ape);
				//crear un objeto que contenga todo el JSON
				JsonArrayBuilder arreglo=Json.createArrayBuilder();
				//bucle
				//getDescripcion()
				for(Proveedor bean: lista) {
					//crear cada fila
					JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getCodigo()).
															  add("nombre",bean.getNombre()).
															  add("apellido", bean.getApellido()).
															  add("telefono", bean.getTelefono()).
															  add("email", bean.getEmail()).build();
															  
					//enviar el objeto "obj" al arreglo
					arreglo.add(obj);
				}
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter salida=response.getWriter();
				salida.println(arreglo.build());
		
	}

}
