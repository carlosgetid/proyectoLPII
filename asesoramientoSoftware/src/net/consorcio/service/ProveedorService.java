package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Proveedor;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.ProveedorDAO;

public class ProveedorService {

	
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	ProveedorDAO daoProveedor=dao.getProveedorDAO();
	
	
	public Proveedor buscar(long cod) {
		return daoProveedor.fin(cod);
		
	}
	public List<Proveedor> listar(){
		
		return daoProveedor.listAll();
	}
	public int registrar(Proveedor bean) {
		
		return daoProveedor.save(bean);
		
	}
	public int actualizar(Proveedor bean) {
		return daoProveedor.update(bean);
		
	}
	
	public int eliminar(long cod) {
		return daoProveedor.delete(cod);
	}
	
	
}
