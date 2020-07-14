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

import net.consorcio.entidad.Proveedor;
import net.consorcio.service.ProveedorService;



@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
	private ProveedorService servicioProveedor;
	
       
  
    public ServletProveedor() {
    	
        super();
        servicioProveedor=new ProveedorService();
        
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
		List<Proveedor> lista=servicioProveedor.listar();
		//crear un objeto que contenga todo el JSON
		JsonArrayBuilder arreglo=Json.createArrayBuilder();
		//bucle
		//getDescripcion()
		for(Proveedor bean: lista) {
			//crear cada fila
			JsonObject obj=Json.createObjectBuilder().add("codigo", bean.getRuc()).
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


	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Proveedor bean;
		String cod;
		cod=request.getParameter("codigo");
		bean=servicioProveedor.buscar(Integer.parseInt(cod));
		request.setAttribute("proveedor", bean);
		//direccionar a la pàgina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizarProveedor.jsp").forward(request, response);
		
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod;
		cod=request.getParameter("codigo");
		
		int salida=servicioProveedor.eliminar(Integer.parseInt(cod));
		
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Registro eliminado correctamente");
		else
			request.setAttribute("MENSAJE", "Error en la eliminacionr del registro");
		//direccionar a la pàgina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/actualizarProveedor.jsp").forward(request, response);
		
	}


	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
				String cod,nom,ape,tel,ema;
				cod=request.getParameter("codigo");
				nom=request.getParameter("nombre");
				ape=request.getParameter("apellido");
				tel=request.getParameter("telefono");
				ema=request.getParameter("email");
				//crear un objeto de la clase Docente
				Proveedor bean=new Proveedor();
				//setear los atributos del objeto "bean"
				bean.setRuc(Integer.parseInt(cod));
				bean.setNombre(nom);
				bean.setApellido(ape);
				bean.setTelefono(tel);
				bean.setEmail(ema);
				
				//invocar al mètodo registrarDocente
				int salida=servicioProveedor.actualizar(bean);
				if(salida!=-1)
					request.setAttribute("MENSAJE", "Registro actualizado correctamente");
				else
					request.setAttribute("MENSAJE", "Error al actualizar el registro");
				//direccionar a la pàgina docente.jsp y enviar el atributo MENSAJE 
				request.getRequestDispatcher("/actualizarProveedor.jsp").forward(request, response);
		
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables para alacenar los valores de la cajas, utilizar la propiedad name de cada control
		String cod,nom,ape,tel,ema;
		cod=request.getParameter("codigo");
		nom=request.getParameter("nombre");
		ape=request.getParameter("apellido");
		tel=request.getParameter("telefono");
		ema=request.getParameter("email");
		//crear un objeto de la clase Docente
		Proveedor bean=new Proveedor();
		//setear los atributos del objeto "bean"
		bean.setRuc(Integer.parseInt(cod));
		bean.setNombre(nom);
		bean.setApellido(ape);
		bean.setTelefono(tel);
		bean.setEmail(ema);
		
		//invocar al mètodo registrarDocente
		int salida=servicioProveedor.registrar(bean);
		if(salida!=-1)
			request.setAttribute("MENSAJE", "Se registro correctamente");
		else
			request.setAttribute("MENSAJE", "Error en el registro");
		//direccionar a la pàgina docente.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/proveedor.jsp").forward(request, response);
		
	}

}
