package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.RequerimientoDAO;

public class RequerimientoService {
	
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	RequerimientoDAO daoRequerimiento=dao.getRequerimientoDAO();
	
	public Requerimiento buscar(int cod) {
		return daoRequerimiento.fin(cod);
	}
	public List<Requerimiento> listar(){
		return daoRequerimiento.listAll();
	}
	public int registrar(Requerimiento bean) {
		return daoRequerimiento.save(bean);
	}
	public int actualizar(Requerimiento bean) {
		return daoRequerimiento.update(bean);
	}
	public int eliminar(int cod) {
		return daoRequerimiento.delete(cod);
	}

}
