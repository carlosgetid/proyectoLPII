package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.InformeInstalacion;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.InformeInstalacionDAO;

public class InformeInstalacionService {
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	InformeInstalacionDAO daoInformeInstalacion=dao.getInformeInstalacionDAO();
	
	public InformeInstalacion buscar(int cod) {
		return daoInformeInstalacion.find(cod);
	}
	public List<InformeInstalacion> listar(){
		return daoInformeInstalacion.listAll();
	}
	public int registrar(InformeInstalacion bean) {
		return daoInformeInstalacion.save(bean);
	}
	public int actualizar(InformeInstalacion bean) {
		return daoInformeInstalacion.update(bean);
	}
	public int eliminar(int cod) {
		return daoInformeInstalacion.delete(cod);
	}
}
