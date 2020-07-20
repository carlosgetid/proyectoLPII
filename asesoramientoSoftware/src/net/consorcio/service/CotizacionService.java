package net.consorcio.service;



import java.util.List;

import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;
import net.consorcio.entidad.Proveedor;
import net.consorcio.entidad.Software;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.CotizacionDAO;
import net.consorcio.interfaces.ProveedorDAO;
import net.consorcio.interfaces.SoftwareDAO;

public class CotizacionService {
	
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	ProveedorDAO daoProveedor=dao.getProveedorDAO();
	SoftwareDAO daoSoftware=dao.getSoftwareDAO();
	CotizacionDAO daoCotizacion=dao.getCotizacionDAO();
	
	public List<Proveedor> listarProveedorXApellido(String ape) {
		return daoProveedor.listProveedorXApellidos(ape);
	}

	public List<Software> listarSoftwareXNombre(String nom){
		return daoSoftware.listSoftwareXNombre(nom);
	}
	
	public int adicionarCotizacion(Cotizacion bean,List<Detalle> lista) {
		return daoCotizacion.registrarCotizacion(bean, lista);
		
	}
}
