package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.InformeTecnico;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.InformeDAO;

public class InformeService {

	DAOFactory dao=DAOFactory.getDAOFactory(1);
	InformeDAO daoInforme=dao.getInformeDAO();
	
	
	public InformeTecnico buscar(int cod) {
		return daoInforme.find(cod);
	}
	public List<InformeTecnico> listar(){
		return daoInforme.listAll();
	}
	public int registrar(InformeTecnico bean) {
		return daoInforme.save(bean);
	}
	public int actualizar(InformeTecnico bean) {
		return daoInforme.update(bean);
	}
	public int eliminar(int cod) {
		return daoInforme.delete(cod);
	}
}
